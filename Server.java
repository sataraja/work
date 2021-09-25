
import java.io.*;
import java.net.*;

import prog.io.ConsoleInputManager;

public class Server {

	ServerSocket server=null;
	Socket socketClient = null;
	
	DataOutputStream out;
	DataInputStream in;
	ConsoleInputManager tastiera= new ConsoleInputManager();

	
	int porta = 6116; //porta server
	
	
	
	public void Comunica() {
		try {
			System.out.println("Aspetto un messaggio dal client");
			String letto = in.readLine();
			System.out.println("Client: "+letto);
			letto=null;
			String risposta = tastiera.readLine("Tu: ");
			out.writeBytes(risposta+"\n");

		} catch (IOException e) {
			
			
		}
		
		
	}
	
	
	
	
	
	public Socket attendi() {
		try {
		System.out.println("Inizializzo il server...");
		server= new ServerSocket(porta);  //inizializziamo il servizio
		
		System.out.println("Server pronto, in ascolto sulla porta: " + porta);
		//mi metto in ascolto sulla porta che ho aperto
		socketClient = server.accept(); //accettiamo connessione con client (quando avviene)
		System.out.println("Connessione stabilita!");
		server.close(); //(connessione punto-a-punto) una volta accettata connessione con un client, con questo metodo evitiamo connessioni multiple(che altri client possano connettersi anche)
		
		in= new DataInputStream(socketClient.getInputStream()); //per farci dire dov'è che il client scrive.
		out= new DataOutputStream(socketClient.getOutputStream()); //dove diremo le cose al client
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return socketClient;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Server s= new Server();
s.attendi();

while(true) {
s.Comunica();
}
	}

}