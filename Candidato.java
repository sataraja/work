package CANDIDATO;

import java.util.Vector;

import VOTO.Voto;

public class Candidato {

	public String nome;
	Vector<Voto> voti = new Vector<Voto>();
	
	
	public Candidato(String nome) {
		this.nome=nome;
	}
	
	
	
	
	
	public double getpesoComplessivo() throws Exception{
		double pesocomplessivo=0;
		for(Voto v: voti) {
			if(v.Duplice()) {
				if(v.c1.equals(nome)) pesocomplessivo+= v.getpeso(v.c1);
				else pesocomplessivo+= v.getpeso(v.c2);
			}
			else {
				pesocomplessivo+= v.getpeso();
			}
		}
		
		return pesocomplessivo;
	}
	
	
	
	
	public void inserisci(Voto v){
		voti.add(v);
	}
	
	
	
	
	
	
	
}
