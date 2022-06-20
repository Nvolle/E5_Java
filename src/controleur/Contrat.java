package controleur;

public class Contrat {
	
	private int idCo;
	private String datedebut, datefin, etat,idClient;
	
	public Contrat(int idCo, String datedebut, String datefin, String etat , String idClient)  {
		this.idCo = idCo;
		this.idClient = idClient;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.etat = etat;
	}
	
	public Contrat( String datedebut, String datefin, String etat , String idClient) {
		this.idCo = 0;
		this.idClient = idClient;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.etat = etat;
	}

	public int getIdCo() {
		return idCo;
	}

	public void setIdCo(int idCo) {
		this.idCo = idCo;
	}

	public String getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}

	public String getDatefin() {
		return datefin;
	}

	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
}
