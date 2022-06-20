package controleur;

public class Client {
	
	private int idClient;
	private String nom, prenom, adresse, ville, cp, societe, mail, tel, username, mdp, role;
	
	public Client(int idClient, String nom, String prenom, String adresse, String ville, String cp, String societe, String mail,
			String tel, String username, String mdp, String role) {
		this.idClient = idClient;
		this.nom = nom;
		this.setPrenom(prenom);
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
		this.societe = societe;
		this.mail = mail;
		this.tel = tel;
		this.setUsername(username);
		this.setMdp(mdp);
		this.setRole(role);
	}
	
	public Client(String nom, String prenom, String adresse, String ville, String cp, String societe, String mail,
			String tel, String username, String mdp, String role) {
		this.idClient = 0;
		this.nom = nom;
		this.setPrenom(prenom);
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
		this.societe = societe;
		this.mail = mail;
		this.tel = tel;
		this.setUsername(username);
		this.setMdp(mdp);
		this.setRole(role);
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
