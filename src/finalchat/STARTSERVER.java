/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalchat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.*;


public class STARTSERVER {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
         int i;
         splash11 s=new splash11();
         ServerMain s1=new ServerMain();
         s.setVisible(true);
         try{
        for(i=0;i<=100;i++)
        {    Thread.sleep(40);
            splash11.LOADING.setText(Integer.toString(i)+"%");
            splash11.LOADER.setValue(i);
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
