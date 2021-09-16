package Main;

import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

import CANDIDATO.Candidato;
import CANDIDATO.CandidatoException;
import ELETTORE.Elettore;
import ELETTORE.TipoElettore;
import VOTO.Voto;
import VOTO.VotoException;
import VOTO.Votoduplice;
import VOTO.Votogrande;
import VOTO.Votosemplice;
import prog.io.ConsoleOutputManager;
import prog.io.FileInputManager;
import prog.utili.Orario;
import prog.utili.SequenzaOrdinata;

public class Gestorevoti {
    ConsoleOutputManager out = new ConsoleOutputManager();
	SequenzaOrdinata<Voto> voti = new SequenzaOrdinata<Voto>();
	Vector<Candidato> candidati = new Vector<Candidato>();
	
	
	
	
	
	
	public void insertVoto(Voto v) throws VotoException{
		if(v!= null) {
			if(v.Duplice()) {
				
				for(Candidato c: candidati) {
					if(c.nome.equals(v.c1)) c.inserisci(v);
					else if(c.nome.equals(v.c2))  c.inserisci(v);
				}
			}
			
			else {
				for(Candidato c: candidati) if(c.nome.equals(v.c1)) c.inserisci(v);
			}
			
			voti.add(v);
			
		}
		else throw new VotoException("Voto non valido!");
	}
	
	
	
	public void stampaVoti(){
		//stampa in ordine di ora
		out.println("\n");
		for(Voto t: voti) out.println(t);
	}
	
	
	
	public void stampaperpeso() {
		Vector<Voto> votiperpeso = new Vector<Voto>();
		for(Voto v: voti) votiperpeso.add(v);
		
		Collections.sort(votiperpeso, new ComparatorperPeso());
		
		out.println("\n");
		for(Voto vtemp : votiperpeso) out.println(vtemp);
	}
	
	
	
	
	public void calcolaVincitore() throws Exception {
		double peso=0;
		String candidato = null;
		for(Candidato c : candidati) {
			out.println("\n");
			out.print(c);
			out.println(c.getpesoComplessivo());
			
			if(peso< c.getpesoComplessivo()) {
				candidato= c.nome;
				peso=c.getpesoComplessivo();
			}
			
		}
		
		out.println("\n\n\n");
		out.println("Il vincitore delle elezioni è: " + candidato+ " con " + peso+ " punti!");
		
	}
	
	
	public void insertCandidato(Candidato c) throws CandidatoException{
		if(c!= null)
		candidati.add(c);
		else throw new CandidatoException("Candidato non inserito!");
	}
	
	
	
	
	
	//
	public void import_da_file(String file) throws Exception {
		
		FileInputManager infile;
		Vector<String> dati= new Vector<String>();
		if(FileInputManager.exists(file)) {
			infile=new FileInputManager(file);
			String riga;
			while(( riga=infile.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(riga, "-"); 
				while(st.hasMoreTokens()) {
					dati.add(st.nextToken());
				}    //tutto uguale
				
			String comune, nome1, nome2; 
			TipoElettore tipo;
			Orario ora;
	  if(dati.get(0).equals("vs")) {
		  comune= dati.get(1);
		  tipo = TipoElettore.valueOf(dati.get(2));
		  nome1= dati.get(3);
		  Elettore e = new Elettore(comune, tipo);
		  Candidato c= new Candidato(nome1);
		  Votosemplice v = new Votosemplice(e, c);
		  insertVoto(v);
	  }
	  
	  
	  else if(dati.get(0).equals("vg")) {
		  if(dati.size()==4) {
			  comune= dati.get(1);
			  tipo = TipoElettore.valueOf(dati.get(2));
			  nome1= dati.get(3);
			  Elettore e = new Elettore(comune, tipo);
			  Candidato c= new Candidato(nome1);
			  Votogrande v = new Votogrande(e, c);
			  insertVoto(v);
		  }
		  else if(dati.size()==5) {
			  
			  comune= dati.get(1);
			  ora= Orario.parseOrario(dati.get(4));
			  tipo = TipoElettore.valueOf(dati.get(2));
			  nome1= dati.get(3);
			  Elettore e = new Elettore(comune, tipo);
			  Candidato c= new Candidato(nome1);
			  Votogrande v = new Votogrande(e, c, ora);
			  insertVoto(v);
 	  
		  }
  
	  }
	  
	  
	  
	  else if(dati.get(0).equals("vd")) {
		  
		  
		  comune= dati.get(1);
		  ora= Orario.parseOrario(dati.get(5));
		  tipo = TipoElettore.valueOf(dati.get(2));
		  nome1= dati.get(3);
		  nome2= dati.get(4);
		  Elettore e = new Elettore(comune, tipo);
		  Candidato c= new Candidato(nome1);
		  Candidato c2 = new Candidato(nome2);
		  Votoduplice v = new Votoduplice(e, c, c2, ora);
		  insertVoto(v);
		  
		  
		  
	  }
			
				
				
				
			}
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
