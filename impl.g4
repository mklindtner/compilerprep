grammar impl;

/* A small imperative language */

start   :  decs+=declaration* cs+=command* EOF ;

declaration : 'declare' x=ID '[' c=FLOAT ']' ;

program : c=command                      # SingleCommand
	| '{' cs+=command* '}'           # MultipleCommands
	;
	
command : l=assign ';'                   # Assignment
	| 'output' e=expr ';'            # Output
        | 'while' '('c=condition')' p=program  # WhileLoop
	| 'for' '(' x=ID '=' e1=expr '..' e2=expr ')' p=program # ForLoop
	| 'if' '(' c=condition ')' p=program # If
	;

lhs     : x=ID                    # Variable
	| a=ID '[' e=expr ']'     # Array
	| base=ID ('.' as+=ID)*    # Access
	;

assign : l=lhs '=' e=expr ;

expr	: e1=expr o=OP1 e2=expr # Addition
	| e1=expr o=OP2 e2=expr # Multiplication
	| c=FLOAT     	      # Constant
	| l=lhs		      # Lefthandside
	| structname=ID '{' (fields+=assign (',' fields+=assign)*)? '}'  # Specification
	| '(' e=expr ')'      # Parenthesis
	;

condition : e1=expr '!=' e2=expr # Unequal
	  | e1=expr '==' e2=expr # Equal
	  | e1=expr '<' e2=expr # Smaller
	  | c1=condition '||' c2=condition # Disjunction
	  | c1=condition '&&' c2=condition # Conjunction
	  | '!' c=condition     # Negation
	  | '(' c=condition ')' # ParenthesisCondition
	  ;  

ID    : ALPHA (ALPHA|NUM)* ;
FLOAT : NUM+ ('.' NUM+)? ;

ALPHA : [a-zA-Z_ÆØÅæøå] ;
NUM   : [0-9] ;

OP1   : '+' | '-' ;
OP2   : '*' | '/' ;

WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT    : '//'~[\n]*  -> skip;
COMMENT2   : '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
