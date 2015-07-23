package muprodmucons;

import java.util.ArrayList;

public class Consommateur<E> extends Thread {
	private E id;
	private ArrayList<E> consommations = new ArrayList<E>();
	private Tampon<E> tamp;
	
	public Consommateur(Tampon<E> t, E obj) {
		id = obj;
		tamp = t;
	}
	
	public void run() {
		for (int i = 0; i<=3; i++) {
			E conso = tamp.retrait();
			System.out.println("Consommateur #" + id
						+ " retire : " + conso);
			consommations.add(conso);
		}
		System.out.print("Consommation " + id + " : [");
		for (int j=0; j<consommations.size()-1; j++) {
			System.out.print(consommations.get(j) + ",");
		}
		System.out.println(consommations.get(consommations.size()-1) + "]");
	}
}
