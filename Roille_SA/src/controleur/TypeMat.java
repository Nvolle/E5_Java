package controleur;

public class TypeMat {
	
	private int idTM;
	private String designation;
	
	public TypeMat(int idTM, String designation) {
		this.idTM = idTM;
		this.designation = designation;
	}
	
	public TypeMat( String designation) {
		this.idTM = 0;
		this.designation = designation;
	}

	public int getIdTM() {
		return idTM;
	}

	public void setIdTM(int idTM) {
		this.idTM = idTM;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
