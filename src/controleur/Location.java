package controleur;

public class Location {
	private int idL, idCo, IdM, QtM;

	public Location(int idL, int idCo, int idM, int QtM) {
		super();
		this.idL = idL;
		this.idCo = idCo;
		IdM = idM;
		this.setQtM(QtM);
	}

	public int getIdL() {
		return idL;
	}

	public void setIdL(int idL) {
		this.idL = idL;
	}

	public int getIdCo() {
		return idCo;
	}

	public void setIdCo(int idCo) {
		this.idCo = idCo;
	}

	public int getIdM() {
		return IdM;
	}

	public void setIdM(int idM) {
		IdM = idM;
	}

	public int getQtM() {
		return QtM;
	}

	public void setQtM(int qtM) {
		QtM = qtM;
	}
	
	
}
