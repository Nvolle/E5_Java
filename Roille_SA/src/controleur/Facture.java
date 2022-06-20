package controleur;

public class Facture {
	
	private int idF, idCo;
	private float montantHT, montantTTC, TVA;
	private String dateF;
	
	public Facture(int idF, float montantHT,float TVA, float montantTTC, String dateF, int idCo) {
		this.idF = idF;
		this.idCo = idCo;
		this.setTVA(TVA);
		this.montantHT = montantHT;
		this.montantTTC = montantTTC;
		this.dateF = dateF;
	}
	
	public Facture(  float montantHT, float TVA, float montantTTC, String dateF, int idCo) {
		this.idF = 0;
		this.idCo = idCo;
		this.setTVA(TVA);
		this.montantHT = montantHT;
		this.montantTTC = montantTTC;
		this.dateF = dateF;
	}

	public int getIdF() {
		return idF;
	}

	public void setIdF(int idF) {
		this.idF = idF;
	}

	public int getIdCo() {
		return idCo;
	}

	public void setIdCo(int idCo) {
		this.idCo = idCo;
	}


	public float getMontantHT() {
		return montantHT;
	}

	public void setMontantHT(float montantHT) {
		this.montantHT = montantHT;
	}

	public float getMontantTTC() {
		return montantTTC;
	}

	public void setMontantTTC(float montantTTC) {
		this.montantTTC = montantTTC;
	}

	public String getDateF() {
		return dateF;
	}

	public void setDateF(String dateF) {
		this.dateF = dateF;
	}

	public float getTVA() {
		return TVA;
	}

	public void setTVA(float tVA) {
		TVA = tVA;
	}
}
