package VOTO;

import CANDIDATO.Candidato;
import prog.utili.Orario;

public abstract class Voto implements Comparable<Voto>{

	public double peso;
	public final int ID;
	private static int contatore = 0;
	Orario ora;
	public String c1, c2;
	
	
	
	public Voto(){
	this.peso = getpeso();
	this.ID = getID();
	this.ora = getora();
	if(Duplice()) {
		this.c1 = getcandidato(1);
		this.c2 = getcandidato(2);
	}
	else {
		this.c1 = getcandidato(1);
	}
	
	}
	
	
	public abstract double getpeso();
	public abstract double getpeso(String candidato) throws Exception;
	
	
	private int getID () {
		
		return contatore++;
	}
	
	abstract Orario getora();
	
	
	public int compareTo(Voto v) {
		return this.ora.compareTo(v.ora);
	}
	
	
	public String toString() {
		
return "Il voto avente ID: " + this.ID + " e peso: " +this.peso;
	}
	
	
	abstract public boolean Duplice();
	
	abstract public String getcandidato(int i);
	
	
	
	
	
	
	
}
