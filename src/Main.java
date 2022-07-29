public class Main {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("myGroup");

        System.out.println("Создаю потоки...");
        Thread thread1 =  new MyThread(threadGroup, "поток 1");
        Thread thread2 =  new MyThread(threadGroup, "поток 2");
        Thread thread3 =  new MyThread(threadGroup, "поток 3");
        Thread thread4 =  new MyThread(threadGroup, "поток 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(15_000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            threadGroup.interrupt();
            System.out.println("Завершаю все потоки.");
        }
    }
}