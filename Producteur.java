package muprodmucons;

public class Producteur<E> extends Thread {
	private int id;
	private E produit;
	private Tampon<E> tamp;
	
	public Producteur(Tampon<E> t, int identite, E p) {
		id = identite;
		produit = p;
		tamp = t;
	}
	
	public void run() {
		for (int i = 0; i<=3; i++) {
			if (tamp.depot(produit) == 0) {
				System.out.println("Producteur #" + id 
		                        + " met : " + produit);
			}
			else {
				System.out.println("Producteur #" + id 
								+ " n'a pas pu mettre : " + produit);
			}
		}
	}
}
