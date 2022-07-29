class MyThread extends Thread {

    public MyThread(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("Я " + Thread.currentThread().getName() + ", всем привет!");
            }
        } catch (InterruptedException err) {

        } finally{
            System.out.printf("%s завершен\n", getName());
        }
    }
}