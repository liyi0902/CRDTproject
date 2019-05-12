# Editor project 
This is a collaborative editor for comp90020 group work, implementing a crdt structure 
calling logoot.

## How to run it?

The program has 5 arguments.
lp ———— local port
rp ———— remote port
lh ———— local hostname (default value = localhost)
rh ———— remote hostname
u ———— process id      (default value = random uuid)

Assume you want to launch three process,you can start in following sequence if you test
the program only in one computer:

java -jar editor.jar -lh localhost -lp 8000 -u user1
java -jar editor.jar -lh localhost -lp 8001 -rp 8000 -rh localhost -u user2 
java -jar editor.jar -lh localhost -lp 8002 -rp 8001 -rh localhost -u user3

The editor.jar is in the editor/target,you must change directory to this path before 
launching the program.
Here you can modify the the arguments as whatever you want to adapt different test 
environment.
