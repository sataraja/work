package Main;

import java.util.Comparator;

import VOTO.Voto;

public class ComparatorperPeso implements Comparator<Voto>{

	@Override
	public int compare(Voto o1, Voto o2) {
		// TODO Auto-generated method stub
		if(o1.peso < o2.peso) return -1;
		else if(o1.peso> o2.peso) return 1;
		else return 0;
	}

}
