package VOTO;

import CANDIDATO.Candidato;
import ELETTORE.Elettore;
import ELETTORE.TipoElettore;
import prog.utili.Orario;

public class Votogrande extends Voto {

	public TipoElettore tipoele;
	String candidato;
	Orario ora;
	double p=0;
	
	public Votogrande(Elettore elettore, Candidato c, Orario ora) throws Exception{
		
		super();
		System.out.println(elettore.tipo);
		this.tipoele = elettore.tipo;
		this.candidato = c.nome;
		
		if(ora.isMaggiore(new Orario())) throw new Exception("Ora voto non può essere nel futuro");
		else this.ora = ora;
		
	}
	
	
	public Votogrande(Elettore elettore, Candidato c) throws Exception {
		this(elettore, c, new Orario());
	}
	
	
	
	@Override
	public double getpeso() {
		// TODO Auto-generated method stub
	if(this.tipoele.equals(TipoElettore.PRESIDENTE)) return 5 + 3+p;
	else if (this.tipoele.equals(TipoElettore.ASSESSORE)) return 5+1+p;
	else return 5+p;
	}



	@Override
	Orario getora() {
		// TODO Auto-generated method stub
		return this.ora;
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
