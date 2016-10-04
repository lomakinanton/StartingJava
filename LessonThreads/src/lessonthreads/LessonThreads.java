package lessonthreads;

/**
 * @author Anton
 */
public class LessonThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread mt = new MyThread();
            mt.start();
            
            Thread run = new Thread(new MyRunnable());
             run.start();
        }
        
        System.out.println("End!");
        
    }
    
}
