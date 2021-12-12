import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

class faux{ // collection of non-OO auxiliary functions (currently just error)
    public static void error(String msg){
	System.err.println("Interpreter error: "+msg);
	System.exit(-1);
    }
}

abstract class AST{};

abstract class Expr extends AST{
    abstract public String typecheck(Symtab env);
    abstract public String compile(Symtab env);
};

class Specification extends Expr{
    public String structname;
    public List<Assignment> assigns;
    Specification(String structname, List<Assignment> assigns){
	this.structname=structname;
	this.assigns=assigns;
    };
    
    public String typecheck(Symtab env){
	if (!env.hasType(structname)){ // Have we seen this before?
	    env.setType(structname,structname);
	    env.setVariable(structname,assigns.size());
	    int counter=0;
	    for(Assignment a:assigns){
		env.setType(structname+"."+a.x,a.e.typecheck(env));
		env.setVariable(structname+"."+a.x,counter++);
	    }
	}
	return structname;
    };
    
    public String compile(Symtab env){
	int size=env.getVariable(structname);
	String r=env.newvar();
	String rt=env.newvar();
	String code=
	    r+" = call i8* @malloc(i64 "+8*size+")\n"
	    +rt+" = bitcast i8* "+r+" to double*\n"; 
	for(Assignment a:assigns){
	    code+=a.e.compile(env);
	    String type=a.e.typecheck(env);
		    
	    String re = env.getvar();
	    String ra = env.newvar();
	    String fieldname=structname+"."+a.x;
	    if (type.equals("double")){
		code+=
		    ra+" = getelementptr inbounds double, double* "+rt+
		    ", i64 "+env.getVariable(fieldname)+"\n"+
		    "store double "+re+", double* "+ra+"\n";
	    }
	    else{
		String rat = env.newvar();
		code+=
		    ra+" = getelementptr inbounds double, double* "+rt+
		    ", i64 "+env.getVariable(fieldname)+"\n"+
		    rat+" = bitcast double* "+ra+" to i8**\n"+
		    "store i8* "+re+", i8** "+rat+"\n";
	    }
	}
	String result=env.newvar();
	return code+result+" = bitcast double* "+rt+" to i8*\n";
    }
}

class Addition extends Expr{
    public Expr e1,e2;
    Addition(Expr e1,Expr e2){this.e1=e1; this.e2=e2;}
    public String typecheck(Symtab env){
	if (!e1.typecheck(env).equals("double") ||
	    !e2.typecheck(env).equals("double"))
	    faux.error("Type error in Addition");
	return "double";
    };    
    public String compile(Symtab env){
	String s1=e1.compile(env);
	String r1=env.getvar();
	String s2=e2.compile(env);
	String r2=env.getvar();
	String r3=env.newvar();
	return
	    s1+s2+
	    r3+" = fadd double "+r1+", "+r2+"\n";
    };
}

class Subtraction extends Expr{
    public Expr e1,e2;
    Subtraction(Expr e1,Expr e2){this.e1=e1; this.e2=e2;}
    public String typecheck(Symtab env){
	if (!e1.typecheck(env).equals("double") ||
	    !e2.typecheck(env).equals("double"))
	    faux.error("Type error in Subtraction");
	return "double";
    }
    public String compile(Symtab env){
	String s1=e1.compile(env);
	String r1=env.getvar();
	String s2=e2.compile(env);
	String r2=env.getvar();
	String r3=env.newvar();
	return
	    s1+s2+
	    r3+" = fsub double "+r1+", "+r2+"\n";
    };
}

class Multiplication extends Expr{
    public Expr e1,e2;
    Multiplication(Expr e1,Expr e2){this.e1=e1; this.e2=e2;}
    public String typecheck(Symtab env){
	if (!e1.typecheck(env).equals("double") ||
	    !e2.typecheck(env).equals("double"))
	    faux.error("Type error in Multiplication");
	return "double";
    };    
    public String compile(Symtab env){
	String s1=e1.compile(env);
	String r1=env.getvar();
	String s2=e2.compile(env);
	String r2=env.getvar();
	String r3=env.newvar();
	return
	    s1+s2+
	    r3+" = fmul double "+r1+", "+r2+"\n";
    };
}

class Division extends Expr{
    public Expr e1,e2;
    Division(Expr e1,Expr e2){this.e1=e1; this.e2=e2;}
    public String typecheck(Symtab env){
	if (!e1.typecheck(env).equals("double") ||
	    !e2.typecheck(env).equals("double"))
	    faux.error("Type error in Division");
	return "double";
    };    
    public String compile(Symtab env){
	String s1=e1.compile(env);
	String r1=env.getvar();
	String s2=e2.compile(env);
	String r2=env.getvar();
	String r3=env.newvar();
	return
	    s1+s2+
	    r3+" = fdiv double "+r1+", "+r2+"\n";
    };
}

class Constant extends Expr{
    public Double value;
    Constant(Double value){this.value=value;}
    public String typecheck(Symtab env){ return "double"; };    
    public String compile(Symtab env){
	return env.newvar()+" = fadd double "+value+", 0.0\n";
    };
}

class Variable extends Expr{
    public String name;
    Variable(String name){this.name=name;}
    public String typecheck(Symtab env){
	return env.getType(name);
    };
    public String compile(Symtab env){
	String type=env.getType(name);
	if(!type.equals("double")) type="i8*";	    

	return env.newvar()+" = load "+type+", "+type+"* %"+name+"\n";
    };
    
}

class Access extends Expr{
    public String base;
    public List<String> as;
    Access(String base, List<String> as){this.base=base; this.as=as;};
    public String typecheck(Symtab env){
	String type=env.getType(base);
	for(String a:as){
	    type=env.getType(type+"."+a);
	}
	return type;
    }
    public String compile(Symtab env){
	String ra0 = env.newvar();
	String code=ra0+" = load i8*, i8** %"+base+"\n";
	String ra = env.newvar();
	code+=ra+" = bitcast i8* "+ra0+" to double*\n";
	String type=env.getType(base);
	for(String a:as){
	    int offset = env.getVariable(type+"."+a);
	    type=env.getType(type+"."+a);
	    
	    String ra_new = env.newvar();
	    code+=ra_new+" = getelementptr inbounds double, double* "+ra+
		", i64 "+offset+"\n";

	    if (type.equals("double"))
		code+=env.newvar()+" = load double, double* "+ra_new+"\n";
	    else{
		String rat = env.newvar();
		String rl = env.newvar();
		String rlt = env.newvar();
		code+=rat+" = bitcast double* "+ra_new+" to i8**\n"
		    +rl+" = load i8*, i8** "+rat+"\n"
		    +rlt+" = bitcast i8* "+rl+" to double*\n";
		ra=rlt;
	    }
	}
	return code;
    }
}

class Array extends Expr{
    public String a;
    public Expr index;
    Array(String a, Expr index){this.a=a; this.index=index;}
    public String typecheck(Symtab env){
	if(!index.typecheck(env).equals("double")
	   || !env.getType(a).equals("array"))
	    faux.error("Type error in array");
	return "double";
    }
    public String compile(Symtab env){
	String code=index.compile(env);
	String ri = env.getvar();
	String ri_int = env.newvar();
	String ra = env.newvar();
	return
	    code+
	    ri_int+" = fptosi double "+ri+" to i64\n"+
	    ra+" = getelementptr inbounds double, double* %"+a+", i64 "+ri_int+"\n"+
	    env.newvar()+" = load double, double* "+ra+"\n";
    }
}

abstract class Condition extends AST{
    abstract public String typecheck(Symtab env);
    abstract public String compile(Symtab env);
};

class Unequal extends Condition{
    public Expr e1,e2;
    Unequal(Expr e1,Expr e2){this.e1=e1; this.e2=e2;}
    public String typecheck(Symtab env){
	if(!e1.typecheck(env).equals("double")
	   ||!e2.typecheck(env).equals("double"))
	    faux.error("Type error in unequal");
	return "i1";
    };    
    public String compile(Symtab env){
	String s1=e1.compile(env);
	String r1=env.getvar();
	String s2=e2.compile(env);
	String r2=env.getvar();
	String r3=env.newvar();
	return
	    s1+s2+
	    r3+" = fcmp one double "+r1+", "+r2+"\n";
    };
}
class Equal extends Condition{
    public Expr e1,e2;
    Equal(Expr e1,Expr e2){this.e1=e1; this.e2=e2;}
    public String typecheck(Symtab env){
	if(!e1.typecheck(env).equals("double")
	   ||!e2.typecheck(env).equals("double"))
	    faux.error("Type error in Equal");
	return "i1";
    };    
    public String compile(Symtab env){	
	String s1=e1.compile(env);
	String r1=env.getvar();
	String s2=e2.compile(env);
	String r2=env.getvar();
	String r3=env.newvar();
	return
	    s1+s2+
	    r3+" = fcmp oeq double "+r1+", "+r2+"\n";
    };
}

class Smaller extends Condition{
    public Expr e1,e2;
    Smaller(Expr e1,Expr e2){this.e1=e1; this.e2=e2;}
    public String typecheck(Symtab env){
	if(!e1.typecheck(env).equals("double")
	   ||!e2.typecheck(env).equals("double"))
	    faux.error("Type error in Smaller");
	return "i1";
    };    
    public String compile(Symtab env){	
	String s1=e1.compile(env);
	String r1=env.getvar();
	String s2=e2.compile(env);
	String r2=env.getvar();
	String r3=env.newvar();
	return
	    s1+s2+
	    r3+" = fcmp olt double "+r1+", "+r2+"\n";
    };
}

class Conjunction extends Condition{
    public Condition c1,c2;
    Conjunction(Condition c1,Condition c2){this.c1=c1; this.c2=c2;}
    public String typecheck(Symtab env){
	if(!c1.typecheck(env).equals("i1")
	   ||!c2.typecheck(env).equals("i1"))
	    faux.error("Type error");
	return "i1";
    };    
    public String compile(Symtab env){
	faux.error("Conjunction not yet implemented!");
	return null;
    };
    
}

class Disjunction extends Condition{
    public Condition c1,c2;
    Disjunction(Condition c1,Condition c2){this.c1=c1; this.c2=c2;}
    public String typecheck(Symtab env){
	if(!c1.typecheck(env).equals("i1")
	   ||!c2.typecheck(env).equals("i1"))
	    faux.error("Type error");
	return "i1";
    };    
    public String compile(Symtab env){
	faux.error("Disjunction not yet implemented!");
	return null;
    };
    
}
class Negation extends Condition{
    public Condition c;
    Negation(Condition c){this.c=c;}
    public String typecheck(Symtab env){
	if(!c.typecheck(env).equals("i1"))
	    faux.error("Type error");
	return "i1";
    };    
    public String compile(Symtab env){
	faux.error("Negation not yet implemented!");
	return null;
    };
    
}

abstract class Command extends AST{
    abstract public void typecheck(Symtab env);
    abstract public String compile(Symtab env);
};

	     
class Assignment extends Command{
    public String x;
    public Expr e;
    Assignment(String x, Expr e){this.x=x; this.e=e;}
    public void typecheck(Symtab env){
	if(!env.hasType(x)){
	    env.setType(x,e.typecheck(env));
	}
	else{
	    if (!env.getType(x).equals(e.typecheck(env)))
		faux.error("Type error");
	}
    }
    public String compile(Symtab env){
	String type=env.getType(x);
	if(!type.equals("double")) type="i8*";	    
	String s="";
	if(!env.hasVariable(x)){
	    s="%"+x+" = alloca "+type+"\n";
	    env.setVariable(x,1);
	}
	return s+e.compile(env)+
	    "store "+type+" "+env.getvar()+", "+type+"* %"+x+"\n";
    };
}

class StructAccess extends Command{
    public Access as;
    public Expr e;
    StructAccess(Access as,  Expr e){this.as=as; this.e=e;}
    public void typecheck(Symtab env){
	if(!as.typecheck(env).equals(e.typecheck(env)))
	    faux.error("Type error!");
    }
    public String compile(Symtab env){
	String ra0 = env.newvar();
	String code=ra0+" = load i8*, i8** %"+as.base+"\n";
	String ra = env.newvar();
	code+=ra+" = bitcast i8* "+ra0+" to double*\n";
	String type=env.getType(as.base);
	for(String a:as.as){
	    int offset = env.getVariable(type+"."+a);
	    type=env.getType(type+"."+a);
	    
	    String ra_new = env.newvar();
	    code+=ra_new+" = getelementptr inbounds double, double* "+ra+
		", i64 "+offset+"\n";

	    if (type.equals("double"))
		code+=env.newvar()+" = load double, double* "+ra_new+"\n";
	    else{
		String rat = env.newvar();
		String rl = env.newvar();
		String rlt = env.newvar();
		code+=rat+" = bitcast double* "+ra_new+" to i8**\n"
		    +rl+" = load i8*, i8** "+rat+"\n"
		    +rlt+" = bitcast i8* "+rl+" to double*\n";
		ra=rlt;
	    }
	}	
	code+=e.compile(env);
	String eresult=env.getvar();
	return code+"store double "+eresult+", double* "+ra+"\n";
    }
};

class ArrayAssignment extends Command{
    public String x;
    public Expr index;
    public Expr e;
    ArrayAssignment(String x, Expr index, Expr e){this.x=x; this.e=e; this.index=index;}
    public void typecheck(Symtab env){
	if (!index.typecheck(env).equals("double")
	    || !env.getType(x).equals("array")
	    || !e.typecheck(env).equals("double"))
	    faux.error("Type error");
    }
    public String compile(Symtab env){
	String code=index.compile(env);
	String ri = env.getvar();
	code=code+e.compile(env);
	String re = env.getvar();
	String ri_int = env.newvar();
	String ra = env.newvar();
	return
	    code+
	    ri_int+" = fptosi double "+ri+" to i64\n"+
	    ra+" = getelementptr inbounds double, double* %"+x+", i64 "+ri_int+"\n"+
	    "store double "+re+", double* "+ra+"\n";
    };
}

class Output extends Command{
    public Expr e;
    Output(Expr e){this.e=e;}
    public void typecheck(Symtab env){
	if(!e.typecheck(env).equals("double"))
	    faux.error("Type error");
    }
    public String compile(Symtab env){
	return e.compile(env)+
	    "call void @print(double "+env.getvar()+")\n";
    };
}

class While extends Command{
    public Condition c;
    public Command body;
    While(Condition c, Command body){this.c=c; this.body=body;}
    public void typecheck(Symtab env){
	if (!c.typecheck(env).equals("i1"))
	    faux.error("Type error");
	body.typecheck(env);
    }
    public String compile(Symtab env){
	String start=env.newlabel();
	String krop=env.newlabel();
	String end=env.newlabel();
	return
	    "br label %"+start+"\n\n"+
	    start+":\n"+
	    c.compile(env)+
	    "br i1 "+env.getvar()+", label %"+krop+", label %"+end+"\n\n"+
	    krop+":\n"+
	    body.compile(env)+
	    "br label %"+start+"\n\n"+
	    end+":\n";
    };
}

class Sequence extends Command{
    public Command c1,c2;
    Sequence(Command c1,Command c2){this.c1=c1; this.c2=c2;}
    public void typecheck(Symtab env){
	c1.typecheck(env);
	c2.typecheck(env);
    }
    public String compile(Symtab env){
	return c1.compile(env)+c2.compile(env); 
    };
}

class Nop extends Command{
    Nop(){};
    public void typecheck(Symtab env){};
    public String compile(Symtab env){
	return "";
    };
}

class If extends Command{
    public Condition c;
    public Command p;
    If(Condition c, Command p){this.c=c; this.p=p;}
    public void typecheck(Symtab env){
	if (!c.typecheck(env).equals("i1")) faux.error("Type error");
	p.typecheck(env);
    }
    public String compile(Symtab env){
	String thenl=env.newlabel();
	String end=env.newlabel();
	return
	    c.compile(env)+
	    "br i1 "+env.getvar()+", label %"+thenl+", label %"+end+"\n\n"+
	    thenl+":\n"+
	    p.compile(env)+
	    "br label %"+end+"\n\n"+
	    end+":\n";
    }
}

class Declaration extends Command{
    String arrayname;
    int size;
    Declaration(String arrayname,int size){this.arrayname=arrayname; this.size=size;}
    public void typecheck(Symtab env){
	if(env.hasType(arrayname))
	    faux.error("Array already declared");
	env.setType(arrayname,"array");
    }
    public String compile(Symtab env){
	String r=env.newvar();
	return
	    r+" = call i8* @malloc(i64 "+8*size+")\n"
	    +"%"+arrayname+" = bitcast i8* "+r+" to double*\n"; 
    }
}

