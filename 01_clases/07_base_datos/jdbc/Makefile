JFLAGS = -g -encoding ISO8859_1
JC = javac
JVM= java 
DRIVER=MySQL_Driver/mysql-connector-java-5.1.34-bin.jar
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = CreaLLenaTabla.java \
          ConsultasClientesBanco.java \
          Pacientes.java

classes: $(CLASSES:.java=.class)

CreaLLenaTabla: CreaLLenaTabla.class
	$(JVM) -cp $(DRIVER):. CreaLLenaTabla

ConsultasClientesBanco: ConsultasClientesBanco.class
	$(JVM) -cp $(DRIVER):. ConsultasClientesBanco

Pacientes: Pacientes.class
	$(JVM) -cp $(DRIVER):. Pacientes
clean:
	rm -f *.class
