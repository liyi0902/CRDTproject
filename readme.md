# Editor project 
This is a collaborative editor for comp90020 group work, implementing a crdt structure 
calling logoot.

## How to run it?

The program has 5 arguments.  
lp ———— local port  
rp ———— remote port  
lh ———— local hostname (selected,default value = localhost)  
rh ———— remote hostname  
u ———— process id (selected, default value = random uuid)  

Assume you want to launch three process,you can start in following sequence if you test
the program only in one computer:  

java -jar editor.jar -lh localhost -lp 8000 -u user1  
java -jar editor.jar -lh localhost -lp 8001 -rp 8000 -rh localhost -u user2   
java -jar editor.jar -lh localhost -lp 8002 -rp 8001 -rh localhost -u user3  

The editor.jar is in editor/target,you must change directory to this path before 
launching the program.  
Here you can modify the the arguments as whatever you want to adapt different test 
environment.  

## Code structure

The code in algorithm/logoot package is the crdt structure we use. It comes from the paper
"Logoot-Undo: Distributed Collaborative Editing System on P2P networks" and "Logoot: 
A Scalable Optimistic Replication Algorithm for Collaborative Editing on P2P Networks".
The code in algorithm/treedoc package is another structure we have ever tried. But these
code is not completed and we give up since some problems.  

The code in controller package is control layer of the project.  

The code in message package is the message and handlers we defined in process communication.
When a process receive certain message, it will process the message by using corresponding 
handlers.  

The code in network package is the TCP connection frame of our project. In our project,
each process can act as both a server or client.  


The code in utils provides the methods to cope with json converting, file reading/writing 
and generating unique id for each process of the distributed system.

The code in view package is the front end of our editor.  

The Main class is the entrance of our project and the Configuration class is the global
configuration of the program.


## About the code
The network connection part of this project re-use some codes from my distributed system
lecture group project in 2018 semester 1. 