/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;


public class Server extends javax.swing.JFrame {



   final ArrayList<serverworker1> workerslist=new ArrayList<>();
    private Server server1;
    public Server() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        info = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        info.setEditable(false);
        info.setColumns(20);
        info.setRows(5);
        jScrollPane1.setViewportView(info);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea info;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    ArrayList<serverworker1> getworkerlist() {
        return workerslist;
    }
    public void server()
    {
          try { 
            ServerSocket server =new ServerSocket(1999);
            while(true)
            {   System.out.println("About to accept client connection...\n");
                info.append("About to accept client connection...\n");
                Socket client =server.accept();
                System.out.println("Accepted Connection from"+client+"\n");
                info.append("Accepted Connection from"+client);
                serverworker1 sw=new serverworker1(this,client);
                workerslist.add(sw);
                sw.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
 public static void start1(Server s) {
               SwingWorker<Server,Void> worker=new SwingWorker<Server,Void>(){
                   @Override
                   protected Server doInBackground() throws Exception {
             
            s.setVisible(true);
             s.server(); //To change body of generated methods, choose Tools | Templates.
             return null;
            }
      
      
            
        };
        worker.execute();//To change body of generated methods, choose Tools | Templates.
    }    
}
