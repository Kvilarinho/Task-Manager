# TaskManager (Console Application)

A simple console-based Task Manager built in Java.  
It allows adding, listing, completing, and deleting tasks with automatic persistence in a text file.

## Features

- ADD <description> – Add a new task (incomplete by default).  
- LST – List all tasks.  
- DONE <id> – Mark a task as completed.  
- DEL <id> – Delete a task.  
- HELP – Show all available commands.  
- EXIT – Exit the application.  

## Storage format

Tasks are stored in the file `tasks.dat` in a simple text format:

[ ] id: 1 - Buy milk  
[X] id: 2 - Study sockets  

- [ ] → incomplete  
- [X] → completed  

Task IDs are stable and persisted separately in `id.dat`.  

## How to run

1. Clone the repository:  
   git clone https://github.com/<your-username>/taskmanager.git  
   cd taskmanager  

2. Build with Maven:  
   mvn package  

3. Run the application:  
   java -jar target/taskmanager-1.0.0.jar  

## Example session

Enter a command:  
ADD Buy milk  
OK id: 1  

ADD Study sockets  
OK id: 2  

LST  
[ ] id: 1 - Buy milk  
[ ] id: 2 - Study sockets  

DONE 1  
OK  

LST  
[X] id: 1 - Buy milk  
[ ] id: 2 - Study sockets  

DEL 2  
OK  

EXIT  
BYE  

## Technical notes

- Implements the Strategy Pattern using a Map<Command, Function> for command execution.  
- Tasks are persisted automatically to tasks.dat after every change.  
- IDs are managed through id.dat, ensuring uniqueness across sessions.  
- Error handling for invalid commands and missing tasks is included.  

## Requirements

- Java 17+  
- Maven 3.8+  

---

Licensed under the MIT License (see LICENSE file).

