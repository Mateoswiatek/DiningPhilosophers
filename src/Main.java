import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore tableSemaphore = new Semaphore(4); // max 4 Philosophers
        Semaphore[] forks = new Semaphore[5]; // semaphores representing forks

        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1); // all forks are available
        }

        Philosopher[] philosophers = new Philosopher[5];

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % 5], tableSemaphore);
            philosophers[i].start();
        }
    }
}
// left and right forks, the right of the first is the left of the last
/*
i (i+1)%5
0 1
1 2
2 3
3 4
4 0 (5)
 */
