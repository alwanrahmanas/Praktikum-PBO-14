/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanserver;

import java.io.BufferedInputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.PrintWriter; 
import java.net.Socket;
import java.util.logging.Level; 
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class ServerThread extends Thread{
    private Socket clientSocket = null;
    
    public ServerThread(Socket clientSocket) { 
        super(); 
        this.clientSocket = clientSocket; 
    }
    
    @Override public void run(){ 
        try ( 
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); 
                BufferedInputStream bis = new BufferedInputStream(clientSocket.getInputStream()); 
                ObjectInputStream ois = new ObjectInputStream(bis);
                
        )
            { 
                pesan pesan; 
                while((pesan = (pesan) ois.readObject())!=null){ 
                    System.out.println("Server Receive: " + pesan.toString()); 
                    out.println("Pesan Diterima"); 
                    if(pesan.getPesan().equalsIgnoreCase("exit")) break; 
                } 
            } catch (IOException | ClassNotFoundException ex) { 
                    Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex); 
                    }
            
            finally { 
                if(clientSocket!=null
                        )
                {
                    try { 
                    clientSocket.close(); 
                    } catch (IOException ex) { 
                    Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex); 
                    } 
                    } 
                    } 
    }
                    
}
    

