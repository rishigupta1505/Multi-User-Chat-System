/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalchat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingWorker;

/**
 *
 * @author hp
 */
public class serverworker1 extends Thread {
    ArrayList<String> list=new ArrayList<>();
    String str;
    Socket client=null;
    private final Server server1;
    private DataOutputStream outputstream;
    private String login;
    private DataInputStream inputstream;
    private String cmd;
    private String[] tokens;
    public serverworker1(Server server,Socket client)
    {   this.server1=server;
        this.client=client;
    }

    /**
     *
     */
    @Override
    public void run()
                   {

        try {
            handleclient(client);
        } catch (IOException ex) {
            Logger.getLogger(serverworker1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(serverworker1.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
                    }
                    
                    
     private void handleclient(Socket client) throws IOException, SQLException {        
        this.inputstream=new DataInputStream(client.getInputStream());
        this.outputstream= new DataOutputStream(client.getOutputStream());
        BufferedReader reader=new BufferedReader(new InputStreamReader(this.inputstream));
     
       
       String line;
         System.out.println("hello");
        while((line=reader.readLine())!=null)
        {   tokens=line.split(" ",2);
            cmd=tokens[0];
            System.out.println(cmd);
            if("quit".equalsIgnoreCase(cmd))
        {  System.out.println("quit");
            handlelogout();
            System.out.println("break");
            break;
        }
        else if("login".equalsIgnoreCase(cmd))
        {   System.out.println("hii");
            login=tokens[1]; 
            handlelogin(outputstream,login);
        }
        else if("msg".equalsIgnoreCase(cmd)){
            String[] tokens1=line.split(" ",3);
            handleMessage(tokens1);
        }    
 
            }
        
        client.close();
        }
     
     
    private void handlelogin(OutputStream outputstream, String login1) throws IOException {       
                          if(login!=null)
                          {
                                    server1.info.append("user logged in successfully: "+login1+"\n");
     
                             ArrayList<serverworker1> workerslist;
                             workerslist = server1.getworkerlist();
                             String msg2="online "+login+"\n";
                             for(serverworker1 worker:workerslist)
                             {   
                                 if(!login.equals(worker.getlogin())){
                                 
                                 if(worker.getlogin()!=null){
                                     String msg1="online "+worker.getlogin()+"\n";
                                      send(msg1);  
                                 }
                                
                             }
                             }
                             for(serverworker1 worker:workerslist)
                             {  if(!login.equals(worker.getlogin()))
                             {
                                 worker.send(msg2);
                             }
                             }
                                 
                                }
                                else{
                                   server1.info.append("Either error or logged out");
                                }
                             
                              
                         
                      
                      }
                  
                            
public String getlogin()
{
    return login;
}
    private void send(String msg) throws IOException {
        if(login!=null){
            System.out.println(msg);
        outputstream.flush();
        outputstream.flush();
        outputstream.write(msg.getBytes());
        outputstream.flush();
        outputstream.flush();
    }
    }
    private void handlelogout() throws IOException {
     
         ArrayList<serverworker1> workerslist=server1.getworkerlist();
         server1.workerslist.remove(this);
        String msg2="offline"+" "+login+"\n";
        System.out.println(msg2);
        server1.info.append("user logged out successfully\n");
                         client.close();
            for(serverworker1 worker1:workerslist)
                             {  System.out.println("insidefor");
                                 if(!login.equals(worker1.getlogin()))
                             {
                                 worker1.send(msg2);
                             }
                             }

             
    }
    private void handleMessage(String[] tokens) throws IOException {
       String sendTo=tokens[1];
       String body=tokens[2];
        System.out.println("inside handlemessageserver");
       ArrayList<serverworker1> workerslist=server1.getworkerlist();
               for(serverworker1 worker:workerslist){
               String outmsg="msg "+login+":: "+body+"\n";
               worker.send(outmsg);
               }
    }
 

                           
}   
