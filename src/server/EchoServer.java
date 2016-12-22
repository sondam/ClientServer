package server;

import java.io.*;
import java.net.*;

public class EchoServer {
	public void main(String args[]) throws UnknownHostException, IOException{
	   int portnumber= 4444;//Integer.parseInt(args[0]);
	   try{
		   // runs server at port 4444
	       ServerSocket serversocket = new ServerSocket(portnumber);
		   System.out.println("server is listening on port 4444");
		   
		   while(true){
			// server makes connection to communicate with client
			// accept waits and accept every connection from client  
		   Socket clientSocket = serversocket.accept();
		   
		   // buffered reader to read from client input stream
		   BufferedReader in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		   System.out.println("message received from client is "+ in );
		   // read message received from client
		   String s= in.readLine();
		   String returnmessage;
           int numberInIntFormat = Integer.parseInt(s);
           int returnvalue = numberInIntFormat* 2;
           returnmessage = String.valueOf(returnvalue)+ "\n";
           
           BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
           out.write(returnmessage);
           System.out.println("message sent to client is " + returnmessage);
           out.flush();
           serversocket.close();
           }
		  
	   }
	   catch (IOException e) {
		    System.out.println(e.getMessage());
	   }
	}
}
