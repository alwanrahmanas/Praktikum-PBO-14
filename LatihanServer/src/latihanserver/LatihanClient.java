/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanserver;

/**
 *
 * @author HP
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level; 
import java.util.logging.Logger;


public class LatihanClient {
    
    public static void main(String args[]){ 
        
        String hostName = "localhost"; 
        int portNumber = 4444;
        
        try ( 
                Socket echoSocket = new Socket(hostName, portNumber); 
                //PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),true); 
                BufferedOutputStream bos = new BufferedOutputStream(echoSocket.getOutputStream());
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream())); 
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));){ 
            
            String msg;
            while((msg= stdIn.readLine())!=null){
               oos.writeObject(new pesan("Jokowi", msg));
               oos.flush();
               System.out.println("Client receive: "+ in.readLine());
               if(msg.equalsIgnoreCase("exit"))break;
                
        
            }
            }catch (IOException ex) { 
            Logger.getLogger(LatihanClient.class.getName()).log(Level.SEVERE, null, ex); 
            //ex.getMessage();
        } 
        
    }
    
}
        
    

