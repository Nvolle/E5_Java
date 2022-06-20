package controleur;

public class Materiel {
	private int idM, qtM, idTM;
	private String nom;
	private float prixM;
	
	public Materiel(int idM, int qtM, int idTM, String nom, float prixM) {
		super();
		this.idM = idM;
		this.qtM = qtM;
		this.idTM = idTM;
		this.nom = nom;
		this.prixM = prixM;
	}

	public int getIdM() {
		return idM;
	}

	public void setIdM(int idM) {
		this.idM = idM;
	}

	public int getQtM() {
		return qtM;
	}

	public void setQtM(int qtM) {
		this.qtM = qtM;
	}

	public int getIdTM() {
		return idTM;
	}

	public void setIdTM(int idTM) {
		this.idTM = idTM;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrixM() {
		return prixM;
	}

	public void setPrixM(float prixM) {
		this.prixM = prixM;
	}
	
}
