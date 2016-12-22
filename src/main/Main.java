package main;

import client.EchoClient;


public class Main {
	public static void main(String args[]){
		EchoClient client1 = new EchoClient();
		client1.runclient("2");
		EchoClient client2 = new EchoClient();
		client2.runclient("3");
	}
	
}
