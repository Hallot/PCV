package muprodmucons;

public class Main {
	public static void main(String[] args) {
		Tampon<Integer> t = new Tampon<Integer>(5);
		
		Producteur<Integer> p1 = new Producteur<Integer>(t,1,8);
		Producteur<Integer> p2 = new Producteur<Integer>(t,2,4);
		Producteur<Integer> p3 = new Producteur<Integer>(t,3,2);
//		Producteur<Integer> p4 = new Producteur<Integer>(t,4,1);
		
		Consommateur<Integer> c1 = new Consommateur<Integer>(t,1);
		Consommateur<Integer> c2 = new Consommateur<Integer>(t,2);
		Consommateur<Integer> c3 = new Consommateur<Integer>(t,3);
//		Consommateur<Integer> c4 = new Consommateur<Integer>(t,4);

		p1.start();p2.start();p3.start();//p4.start();
		c1.start();c2.start();c3.start();//c4.start();
	}
}
