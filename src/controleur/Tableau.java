package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel {
	
	private String entetes [];
	private Object donnees [][];
	
	public Tableau(Object donnees [][], String entetes []) {
		this.donnees = donnees;
		this.entetes = entetes;
	}
	
	@Override
	public int getRowCount() {
		return this.donnees.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.entetes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return this.donnees[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return this.entetes[column];
	}
	public void ajouterLigne (Object ligne[]) {
		Object matrice [][] = new Object[this.getRowCount()+1][this.getColumnCount()];
		for (int i =0; i<this.getRowCount(); i++) {
			matrice[i] = this.donnees[i];
		}
		matrice[this.getRowCount()] = ligne;
		//on ecrase la donnee par la nouvelle matrice
		this.donnees = matrice;
		//on actualise l'affichange des donnees
		this.fireTableDataChanged();
	}
	public void supprimerLigne(int numLigne) {
		Object matrice [][] = new Object[this.getRowCount()-1][this.getColumnCount()];
		int j = 0;
		for(int i =0; i<this.getRowCount(); i++) {
			if(i != numLigne) {
				matrice[j] = this.donnees[i];
				j++;
			}
		}
		//Tableau.on ecrase la donnee par la nouvelle matrice
		this.donnees = matrice;
		//on actualise l'affichage des donnees
		this.fireTableDataChanged();
	}
	public void modifierLigne(int numLigne, Object ligne[]) {
		Object matrice [][] = new Object[this.getRowCount()][this.getColumnCount()];
		for(int i =0; i<this.getRowCount(); i++) {
			if(i != numLigne) {
				matrice[i] = this.donnees[i];
			}else {
				matrice[i] = ligne;
			}
		}
		//Tableau.on ecrase la donnee par la nouvelle matrice
		this.donnees = matrice;
		//on actualise l'affichage des donnees
		this.fireTableDataChanged();
	}
	public void setDonnees (Object matrice[][]) {
		//on ecrase la donnees par la nouvelle matrice
		this.donnees = matrice;
		//on actualise l'affichage des donnees
		this.fireTableDataChanged();
	}
}
