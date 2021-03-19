#!bash
#orbd -ORBInitialPort 1051 -ORBInitialHost localhost&

javac client/HasherClient.java -Xlint:unchecked

java client.HasherClient -ORBInitialPort 1050 -ORBInitialHost localhost
