package VOTO;

import CANDIDATO.Candidato;
import ELETTORE.Elettore;
import ELETTORE.TipoElettore;
import Main.Gestorevoti;
import prog.utili.Orario;

public class Votoduplice extends Voto{
 
	String candidato1, candidato2;
	Orario ora;
	String comune;
	TipoElettore tipo;
	Gestorevoti gv = new Gestorevoti();
	public Voto v1;
	public Voto v2;
	
	public Votoduplice(Elettore elettore, Candidato c1, Candidato c2, Orario ora) throws Exception {
		super();
		
		this.tipo = elettore.tipo;
		this.candidato1 = c1.nome;
		this.candidato2 = c2.nome;
        this.ora = ora;
		this.comune= elettore.comune;
		
		
		
		if(elettore.tipo.equals(TipoElettore.SEMPLICE)) {
			Votosemplice vs1 = new Votosemplice (elettore, c1);
			Votosemplice vs2 = new Votosemplice (elettore, c2);
			this.v1= vs1;
			this.v2= vs2;
			
		}
		else {
			Votogrande vg1 = new Votogrande(elettore, c1, ora);
			Votogrande vg2 = new Votogrande(elettore, c2, ora);
			this.v1= vg1;
			this.v2= vg2;
		}
		
		
	}
	
	
	public Votoduplice(Elettore elettore, Candidato c1, Candidato c2) throws Exception {
      this( elettore,  c1,  c2, new Orario());
	}
	
	
	
	
	
	public double peso(String cand) throws Exception {
		if(cand.equals(candidato1)) return getpeso()-0.5;
		else if( cand.equals(candidato2)) return getpeso()-1;
		else throw new Exception("candidato non votato!");
	}
	
	
	
	
	
	
	@Override
	public double getpeso() {
		// TODO Auto-generated method stub
		   if(this.tipo.equals(TipoElettore.SEMPLICE)) {
			   return 1+1.5;
		   }
	      
		   else {
			   if(this.tipo.equals(TipoElettore.PRESIDENTE)) return 5+1.5+3;
			   else if(this.tipo.equals(TipoElettore.ASSESSORE)) return 5+1.5+1;
			   else return 5+1.5;
		   }
	
	
	}

	
	@Override
	public boolean Duplice() {
		// TODO Auto-generated method stub
		return true;
	}
	

	@Override
	public String getcandidato(int i) {
		// TODO Auto-generated method stub
		if(i==1) return this.c1;
		else return this.c2;
	}

	@Override
	Orario getora() {
		// TODO Auto-generated method stub
		return this.ora;
	}


	@Override
	public double getpeso(String candidato) throws Exception {
		// TODO Auto-generated method stub
		if(candidato.equals(c1)) return peso(c1);
		else return peso(c2);
	}
	
}
