import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallable callable1 = new MyCallable();
        MyCallable callable2 = new MyCallable();
        MyCallable callable3 = new MyCallable();
        MyCallable callable4 = new MyCallable();

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer> task1 = threadPool.submit(callable1);
        Future<Integer> task2 = threadPool.submit(callable2);
        Future<Integer> task3 = threadPool.submit(callable3);
        Future<Integer> task4 = threadPool.submit(callable4);

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3, callable4);
        List<Future<Integer>> futureList = Arrays.asList(task1, task2, task3, task4);
        threadPool.invokeAll(list);

        try {
            for (int i = 0; i < futureList.size(); i++) {
                System.out.println(futureList.get(i).get());
            }
        } catch (InterruptedException | ExecutionException ex) {

        }

        int result = threadPool.invokeAny(list);
        System.out.println(result);
        threadPool.shutdown();
    }
}