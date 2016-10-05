package lessonthreads;

/**
 * @author Anton
 */
public class LessonThreads {

    public static void main(String[] args) throws InterruptedException {
        ///Получение главного потока:
        Thread mainThread = Thread.currentThread();
        
        
        
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread();
            myThread.setPriority(Thread.MAX_PRIORITY);
            myThread.start();
            

//            Thread myRunnable = new Thread(new MyRunnable());
//            myRunnable.setPriority(Thread.MIN_PRIORITY);
//            myRunnable.start();
            
            
            

        }

        System.out.println("End!");

    }

}
