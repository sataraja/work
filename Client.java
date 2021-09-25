import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import prog.io.ConsoleInputManager;

public class Client {

	Socket mioSocket = null;
	int porta = 6116; // porta server
	
	DataInputStream in;
	DataOutputStream out;

	
	
	
	public void Comunica() {
		try {
			ConsoleInputManager tastiera= new ConsoleInputManager();
			String messaggio = tastiera.readLine("Tu: "); //con metodo readLine legge ciò che digitiamo su tastiera
			out.writeBytes(messaggio+"\n");
			System.out.println("Aspetto messaggio da server...");
		    String ricevuta = in.readLine();
			System.out.println("Server: " + ricevuta);
			ricevuta= null;
		} catch (IOException e) {
		
		}
		
		
	}
	
	
	
	
	
	public Socket connetti() {
		try {
			System.out.println("Provo a connettermi al server...");
			
			 mioSocket = new Socket("185.172.206.4", porta); //connessione al socket --> il socket lo registriamo nella variabile server, necessario per la comunicazione
			System.out.println("Connesso...");

			in = new DataInputStream(mioSocket.getInputStream());
            out= new DataOutputStream(mioSocket.getOutputStream()); 
            
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		System.err.println("Impossibile stabilire connessione");
		}
		
		return mioSocket;
	}
	
	
	
	
	public static void main(String[] args) throws UnknownHostException {
		Client client = new Client();
		client.connetti();
		while(true) {
			
		client.Comunica();
		}
	}
	
	
	
	
}
