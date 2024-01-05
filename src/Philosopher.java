import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    int id;
    Semaphore leftFork;
    Semaphore rightFork;
    Semaphore tableSemaphore;
    Random random = new Random();

    public Philosopher(int id, Semaphore leftFork, Semaphore rightFork, Semaphore tableSemaphore) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.tableSemaphore = tableSemaphore;
    }

    public void eat(){
        System.out.println("Filozof " + id + " je");
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void think(){
        System.out.println("Filozof " + id + " mysli");
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (;;) {
            think();
            try {
                tableSemaphore.acquire(); // trying to access the table (max 4 Philosophers)
                leftFork.acquire(); // try to take the left fork
                rightFork.acquire(); // try to take the right fork

                System.out.println("Filozow " + id + " dostal widelce i je");
                eat();
                System.out.println("Filozow " + id + " skonczyl, odklada widelce i wychodzi");

                rightFork.release(); // put down the right fork
                leftFork.release(); // put down the left fork
                tableSemaphore.release(); // release access to the table
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
