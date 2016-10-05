/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lessonthreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anton
 */
public class Atm implements Runnable {

    private static int MONEY = 100; //вся сумма в банкомате

    //получение денег из автомата
    public static int getMONEY(int needed) throws InterruptedException {
        
            if (MONEY >= needed) {

                Thread.sleep(50);
                MONEY -= needed;
                return needed;  

            }
        
        return 0;
    }

    @Override
    public void run() {

        try {
            System.err.println(String.format(
                    "Thread=[%s] getMoney(10)=[%s] money=[%s]",
                    Thread.currentThread().getName(), getMONEY(10), MONEY));
        } catch (InterruptedException ex) {
            Logger.getLogger(Atm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new Atm());
            thread.start();
            thread.join();
            //Thread.sleep(1000);
        }
        System.err.println(String.format("Total=[%s]", MONEY));
    }
}
