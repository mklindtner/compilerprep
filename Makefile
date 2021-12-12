antlr4 = java org.antlr.v4.Tool
grun   = java org.antlr.v4.gui.TestRig

SRCFILES = main.java Environment.java AST.java
GENERATED = implParser.java implBaseVisitor.java implVisitor.java implLexer.java

all:
	make main.class

main.class:	$(SRCFILES) $(GENERATED) impl.g4
	javac  $(SRCFILES) $(GENERATED)

implParser.java:	impl.g4
	$(antlr4) -visitor impl.g4

test:	main.class
	java main struct.impl > struct.ll
	cat struct.ll
	clang -O3 struct.ll
	./a.out

