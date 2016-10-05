/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lessonthreads;

/**
 *
 * @author Anton
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
      System.err.println("Begin  MyRunnable!");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(200);

            }
            System.err.println("End  myThread!");
        } catch (Exception e) {
            System.err.println("Error in MyRunnable!");
        }
    }
        
}
