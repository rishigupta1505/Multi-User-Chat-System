/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalchat;


import java.io.FileNotFoundException;
import java.io.IOException;



public class STARTLOGIN {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
         int i;
         splash1 s=new splash1();
         login s1=new login();
         s.setVisible(true);
         try{
        for(i=0;i<=100;i++)
        {    Thread.sleep(40);
            splash1.LOADING.setText(Integer.toString(i)+"%");
            splash1.LOADER.setValue(i);
               if(i==100)
        {
            s.setVisible(false);
            s1.setVisible(true);
        }
        }
   
    }catch(InterruptedException e)
    {
        
    }
       
    }
    
}
