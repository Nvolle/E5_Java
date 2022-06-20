package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Client;
import controleur.Tableau;
import modele.Modele;



public class PanelClient extends PanelDeBase implements ActionListener {

	private JPanel panelFrom = new JPanel();
	private JButton btAnnuler =  new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtCP = new JTextField();
	private JTextField txtSociete = new JTextField();
	private JTextField txtMail = new JTextField();
	private JTextField txtTel = new JTextField();
	private JTextField txtUsername = new JTextField();
	private JTextField txtMdp = new JTextField();
	private JComboBox<String> txtRole = new JComboBox<String>();
	
	
	private JTable uneTable;
	private JScrollPane uneScroll;
	private Tableau unTableau;
	
	//Panel rechercher
	private JPanel panelRechercher = new JPanel();
	private JTextField txtMot = new JTextField("");
	private JButton btRechercher = new JButton("Rechercher");
	
	String [] role = {"admin", "superadmin", "user"};

	
	public PanelClient() {
		
		super(Color.gray);
		this.panelFrom.setBounds(20,50,250,300);
		this.panelFrom.setBackground(new Color(111,138,162));
		
		this.panelFrom.setLayout(new GridLayout(12,2));
		this.panelFrom.add(new JLabel("Nom du Client :"));
		this.panelFrom.add(this.txtNom);
		this.panelFrom.add(new JLabel("Prénom du Client :"));
		this.panelFrom.add(this.txtPrenom);
		this.panelFrom.add(new JLabel("Adresse du Client :"));
		this.panelFrom.add(this.txtAdresse);
		this.panelFrom.add(new JLabel("Ville du Client :"));
		this.panelFrom.add(this.txtVille);
		this.panelFrom.add(new JLabel("Code postal du Client :"));
		this.panelFrom.add(this.txtCP);
		this.panelFrom.add(new JLabel("Societe du Pilote :"));
		this.panelFrom.add(this.txtSociete);
		this.panelFrom.add(new JLabel("Mail du Client :"));
		this.panelFrom.add(this.txtMail);
		this.panelFrom.add(new JLabel("Telephone du Client :"));
		this.panelFrom.add(this.txtTel);
		this.panelFrom.add(new JLabel("Username du Client :"));
		this.panelFrom.add(this.txtUsername);
		this.panelFrom.add(new JLabel("MDP du Client :"));
		this.panelFrom.add(this.txtMdp);
		this.panelFrom.add(new JLabel("Rôle du Client :"));
		this.panelFrom.add(this.txtRole);
		
		this.panelFrom.add(this.btAnnuler);
		this.panelFrom.add(this.btEnregistrer);
			
		for (int i = 0; i<role.length; i++) {
			this.txtRole.addItem(role[i]);
		}
		
		this.add(this.panelFrom);
		
		//Construction de la Scroll
		String entetes [] = {"ID Client","Nom","Adresse","ville","Code postal","Societe","Mail","Telephone","Username","MDP"};
		Object matrice [] [] = this.getLesClients("");
		
		this.unTableau = new Tableau(matrice,entetes);
		
		this.uneTable = new JTable(this.unTableau);
		this.uneScroll = new JScrollPane(this.uneTable);
		this.uneScroll.setBounds(340,100,450,250);
		this.add(this.uneScroll);
		
		//Installation du panel rechercher
		this.panelRechercher.setBounds(380,40,340,20);
		this.panelRechercher.setBackground(Color.cyan);
		this.panelRechercher.setLayout(new GridLayout(1,3));
		this.panelRechercher.add(new JLabel("Filtrer les clients"));
		this.panelRechercher.add(this.txtMot);
		this.panelRechercher.add(this.btRechercher);
		this.add(this.panelRechercher);
		
		this.uneTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int nbClic = e.getClickCount();
				int numLigne = uneTable.getSelectedRow();
				if (nbClic == 2 ) {
					//suppression de la ligne
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le pilote","Suppression d'un pilote", JOptionPane.YES_NO_OPTION);
					if (retour == 0) {
						int idClient = Integer.parseInt(unTableau.getValueAt(numLigne,0).toString());
						Modele.deleteClient(idClient);
						unTableau.supprimerLigne(numLigne);
					}
				}else if(nbClic == 1) {
					txtNom.setText(unTableau.getValueAt(numLigne, 1).toString());
					txtPrenom.setText(unTableau.getValueAt(numLigne, 2).toString());
					txtAdresse.setText(unTableau.getValueAt(numLigne, 3).toString());
					txtVille.setText(unTableau.getValueAt(numLigne, 4).toString());
					txtCP.setText(unTableau.getValueAt(numLigne, 5).toString());
					txtSociete.setText(unTableau.getValueAt(numLigne, 6).toString());
					txtMail.setText(unTableau.getValueAt(numLigne, 7).toString());
					txtTel.setText(unTableau.getValueAt(numLigne, 8).toString());
					//on change le nom du boutton
					btEnregistrer.setText("Modifier");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
			
		
		//Rendre les btn ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
	}
public Object [] [] getLesClients (String mot) {
	
	ArrayList<Client> lesClients = Modele.selectAllClient(mot);
	Object [][] matrice = new Object [lesClients.size()][11];
	int i = 0;
	for(Client unClient : lesClients) {
		
		matrice[i][0] = unClient.getIdClient();
		matrice[i][1] = unClient.getNom();
		matrice[i][2] = unClient.getPrenom();
		matrice[i][3] = unClient.getAdresse();
		matrice[i][4] = unClient.getVille();
		matrice[i][5] = unClient.getCp();
		matrice[i][6] = unClient.getSociete();
		matrice[i][7] = unClient.getMail();
		matrice[i][8] = unClient.getTel();
		matrice[i][9] = unClient.getUsername();
		matrice[i][9] = unClient.getMdp();
		
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
		
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtAdresse.setText("");
		this.txtVille.setText("");
		this.txtCP.setText("");
		this.txtSociete.setText("");
		this.txtMail.setText("");
		this.txtTel.setText("");
		this.txtUsername.setText("");

		
	}
	
	public void traitement (int choix) {
		
		String nom = this.txtNom.getText();
		String prenom = this.txtPrenom.getText();	
		String adresse = this.txtAdresse.getText();
		String ville = this.txtVille.getText();
		String cp = this.txtCP.getText();
		String societe = this.txtSociete.getText();
		String mail = this.txtMail.getText();
		String tel = this.txtTel.getText();
		String username = this.txtUsername.getText();
		String mdp = this.txtMdp.getText();
		String role = "";
		
		role = this.txtRole.getSelectedItem().toString();
		
		if (choix == 0) {
		//Instancier la classe Client 
		Client unClient = new Client(nom,prenom,adresse,ville,cp,societe,mail,tel,username, mdp, role);
		
		//Insertion du client dans la bdd
		Modele.insertClient(unClient);
		
		//Recuperer l'ID du client inséré dans la base de données
		unClient = Modele.selectWhereClientNom(nom,prenom, societe);
		
		Object ligne[] = {unClient.getIdClient(),
				unClient.getNom(),
				unClient.getPrenom(),
				unClient.getAdresse(),
				unClient.getVille(),
				unClient.getCp(),
				unClient.getSociete(),
				unClient.getMail(),
				unClient.getTel(),
				unClient.getUsername(),
				unClient.getMdp(),
				unClient.getRole()
				};
		
		//On actualise le tableau, on appelle la méthode ajouter
		this.unTableau.ajouterLigne(ligne);
		
		JOptionPane.showMessageDialog(this, "Insertion réussie du client");
		
		} else if (choix ==1) {
			int numLigne = this.uneTable.getRowCount();
			int idClient = Integer.parseInt(this.unTableau.getValueAt(numLigne, 0).toString());
			Client unClient = new Client (idClient,nom,prenom,adresse,ville,cp,societe,mail,tel,username,mdp,role);
			Modele.updateClient(unClient);
			Object Ligne [] = {unClient.getIdClient(),
					unClient.getNom(),
					unClient.getPrenom(),
					unClient.getAdresse(),
					unClient.getVille(),
					unClient.getCp(),
					unClient.getSociete(),
					unClient.getMail(),
					unClient.getTel(),
					unClient.getUsername()
					};
			this.unTableau.modifierLigne(numLigne,Ligne);
			JOptionPane.showMessageDialog(this, "Modification réussi du client");
		}
		
		this.viderChamps();
		this.btEnregistrer.setText("Enregistrer");
		
	}
}
