/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latihanserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level; 
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class LatihanServer {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException { 
// TODO code application logic here 
int portNumber = 4444;
boolean listening = true;
try ( 
        ServerSocket serverSocket = new ServerSocket(portNumber);){
        while(listening){
            Socket clientSocket = serverSocket.accept(); 
            new ServerThread(clientSocket).start();
        }
        
    
} catch (IOException ex) { 
    Logger.getLogger(LatihanServer.class.getName()).log(Level.SEVERE, null, ex); 
    //ex.getMessage();
}
    } 
}



