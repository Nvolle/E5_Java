package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {
	private String serveur, bdd, user, mdp; 
	
	private Connection maConnexion ; 
	
	public Bdd (String serveur, String bdd, String user, String mdp) {
		this.serveur = serveur; 
		this.bdd = bdd; 
		this.user = user; 
		this.mdp = mdp; 
		this.maConnexion = null; 
	}
	public void seConnecter ()
	{
		try {
			//vérifier la présence du pilote JDBC : Java Database Connector 
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException exp) {
			System.out.println("Absence du pilote JDBC !");
		}
		String url = "jdbc:mysql://"+this.serveur+"/"+this.bdd;
		url += "?verifyServerCertificate=false&useSSL=false";
		try {
			this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur de connexion a : "+ url);
		}
	}
	public void seDeConnecter () {
		try {
			if(this.maConnexion !=null) {
				this.maConnexion.close();
			}
		}
		catch (SQLException exp) {
			System.out.println("Erreur de fermeture de la connexion !");
		}
	}
	
	public Connection getMaConnexion() {
		return maConnexion;
	}
	public void setMaConnexion(Connection maConnexion) {
		this.maConnexion = maConnexion;
	}
}

