import java.util.HashMap;
import java.util.Map.Entry;

class Symtab {
    private HashMap<String,Integer> variableValues = new HashMap<String,Integer>();
    private HashMap<String,String> typeMap = new HashMap<String,String>();
    int placecounter=1;
    public String newvar(){ return "%"+placecounter++; }
    public String getvar(){ return "%"+(placecounter-1);}
    int labelcounter=1;
    public String newlabel(){ return "Label"+labelcounter++; }
    public String getlabel(){ return "Label"+(labelcounter-1); }
    public Symtab() { }	
    public void setVariable(String name, Integer value) {
	variableValues.put(name, value);
    }
    
    public Integer getVariable(String name){
	Integer value = variableValues.get(name); 
	if (value == null) faux.error("Variable not defined: "+name); 
	return value;
    }
    public Boolean hasVariable(String name){
	Integer value = variableValues.get(name); 
	return (value != null) ;
    }

    public void setType(String name, String type){
	typeMap.put(name,type);
    }
    public String getType(String name){
	String type=typeMap.get(name);
	if (type == null) faux.error("Type undefined for: "+name);
	return type;
    }
    public Boolean hasType(String name){
	String type = typeMap.get(name); 
	return (type != null) ;
    }
}


class Environment {
    private HashMap<String,Double> variableValues = new HashMap<String,Double>();

    public Environment() { }	
    public void setVariable(String name, Double value) {
	variableValues.put(name, value);
    }
    
    public Double getVariable(String name){
	Double value = variableValues.get(name); 
	if (value == null) { System.err.println("Variable not defined: "+name); System.exit(-1); }
	return value;
    }
    
    public String toString() {
	String table = "";
	for (Entry<String,Double> entry : variableValues.entrySet()) {
	    table += entry.getKey() + "\t-> " + entry.getValue() + "\n";
	}
	return table;
    }   
}

