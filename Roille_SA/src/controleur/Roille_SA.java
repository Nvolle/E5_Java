package controleur;

import vue.VueConnexion;
import vue.VueGenerale;

public class Roille_SA {
	private static VueConnexion uneVueConnexion;
	private static VueGenerale uneVueGenerale;
	
	public static void instancierVueGenerale(Client unClient) {
		uneVueGenerale = new VueGenerale(unClient);
	}
	
	public static void detruireVueGenerale() {
		uneVueGenerale.dispose();
	}
	
	public static void rendreVisibleVueConnexion(boolean action) {
		uneVueConnexion.setVisible(action);
	}
	public static void main (String args[])
	{
		uneVueConnexion = new VueConnexion();
	}

}