package network;

import java.io.*;
import java.net.*;
class server {
    
    private String clientSentence = " ";
    private String capitalizedSentence = "";
    private ServerSocket welcomeSocket;
    private Socket connectionSocket;
    private DataOutputStream outToClient; 
    private BufferedReader inFromClient;
    
    public static void main(String args[]){
        try{
            new server();
        }catch(Exception e){
            e.printStackTrace();
            System.out.print(e.toString());
        }
    }
    
    public server() throws Exception{
        
        System.out.println("SERVER");
        welcomeSocket = new ServerSocket(1997);
        
        while(true){
            try{
                start();
                chatting();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.toString());
            }
        }
	
    }
    
    private void start() throws Exception{
            
	connectionSocket = welcomeSocket.accept();
        
	outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		
        inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
    }
    
    private void chatting() throws Exception{
        
        while(true)
        {
               
		clientSentence = inFromClient.readLine();
                
		
                if(clientSentence != null && clientSentence.equals("END"))
                {
                    System.out.println("Connection closed");
                    
                    //welcomeSocket.close();
                    connectionSocket.close();
                    outToClient.close();
                    inFromClient.close();
                    
                    break;
                }
                
                if(clientSentence != null)
                {
                System.out.println(clientSentence);
                capitalizedSentence = clientSentence.toUpperCase() + '\n';
                    
                /*writeBytes - Writes a string to the output stream. For every character 
                in the string s, taken in order, one byte is written to the output stream. 
                If s is null, a NullPointerException is thrown.*/
                outToClient.writeBytes(capitalizedSentence);
		    
                }
                
                
	}
        
    }
 }

