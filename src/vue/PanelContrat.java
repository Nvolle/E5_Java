package vue;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Contrat;
import controleur.Tableau;
import modele.Modele;

public class PanelContrat extends PanelDeBase implements ActionListener {

	private JPanel panelFrom = new JPanel();
	private JButton btAnnuler =  new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	private JTextField txtDateDebut = new JTextField();
	private JTextField txtDateFin = new JTextField();
	private JTextField txtEtat = new JTextField();
	private JTextField txtIdc = new JTextField();
	
	private JTable uneTable;
	private JScrollPane uneScroll;
	private Tableau unTableau;
	
	//Panel rechercher
	private JPanel panelRechercher = new JPanel();
	private JTextField txtMot = new JTextField("");
	private JButton btRechercher = new JButton("Rechercher");
	
	public PanelContrat() {
		
		super(Color.gray);
		this.panelFrom.setBounds(20,50,250,300);
		this.panelFrom.setBackground(new Color(111,138,162));
		
		this.panelFrom.setLayout(new GridLayout(5,2));
		this.panelFrom.add(new JLabel("Date de debut du Contrat :"));
		this.panelFrom.add(this.txtDateDebut);
		this.panelFrom.add(new JLabel("Date de fin du Contrat :"));
		this.panelFrom.add(this.txtDateFin);
		this.panelFrom.add(new JLabel("Etat du contrat :"));
		this.panelFrom.add(this.txtEtat);
		this.panelFrom.add(new JLabel("Id du client :"));
		this.panelFrom.add(this.txtIdc);
		
		this.panelFrom.add(this.btAnnuler);
		this.panelFrom.add(this.btEnregistrer);
		
		this.add(this.panelFrom);
		
		//Construction de la Scroll
		String entetes [] = {"ID Contrat","Date de debut","Date de fin"};
		Object matrice [] [] = this.getLesContrats("");
		
		this.unTableau = new Tableau(matrice,entetes);
		
		this.uneTable = new JTable(this.unTableau);
		this.uneScroll = new JScrollPane(this.uneTable);
		this.uneScroll.setBounds(340,100,450,250);
		this.add(this.uneScroll);
		
		//Installation du panel rechercher
		this.panelRechercher.setBounds(380,40,340,20);
		this.panelRechercher.setBackground(Color.cyan);
		this.panelRechercher.setLayout(new GridLayout(1,3));
		this.panelRechercher.add(new JLabel("Filtrer les contrats"));
		this.panelRechercher.add(this.txtMot);
		this.panelRechercher.add(this.btRechercher);
		this.add(this.panelRechercher);
		
		this.uneTable.addMouseListener(new MouseListener() {
			
			
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// TODO Auto-generated method stub
				int nbClic = e.getClickCount();
				int numLigne = uneTable.getSelectedRow();
			
				//Suppression de la ligne
				if (nbClic == 2 ) {
					//Modification de la ligne
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le contrat ?",
							"Suppression d'un contrat",JOptionPane.YES_NO_OPTION);
					if(retour == 0) {
						int idCo = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
						Modele.deleteContrat(idCo);
						unTableau.supprimerLigne(numLigne);
					} else if(nbClic == 1) {
						//Modification du client via le formulaire
					}
				}
				
			}
		});
		
		
		//Rendre les btn ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
	}
public Object [] [] getLesContrats (String mot) {
	
	ArrayList<Contrat> lesContrats = Modele.selectAllContrat(mot);
	Object [][] matrice = new Object [lesContrats.size()][5];
	int i = 0;
	for(Contrat unContrat : lesContrats) {
		
		matrice[i][0] = unContrat.getIdCo();
		matrice[i][1] = unContrat.getDatedebut();
		matrice[i][2] = unContrat.getDatefin();
		matrice[i][3] = unContrat.getEtat();
		
		i++;

	}
	return matrice;
	
}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		} else if(e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer")) {
			traitement(0);
		}else if(e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier")) {
			traitement(1);
		}else if(e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Rechercher")) {
			String mot = this.txtMot.getText();
			
			//cangement de la matrice
			
		}
		
	}
	public void viderChamps() {
		
		this.txtDateDebut.setText("");
		this.txtDateFin.setText("");
		this.txtEtat.setText("");
	
	}
	
	public void traitement (int choix) {
		
		String DateDebut = this.txtDateDebut.getText();
		String DateFin = this.txtDateFin.getText();	
		String Etat = this.txtEtat.getText();
		String Idc = this.txtIdc.getText();
		
		if (choix == 0) {
		//Instancier la classe Contrat 
		Contrat unContrat = new Contrat(DateDebut,DateFin,Etat,Idc);
		
		//Insertion du client dans la bdd
		Modele.insertContrat(unContrat);
		
		//Recuperer l'ID du client inséré dans la base de données
		unContrat = Modele.selectWhereContrat(DateDebut,DateFin);
		
		Object ligne[] = {unContrat.getIdCo(),
				unContrat.getDatedebut(),
				unContrat.getDatefin(),
				unContrat.getIdClient()
				};
		
		//On actualise le tableau, on appelle la méthode ajouter
		this.unTableau.ajouterLigne(ligne);
		
		JOptionPane.showMessageDialog(this, "Insertion réussie du contrat");
		
		} else if (choix ==1) {
			int numLigne = this.uneTable.getRowCount();
			int idCo = Integer.parseInt(this.unTableau.getValueAt(numLigne, 0).toString());
			Contrat unContrat = new Contrat (idCo,DateDebut,DateFin,Etat,Idc);
			Modele.updateContrat(unContrat);
			Object Ligne [] = {unContrat.getIdCo(),
					unContrat.getDatedebut(),
					unContrat.getDatefin(),
					unContrat.getIdClient()
					};
			this.unTableau.modifierLigne(numLigne,Ligne);
			JOptionPane.showMessageDialog(this,"Modification réussie du contrat");
			
		}
		
		this.viderChamps();
		this.btEnregistrer.setText("Enregistrer");
		
	}
}
