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
        System.out.println("Hello from runnable");
    }
        
}
