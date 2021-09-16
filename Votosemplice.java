package VOTO;

import CANDIDATO.Candidato;
import ELETTORE.Elettore;
import prog.utili.Orario;

public class Votosemplice extends Voto{

	public String comune;
	String candidato;
	double p=0;
	public Votosemplice(Elettore elettore, Candidato c ) {
		super();
		this.comune= elettore.comune;	
		this.candidato=c.nome;
	}
	
	
	public Votosemplice(Elettore elettore, Candidato c, double p ) {
		
		this(elettore, c);
		this.p = p;
	}
	
	
	

	@Override
	public double getpeso() {
		// TODO Auto-generated method stub
		return 1+p;
	}


	@Override
	Orario getora() {
		// TODO Auto-generated method stub
		return new Orario();
	}


	@Override
	public boolean Duplice() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String getcandidato(int i) {
		// TODO Auto-generated method stub
		return this.candidato;
	}


	@Override
	public double getpeso(String candidato) {
		// TODO Auto-generated method stub
		return getpeso();
	}
	
	

	
	
	
	
	
	
	
	
}
