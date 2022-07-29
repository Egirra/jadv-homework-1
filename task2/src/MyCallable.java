import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private final int THREADS = 4;

    @Override
    public Integer call() throws Exception {
        int count = 0;
        while (count < THREADS) {
            Thread.sleep(2500);
            count++;
            System.out.println("Я " + Thread.currentThread().getName() + ", всем привет!");
        }
        return count;
    }
}