package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Contrat;
import controleur.Facture;
import controleur.Location;
import controleur.Materiel;
import controleur.TypeMat;


public class Modele {
	//pour PC
	private static Bdd uneBdd = new Bdd ("172.20.111.146", "roille_sa", "leo","leo"); 
	
	//pour les MAC 
	//private static Bdd uneBdd = new Bdd ("localhost", "air_france_lm22", "root","root");
	
	/************************************* Gestion Client ************************************/
	public static void insertClient (Client unClient)
	{
		String requete ="insert into client values (null, '" + unClient.getNom()
		+ "','" + unClient.getAdresse()+ "','" + unClient.getVille()
		+ "','" + unClient.getCp()+ "','"+ unClient.getSociete()+ "','" 
		+ unClient.getMail()+  "','" + unClient.getTel() +"');";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
	}
	
	public static ArrayList <Client> selectAllClient (String mot)
	{
		ArrayList <Client> lesClients = new ArrayList<Client>(); 
		String requete = " select * from client ; ";
		if (mot.contentEquals("")) {
			requete = "select * from client ;";
		}else {
			requete = "select * from client where idC like '%" + mot + "%' ;"; 
		}
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetchAll () en PHP 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des résultats 
			while(desResultats.next())
			{
				Client unClient = new Client (
						desResultats.getInt("idC"), 
						desResultats.getString("nom"),desResultats.getString("prenom"),
						desResultats.getString("adresse"),
						desResultats.getString("ville"), desResultats.getString("cp"),
						desResultats.getString("societe"), desResultats.getString("mail"),
						desResultats.getString("tel"), desResultats.getString("username"),
						desResultats.getString("mdp"), desResultats.getString("role")
						);
				lesClients.add(unClient);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		return lesClients; 
	}
	public static void deleteClient(int idclient) {
		 
		String requete ="delete from client where idC = " +idclient;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
	}
	
	public static Client selectWhereClientUsername (String username, String mdp)
	{
		Client unClient = null;  
		String requete = " select * from client  where username = '" + username + "' and mdp ='" + mdp + "' ;";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetch  en PHP 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un résultat. 
			if(unResultat.next())
			{
				unClient = new Client (
						unResultat.getInt("idC"), 
						unResultat.getString("nom"), unResultat.getString("prenom"),
						unResultat.getString("adresse"),
						unResultat.getString("ville"), unResultat.getString("cp"),
						unResultat.getString("societe"), unResultat.getString("mail"),
						unResultat.getString("tel"), unResultat.getString("username"),
						unResultat.getString("mdp"), unResultat.getString("role")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
			exp.printStackTrace();
		}
		return unClient; 
	}
	
	public static Client selectWhereClientNom (String nom, String prenom, String societe)
	{
		Client unClient = null;  
		String requete = " select * from client  where nom = '" + nom + "' and prenom ='" + prenom + "' and societe = '" + societe + "' ;";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetch  en PHP 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un résultat. 
			if(unResultat.next())
			{
				unClient = new Client (
						unResultat.getInt("idC"), 
						unResultat.getString("nom"), unResultat.getString("prenom"),
						unResultat.getString("adresse"),
						unResultat.getString("ville"), unResultat.getString("cp"),
						unResultat.getString("societe"), unResultat.getString("mail"),
						unResultat.getString("tel"), unResultat.getString("username"),
						unResultat.getString("mdp"), unResultat.getString("role")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		return unClient; 
	}
	public static void updateClient (Client unClient)
	{
		String requete ="update client set nom = '" + unClient.getNom()+ "', prenom = '" + unClient.getPrenom()
		+ "', adresse = '" + unClient.getAdresse()+ "', ville = '" + unClient.getVille()
		+ "', cp = '" + unClient.getCp()+ "', societe = '"+ unClient.getSociete()
		+ "', mail = '"+ unClient.getMail()+ "', tel = '"+ unClient.getTel() 
		+ "', username = '"+ unClient.getTel() + "', mdp = '"+ unClient.getTel()
		+ "', role = '"+ unClient.getTel()
		+"'   where idC = " + unClient.getIdClient();
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
	}
	
	public static int countClient ()
	{
		int nbclients =0; 
		String requete ="select count(*) as nb from client ;"; 
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete); 
			if (unResultat.next())
			{
				nbclients = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		return nbclients ;
	}
	
	/************************************* Gestion Contrat ************************************/
	
	public static void insertContrat (Contrat unContrat)
	{
		String requete ="insert into contrat values (null, '" + unContrat.getDatedebut()
		+ "','" + unContrat.getDatefin()+ "','" + unContrat.getEtat()
		+ "','" + unContrat.getIdClient()+ "');";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
	}
	
	public static ArrayList <Contrat> selectAllContrat (String mot)
	{
		ArrayList <Contrat> lesContrats = new ArrayList<Contrat>(); 
		String requete = "";
		if (mot.contentEquals("")) {
			requete = "select * from contrat ;";
		}else {
			requete = "select * from contrat where datedebut like '%" + mot + "%' or datedefin like '%" + mot + "%' ;"; 
		}
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetchAll () en PHP 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des résultats 
			while(desResultats.next())
			{
				Contrat unContrat = new Contrat (
						desResultats.getInt("idCo"),
						desResultats.getString("datedebut"), desResultats.getString("datedefin"),
						 desResultats.getString("etat"), desResultats.getString("idC")
						);
				lesContrats.add(unContrat);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		return lesContrats; 
	}
	public static void deleteContrat(int idcontrat) {
		 
		String requete ="delete from contrat where idCo = " +idcontrat;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
	}
	
	public static Contrat selectWhereContrat (int idcontrat)
	{
		Contrat unContrat = null;  
		String requete = " select * from contrat  where idCo = " + idcontrat;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetch  en PHP 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un résultat. 
			if(unResultat.next())
			{
				unContrat = new Contrat (
						unResultat.getInt("idCo"), unResultat.getString("datedebut"),
						unResultat.getString("datedefin"), unResultat.getString("etat"), 
						unResultat.getString("idC")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		return unContrat; 
	}
	
	public static Contrat selectWhereContrat (String DateDebut, String DateFin)
	{
		Contrat unContrat = null;  
		String requete = " select * from contrat  where  datedebut like '%" + DateDebut + "%' or datedefin like '%" + DateFin + "%' ;";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetch  en PHP 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un résultat. 
			if(unResultat.next())
			{
				unContrat = new Contrat (
						unResultat.getInt("idCo"), unResultat.getString("datedebut"),
						unResultat.getString("datedefin"), unResultat.getString("etat"), 
						unResultat.getString("idC")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'ex�cution de la requete : " + requete);
		}
		return unContrat; 
	}
	
	public static void updateContrat (Contrat unContrat)
	{
		String requete ="update contrat set datedebut = '" + unContrat.getDatedebut()+ "', datedefin = '" + unContrat.getDatefin()
		+ "', etat = '" + unContrat.getEtat()+"', idC = " + unContrat.getIdClient() 
		+" where idCo = " + unContrat.getIdCo();
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
	}
	
	public static int countContrat ()
	{
		int nbcontrat =0; 
		String requete ="select count(*) as nb from contrat ;"; 
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete); 
			if (unResultat.next())
			{
				nbcontrat = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		return nbcontrat ;
	}
	
	
	/************************************* Gestion Facture ************************************/
	
	public static void insertFacture (Facture uneFacture)
	{
		String requete ="insert into facture values (null, '" + uneFacture.getMontantHT()
		+ "','" + uneFacture.getMontantTTC()+ "','" + uneFacture.getDateF()
		+ "','" + uneFacture.getIdCo()+ "');";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
	}
	
	public static ArrayList <Facture> selectAllFacture ()
	{
		ArrayList <Facture> lesFactures = new ArrayList<Facture>(); 
		String requete = " select * from facture ; ";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetchAll () en PHP 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des résultats 
			while(desResultats.next())
			{
				Facture uneFacture = new Facture (
						desResultats.getInt("idF"), desResultats.getFloat("montantHT"),
						desResultats.getFloat("TVA"), desResultats.getFloat("montantTTC"),
						 desResultats.getString("dateF"),desResultats.getInt("idCo")
						);
				lesFactures.add(uneFacture);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		return lesFactures; 
	}
	public static void deleteFacture(int idFacture) {
		 
		String requete ="delete from facture where idF = " +idFacture;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
	}
	
	public static Facture selectWhereFacture (int idFacture)
	{
		Facture uneFacture = null;  
		String requete = " select * from facture  where idCo = " + idFacture;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetch  en PHP 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un résultat. 
			if(unResultat.next())
			{
				uneFacture = new Facture (
						unResultat.getInt("idF"), unResultat.getFloat("montantHT"),
						unResultat.getFloat("TVA"), unResultat.getFloat("montantTTC"),
						unResultat.getString("dateF"),unResultat.getInt("idCo")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		return uneFacture; 
	}
	public static void updateFacture (Facture uneFacture)
	{
		String requete ="update facture set idF = '" + uneFacture.getIdF()
		+ "', montantHT = " + uneFacture.getMontantHT()+ ", TVA = "+ uneFacture.getTVA() + ", montantTTC = " + uneFacture.getMontantTTC()
		+ "', dateF = '" + uneFacture.getDateF()+ "', idCo = "+ uneFacture.getIdCo() +"   where idF = " + uneFacture.getIdF();
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
	}
	
	public static int countFacture ()
	{
		int nbcontrat =0; 
		String requete ="select count(*) as nb from facture ;"; 
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete); 
			if (unResultat.next())
			{
				nbcontrat = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		return nbcontrat ;
	}
	
	/************************************* Gestion TypeMat ************************************/

	public static void insertTypeMat (TypeMat unTypeMat)
	{
		String requete ="insert into typeMat values (null, '" + unTypeMat.getDesignation() + "');";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static ArrayList <TypeMat> selectAllTypeMat ()
	{
		ArrayList <TypeMat> lesTypeMat = new ArrayList<TypeMat>(); 
		String requete = " select * from typeMat ; ";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetchAll () en PHP 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des resultats 
			while(desResultats.next())
			{
				TypeMat unTypeMat = new TypeMat (
						desResultats.getInt("idTM"),
						desResultats.getString("designation")
						);
				lesTypeMat.add(unTypeMat);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return lesTypeMat; 
	}
	public static void deleteTypeMat(int idTM) {
		 
		String requete ="delete from typeMat where idF = " +idTM;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static TypeMat selectWhereTypeMat (int idTM)
	{
		TypeMat unTypeMat = null;  
		String requete = " select * from typeMat where idTM = " + idTM;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetch  en PHP 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un resultat. 
			if(unResultat.next())
			{
				unTypeMat = new TypeMat (
						unResultat.getInt("idTM"),
						unResultat.getString("designation")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return unTypeMat; 
	}
	public static void updateTypeMat (TypeMat unTypeMat)
	{
		String requete ="update typeMat set idTM = '" + unTypeMat.getIdTM() + "',designation = '"+ unTypeMat.getDesignation() + "' where idTM = " + unTypeMat.getIdTM();
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static int countTypeMat ()
	{
		int nbTypeMat =0; 
		String requete ="select count(*) as nb from typeMat ;"; 
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete); 
			if (unResultat.next())
			{
				nbTypeMat = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return nbTypeMat ;
	}
	
	/************************************* Gestion Materiel ************************************/

	public static void insertMateriel (Materiel unMateriel)
	{
		String requete ="insert into materiel values (null, '" + unMateriel.getPrixM()+ "','" + 
	unMateriel.getQtM() + "','" + 
	unMateriel.getNom() + "','"+ 
	unMateriel.getIdTM()  + "');";
		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static ArrayList <Materiel> selectAllMateriel ()
	{
		ArrayList <Materiel> lesMateriels = new ArrayList<Materiel>(); 
		String requete = " select * from materiel ; ";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetchAll () en PHP 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des resultats 
			while(desResultats.next())
			{
				Materiel unMateriel = new Materiel (
						desResultats.getInt("idM"),
						desResultats.getInt("qtStockM"),
						desResultats.getInt("idTM"),
						desResultats.getString("nomM"),
						desResultats.getFloat("prixM")
						);
						
				lesMateriels.add(unMateriel);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return lesMateriels; 
	}
	public static void deleteMateriel(int idM) {
		 
		String requete ="delete from materiel where idM = " +idM;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static Materiel selectWhereMateriel (int idM)
	{
		Materiel unMateriel = null;  
		String requete = " select * from materiel where idM = " + idM;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetch  en PHP 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un resultat. 
			if(unResultat.next())
			{
				unMateriel = new Materiel (
						unResultat.getInt("idM"),
						unResultat.getInt("qtStockM"),
						unResultat.getInt("idTM"),
						unResultat.getString("nomM"),
						unResultat.getFloat("prixM")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return unMateriel; 
	}
	public static void updateMateriel (Materiel unMateriel)
	{
		String requete ="update materiel set idM = '" + unMateriel.getIdM() + 
				"',qtStockM = '"+ unMateriel.getQtM() +
				"',idTM  = '" + unMateriel.getIdTM() +
				"',nomM = '" + unMateriel.getNom() +
				"', prixM = '" + unMateriel.getPrixM()
				+"' where idM = " + unMateriel.getIdM();
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static int countMateriel ()
	{
		int nbMateriel =0; 
		String requete ="select count(*) as nb from materiel ;"; 
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete); 
			if (unResultat.next())
			{
				nbMateriel = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return nbMateriel ;
	}
	
	/************************************* Gestion Location ************************************/
	

	public static void insertLocation (Location uneLocation)
	{
		String requete ="insert into location values (null, '" + uneLocation.getIdCo()+ "','" + 
				uneLocation.getIdM() + "','" + 
				uneLocation.getQtM() + "','"+ 
				"');";
		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static ArrayList <Location> selectAllLocation ()
	{
		ArrayList <Location> lesLocations = new ArrayList<Location>(); 
		String requete = " select * from location ; ";
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetchAll () en PHP 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des resultats 
			while(desResultats.next())
			{
				Location uneLocation = new Location (
						desResultats.getInt("idL"),
						desResultats.getInt("idCo"),
						desResultats.getInt("idM"),
						desResultats.getInt("QtM")
						);
						
				lesLocations.add(uneLocation);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return lesLocations; 
	}
	public static void deleteLocation(int idL) {
		 
		String requete ="delete from location where idL = " +idL;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static Location selectWhereLocation (int idL)
	{
		Location uneLocation = null;  
		String requete = " select * from location where idL = " + idL;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			//fetch  en PHP 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un resultat. 
			if(unResultat.next())
			{
				uneLocation = new Location (
						unResultat.getInt("idL"),
						unResultat.getInt("idCo"),
						unResultat.getInt("idM"),
						unResultat.getInt("QtM")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return uneLocation; 
	}
	public static void updateLocation (Location uneLocation)
	{
		String requete ="update location set idL = '" + uneLocation.getIdM() + 
				"',qtStockM = '"+ uneLocation.getIdL() +
				"',idTM  = '" + uneLocation.getIdCo() +
				"',nomM = '" + uneLocation.getIdM() +
				"', prixM = '" + uneLocation.getQtM()
				+"' where idL = " + uneLocation.getIdL();
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static int countLocation ()
	{
		int nbLocation =0; 
		String requete ="select count(*) as nb from location ;"; 
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete); 
			if (unResultat.next())
			{
				nbLocation = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return nbLocation ;
	}
	
}























