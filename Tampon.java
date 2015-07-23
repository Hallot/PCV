package muprodmucons;

import java.util.ArrayList;

public class Tampon<E> {
	public ArrayList<E> objets = new ArrayList<E>();
	public int max;

	public Tampon (int maximum) {
		max = maximum;
	}
	
	public synchronized E retrait() {
		while (objets.isEmpty()) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("Tampon : [");
		for (int k=0; k<objets.size()-1; k++) {
			 System.out.print(objets.get(k) + ",");
		}
		System.out.println(objets.get(objets.size()-1) + "]");
		E temp = objets.get(0);
		objets.remove(0);
		return temp;
	}
	
	public synchronized int depot(E obj) {
		if (objets.size() < max) {
			objets.add(obj);
			notifyAll();
			return 0;
		}
		else {
			System.out.println("Le tampon est plein.");
			return 1;
		}
		
	}
}
