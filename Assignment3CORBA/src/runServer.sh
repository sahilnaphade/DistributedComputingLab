#!bash
#orbd -ORBInitialPort 1051 -ORBInitialHost localhost&

javac hasherServer/HasherServer.java -Xlint:unchecked

java hasherServer.HasherServer -ORBInitialPort 1050 -ORBInitialHost localhost&
