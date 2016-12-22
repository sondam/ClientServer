package client;
import java.io.*;
import java.net.*;

public class EchoClient {
	
   public void runclient(String number){
	   String hostname = "localhost"; //args[0];
	   int portnumber =  4444;//Integer.parseInt(args[1]);
	   
	   try{
		    //making socket connection to server
			Socket clientSocket = new Socket(hostname, portnumber) ;
			
            //String number = "5";
            String sendmessage = number + "\n";
            //connect BufferedWriter to client socket
			BufferedWriter out = new   BufferedWriter(new OutputStreamWriter (clientSocket.getOutputStream()));
			//send sendmessage to buffered writer object
			out.write(sendmessage);
			out.flush();
			//connect BufferedReader to client socket 
		    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// check if input received at client socket
	        String message = in.readLine();
	        System.out.println("message received from server"+ message);
	        clientSocket.close();
	   }catch(UnknownHostException e){
		   System.err.println("Dont know about host" + hostname );
		   System.exit(1);
		   
	   } catch (IOException e) {
		
		e.printStackTrace();
	}
	   
   }
}
