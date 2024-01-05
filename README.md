# Dining Philosophers Problem
This Java implementation solves the Dining Philosophers Problem using semaphores to prevent deadlock and limit the number of philosophers sitting at the table to a maximum of four at a time.

## Description of the problem
The Dining Philosophers problem is a classic synchronization problem in computer science. It illustrates a scenario where five philosophers sit around a dining table with a bowl of spaghetti and a single fork placed between each pair of adjacent philosophers. The philosophers spend their time alternating between two activities: thinking and eating.

The challenge arises when each philosopher needs two forks to eat but can only pick up the fork on their left and right. To avoid deadlock and ensure fair sharing of resources, a solution must be devised to prevent situations where all philosophers attempt to pick up their left fork simultaneously, consequently being unable to proceed and causing a deadlock.


## Code description
The Philosopher class represents a philosopher who alternates between thinking and eating. Each philosopher is a thread that attempts to acquire two adjacent forks (represented by semaphores) to start eating. The Semaphore class is used to control access to the table and individual forks.
Main Class (Main.java)
- The Main class initializes semaphores for the table and forks, assigning a maximum of four philosophers allowed at the table simultaneously.
- Each fork is represented by a semaphore, and initially, all forks are available.
- It creates instances of the Philosopher class and starts each philosopher thread.

Philosopher Class (Philosopher.java)

- The Philosopher class extends the Thread class and represents an individual philosopher.
- Each philosopher has a left and right fork (semaphores) and accesses the table semaphore to control the number of philosophers allowed to eat concurrently.
- The eat() method simulates eating by pausing the thread for a random time between 1000ms and 2000ms.
- The think() method simulates thinking by pausing the thread for a random time between 1000ms and 2000ms.
- The run() method defines the behavior of a philosopher:
  - It alternates between thinking and attempting to eat.
  - The philosopher acquires both forks to eat and releases them after finishing.

This setup prevents deadlock by limiting the number of philosophers accessing the table and ensures that each philosopher can eventually acquire both forks needed for eating.

The Semaphore mechanism helps in managing access to shared resources and provides synchronization between the philosophers to avoid conflicts while dining.
