# 🚗 Parking Lot Management System

A robust, console-based Low-Level Design (LLD) application built in pure Java. This project simulates a fully functional parking lot system that handles vehicle entry, exit, and real-time status queries using an interactive command-line interface.

This project was intentionally engineered to move away from simple procedural scripts to enterprise-grade, object-oriented architecture.

---

## 🧠 Architectural Principles & Rules Applied

### SOLID Principles
* **Single Responsibility Principle (SRP):** * *Where it's used:* Every class has one specific job. The `ParkingLotRepository` solely manages data storage (the `HashMap` of slots). The `Command` classes only handle parsing terminal inputs. The `ParkingService` handles the core business logic.
* **Open/Closed Principle (OCP):** * *Where it's used:* The system is open for extension but closed for modification. We can add a new parking algorithm (like `FarthestSlotStrategy`) by creating a new class that implements `SlotStrategy`, without having to touch or rewrite the `ParkingService` engine.
* **Dependency Inversion Principle (DIP):**
    * *Where it's used:* High-level modules don't depend on low-level modules; both depend on abstractions. `ParkingService` depends on the `SlotStrategy` interface, not a concrete class. Similarly, `Main.java` treats all commands as the `Command` interface.

### General Programming Rules
* **DRY Principle (Don't Repeat Yourself):** * *Where it's used:* Inside `ParkingService.java`. The `getOccupiedSlots()` method was created once and then reused inside `getRegistrationNumbersByColor()`, `getSlotNumbersByColor()`, and `getSlotNumberByRegistrationNumber()` to prevent rewriting the same loop and empty-check logic.
* **Dependency Injection (DI):** * *Where it's used:* Inside `Main.java` and the Command constructors. A single, central instance of `ParkingService` is created in `Main` and injected into the constructor of every single command (`new ParkCommand(parkingService)`). This ensures all commands share the exact same state and memory.

---

## 📐 Design Patterns Implemented

* **Command Pattern 🎮:** * *Where it's used:* The `com.Parkinglot.Commands` package. We decoupled the terminal inputs from the execution logic by encapsulating every user action into discrete classes (`ParkCommand`, `LeaveCommand`, `StatusCommand`, etc.) that all implement a single `Command` interface.
* **Strategy Pattern 🗺️:** * *Where it's used:* The `com.Parkinglot.Strategies` package. The slot allocation logic is abstracted behind the `SlotStrategy` interface. The system uses `NearestSlotStrategy` (powered by a `PriorityQueue` for O(log n) retrieval) but can instantly swap to `RandomSlotStrategy` dynamically.
* **Facade Pattern 🏛️:** * *Where it's used:* `ParkingService.java`. This class acts as a unified front-facing interface. It hides the complex internal interactions between the data storage (`ParkingLotRepository`) and the algorithms (`SlotStrategy`) from the terminal commands.
* **Registry / Dispatcher Pattern 🗂️:**
    * *Where it's used:* `Main.java`. We avoided a massive, ugly `if-else` chain by using a `HashMap<String, Command>` as a registry. The program simply looks up the user's string input (e.g., `"park"`) in the map and triggers the `.execute()` method of the corresponding Command object.

---
## 💻 Commands & Examples

When the application is running, it acts as an interactive terminal. Below is the complete reference for all supported commands:

| Category | Action | Command Syntax | Example Input | Expected Output |
| :--- | :--- | :--- | :--- | :--- |
| **Setup** | Create Lot | `create_parking_lot <capacity>` | `create_parking_lot 6` | `Created a parking lot with 6 slots.` |
| **Core** | Park Vehicle | `park <reg_no> <color>` | `park KA-01-HH-1234 White` | `Allocated slot number: 1` |
| **Core** | Leave Slot | `leave <slot_number>` | `leave 4` | `Slot number 4 is free` |
| **Query** | Lot Status | `status` | `status` | *(Prints a formatted table of all occupied slots)* |
| **Query** | Find Cars by Color | `registration_numbers_for_cars_with_colour <color>` | `registration_numbers_for_cars_with_colour White` | `KA-01-HH-1234, KA-01-HH-9999` |
| **Query** | Find Slots by Color | `slot_numbers_for_cars_with_colour <color>` | `slot_numbers_for_cars_with_colour White` | `1, 2` |
| **Query** | Find Slot by Reg No. | `slot_number_for_registration_number <reg_no>` | `slot_number_for_registration_number MH-04-AY-1111` | `6` (or `Not found`) |
| **System** | Shutdown | `exit` | `exit` | *(Safely terminates the application)* |
---

## 🚀 How to Run

1. Clone this repository to your local machine.
2. Ensure you have Java installed.
3. Compile the source code from the root directory.
4. Run the `Main.java` file to start the interactive command-line interface.
