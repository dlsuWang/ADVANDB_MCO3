package network;

import java.io.*;
import java.net.*;
import java.util.*;

class client{
    
    public static void main(String argv[]) throws Exception
    {
        String sentence = " ";
        String modifiedSentence;
        Scanner sc = new Scanner(System.in);
        System.out.println("CLIENT");
        
        /*This class implements client sockets (also called just "sockets"). 
        A socket is an endpoint for communication between two machines.*/
        Socket clientSocket = new Socket("127.0.0.1", 1997);
        System.out.println("Socket initialized.");
        System.out.println("" + clientSocket.toString());
        //System.out.println("IP address "  + clientSocket.getInetAddress());
        
        
        /*A data output stream lets an application write primitive Java data types to an 
        output stream in a portable way. An application can then use a data input stream 
        to read the data back in.*/
        /*clientSocket.getOutputStream() - Returns an output stream for this socket.*/
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        System.out.println("DataOutputStream initialized.");
        
        
        /*A buffered reader Reads text from a character-input stream, buffering characters 
        so as to provide for the efficient reading of characters, arrays, and lines.*/
        /*clientSocket.getInputStream() - Returns an input stream for this socket.*/
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	System.out.println("BufferedReader initialized.");		
			
	while(true)
        {
            System.out.print("Input: ");
            sentence = sc.nextLine();
            
            
            if(sentence.equals("END"))
                break;
            
            
            System.out.println("CLIENT - " + sentence);
                
            /*writeBytes - Writes a string to the output stream. For every character 
            in the string s, taken in order, one byte is written to the output stream. 
            If s is null, a NullPointerException is thrown.*/
            outToServer.writeBytes(sentence + '\n');
		
            modifiedSentence = inFromServer.readLine();
            System.out.println("SERVER - " + modifiedSentence);
            
        }
            
	clientSocket.close();
        
        System.out.println("Sockets closed.\nBufferedReader closed.\n");
	}
			
        
    }


