# Task Manager (Console Application)

![Task Manager running](images/task_manager_running.png)

A simple **console-based Task Manager** built in Java.  
It allows adding, listing, completing, and deleting tasks, with automatic file-based persistence.

---

## Features

- **ADD** – Add a new task (incomplete by default)
- **LST** – List all tasks
- **DONE** – Mark a task as completed
- **DEL** – Delete a task by ID
- **HELP** – Show all available commands
- **SAVE** – Manually save tasks to file (optional)
- **EXIT** – Save and exit the application

---

## Storage Format

Tasks are stored in the file **`tasks.dat`** in a simple text-based format:

```
[ ] id: 1 - Buy milk  
[x] id: 2 - Study sockets  
```

- `[ ]` → incomplete
- `[x]` → completed

Each task has a **unique ID**, automatically generated and managed in memory by the repository.  
The file is recreated on each save to ensure consistency between runs.

---

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Kvilarinho/taskmanager.git
   cd taskmanager
   ```

2. **Build with Maven:**
   ```bash
   mvn clean package
   ```

3. **Run the application:**
   ```bash
   java -jar target/taskmanager-1.1-jar-with-dependencies.jar  
   ```

---

## Example Session

```
Enter a command:
ADD Buy milk
Task added successfully with ID: 1

ADD Study sockets
Task added successfully with ID: 2

LST
[ ] id: 1 - Buy milk
[ ] id: 2 - Study sockets

DONE 1
Task 1 marked as done 

LST
[x] id: 1 - Buy milk
[ ] id: 2 - Study sockets

DEL 2
Task 2 removed successfully

EXIT
Bye!
```

---

## Technical Notes

- Implements the **Strategy Pattern** via a `Map<Command, Function>` for dynamic command execution.
- Tasks are persisted automatically to `tasks.dat` after every change.
- Unique IDs are managed in memory through `TaskRepository#getNextId()`.
- Error handling covers invalid commands, incorrect input, and I/O exceptions.
- Modular architecture with clear separation between:
    - **Commands layer** (`functionalities`)
    - **Persistence layer** (`TaskRepository`)
    - **Controller layer** (`TaskManager`)
    - **Model layer** (`Task`)

---

## Future Improvements (v2)

- Introduce **unit tests** 
- Introduce new commands
- Add filters for completed/uncompleted tasks
- Add timestamps for task creation/completion
- Support editing existing task descriptions
- Transition to a **Java MVC Web version** (Spring Boot + Thymeleaf)

---

## Requirements

- **Java 17+**
- **Maven 3.8+**

---

Author: Katia Vilarinho               
LinkedIn: https://www.linkedin.com/in/kátia-vilarinho                
Portfolio: https://katiavilarinho.dev

**© 2025 – Kátia Vilarinho**  
*Version 1.1 – CLI Edition (OOP + File Persistence)*
