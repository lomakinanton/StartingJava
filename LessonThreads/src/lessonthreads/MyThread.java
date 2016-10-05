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
public class MyThread extends Thread {

    @Override
    public void run() {
        System.err.println("Begin  myThread!");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);

            }
        } catch (Exception e) {
            System.err.println("Error in myThread!");
        }
        System.err.println("End  myThread!");

    }

}
