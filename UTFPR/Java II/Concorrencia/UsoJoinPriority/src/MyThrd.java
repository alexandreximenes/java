public class MyThrd extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            System.out.println("Executando "+ Thread.currentThread().getName() + " prioridade "+ Thread.currentThread().getPriority());
        }
    }
}

class Main{
    public static void main(String[] args) {
        MyThrd m1 = new MyThrd();
        MyThrd m2 = new MyThrd();
        try {
            m1.start();
            m1.setPriority(Thread.MIN_PRIORITY);
            m2.start();
            m2.setPriority(Thread.NORM_PRIORITY+3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
