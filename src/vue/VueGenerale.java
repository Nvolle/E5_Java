package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Client;
import controleur.Roille_SA;

public class VueGenerale extends JFrame implements ActionListener{
	private JPanel panelProfil = new JPanel();
	private JPanel panelMenu = new JPanel();
	private JButton btProfil = new JButton("Profil");
	private JButton btClient = new JButton("Client");
	private JButton btContrat = new JButton("Contrat");
	private JButton btFacture = new JButton("Facture");
	private JButton btTypeMat = new JButton("Types de matériels");
	private JButton btMateriel = new JButton("Matériels");
	private JButton btLocation = new JButton("Location");
	private JButton btStats = new JButton("Stats");
	private JButton btBord = new JButton("T-Bord");
	private JButton btDeconnexion = new JButton("Déconnexion");
	
	//Création des panels des cinq boutons
	private PanelClient unPanelClient = new PanelClient();
	private PanelContrat unPanelContrat = new PanelContrat();
	/*private PanelFacture unPanelFacture = new PanelFacture();
	/*private PanelTypeMat unPanelTypeMat = new PanelTypeMat();
	private PanelMateriel unPanelMateriel = new PanelMateriel();
	private PanelLocation unPanelLocation = new PanelLocation();
	private PanelStats unPanelStats = new PanelStats();
	private PanelBord unPanelBord = new PanelBord();*/
	
	public VueGenerale(Client unClient) {
		this.setTitle("Administraton de Roille SA");
		this.setBounds(200, 100, 900, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.cyan);
		//Construction du panel Menu
		this.panelMenu.setBackground(Color.cyan);
		this.panelMenu.setBounds(50, 20, 800, 30);
		this.panelMenu.setLayout(new GridLayout(1, 7));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btClient);
		this.panelMenu.add(this.btContrat);
		this.panelMenu.add(this.btFacture);
		this.panelMenu.add(this.btTypeMat);
		this.panelMenu.add(this.btMateriel);
		this.panelMenu.add(this.btLocation);
		if (unClient.getRole().equals("admin") || unClient.getRole().equals("superadmin")) {
			this.panelMenu.add(this.btStats);
			this.panelMenu.add(this.btBord);
		}
		this.panelMenu.add(this.btDeconnexion);
		this.add(this.panelMenu);
		//Construction du panel Profil
		this.panelProfil.setBackground(Color.cyan);
		this.panelProfil.setBounds(50, 20, 400, 200);
		this.panelProfil.setLayout(new GridLayout(4, 1));
		this.panelProfil.add(new JLabel("Nom user	    : "+unClient.getNom()));
		this.panelProfil.add(new JLabel("Prénom user 	: "+unClient.getPrenom()));
		this.panelProfil.add(new JLabel("Username user  : "+unClient.getUsername()));
		this.panelProfil.add(new JLabel("Rôle user   	: "+unClient.getRole()));
		this.add(panelProfil);
		this.panelProfil.setVisible(false);
		//Rendre les boutons écoutables
		this.btProfil.addActionListener(this);
		this.btClient.addActionListener(this);
		this.btContrat.addActionListener(this);
		this.btFacture.addActionListener(this);
		this.btTypeMat.addActionListener(this);
		this.btMateriel.addActionListener(this);
		this.btLocation.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btBord.addActionListener(this);
		this.btDeconnexion.addActionListener(this);
		//Ajout des panels dans la fenêtre
		this.add(this.unPanelClient);
		this.add(this.unPanelContrat);
		/*this.add(this.unPanelFacture);
		/*this.add(this.unPanelTypeMat);
		this.add(this.unPanelMateriel);
		this.add(this.unPanelLocation);
		this.add(this.unPanelStats);	
		this.add(this.unPanelBord);*/
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btDeconnexion) {
			Roille_SA.detruireVueGenerale();
			Roille_SA.rendreVisibleVueConnexion(true);
		} else if (e.getSource() == this.btProfil) {
			this.unPanelClient.setVisible(false);
			this.unPanelContrat.setVisible(false);
			/*this.unPanelFacture.setVisible(false);
			/*this.unPanelTypeMat.setVisible(false);
			this.unPanelMateriel.setVisible(false);
			this.unPanelLocation.setVisible(false);
			this.unPanelStats.setVisible(false);
			this.unPanelBord.setVisible(false);*/
			this.panelProfil.setVisible(true);
		} else if (e.getSource() == this.btClient) {
			this.unPanelClient.setVisible(true);
			this.unPanelContrat.setVisible(false);
			/*this.unPanelFacture.setVisible(false);
			/*this.unPanelTypeMat.setVisible(false);
			this.unPanelMateriel.setVisible(false);
			this.unPanelLocation.setVisible(false);
			this.unPanelStats.setVisible(false);
			this.unPanelBord.setVisible(false);*/
			this.panelProfil.setVisible(false);
		} else if (e.getSource() == this.btContrat) {
			this.unPanelClient.setVisible(false);
			this.unPanelContrat.setVisible(true);
			/*this.unPanelFacture.setVisible(false);
			/*this.unPanelTypeMat.setVisible(false);
			this.unPanelMateriel.setVisible(false);
			this.unPanelLocation.setVisible(false);
			this.unPanelStats.setVisible(false);
			this.unPanelBord.setVisible(false);*/
			this.panelProfil.setVisible(false);
		} else if (e.getSource() == this.btFacture) {
			this.unPanelClient.setVisible(false);
			this.unPanelContrat.setVisible(false);
			/*this.unPanelFacture.setVisible(true);
			/*this.unPanelTypeMat.setVisible(false);
			this.unPanelMateriel.setVisible(false);
			this.unPanelLocation.setVisible(false);
			this.unPanelStats.setVisible(false);
			this.unPanelBord.setVisible(false);*/
			this.panelProfil.setVisible(false);
		} else if (e.getSource() == this.btTypeMat) {
			this.unPanelClient.setVisible(false);
			this.unPanelContrat.setVisible(false);
			/*this.unPanelFacture.setVisible(false);
			/*this.unPanelTypeMat.setVisible(true);
			this.unPanelMateriel.setVisible(false);
			this.unPanelLocation.setVisible(false);
			this.unPanelStats.setVisible(false);
			this.unPanelBord.setVisible(false);*/
			this.panelProfil.setVisible(false);
		} else if (e.getSource() == this.btMateriel) {
			this.unPanelClient.setVisible(false);
			this.unPanelContrat.setVisible(false);
			/*this.unPanelFacture.setVisible(false);
			/*this.unPanelTypeMat.setVisible(false);
			this.unPanelMateriel.setVisible(true);
			this.unPanelLocation.setVisible(false);
			this.unPanelStats.setVisible(false);
			this.unPanelBord.setVisible(false);*/
			this.panelProfil.setVisible(false);
		} else if (e.getSource() == this.btLocation) {
			this.unPanelClient.setVisible(false);
			this.unPanelContrat.setVisible(false);
			/*this.unPanelFacture.setVisible(false);
			/*this.unPanelTypeMat.setVisible(false);
			this.unPanelMateriel.setVisible(false);
			this.unPanelLocation.setVisible(true);
			this.unPanelStats.setVisible(false);
			this.unPanelBord.setVisible(false);*/
			this.panelProfil.setVisible(false);
		} else if (e.getSource() == this.btStats) {
			this.unPanelClient.setVisible(false);
			this.unPanelContrat.setVisible(false);
			/*this.unPanelFacture.setVisible(false);
			/*this.unPanelTypeMat.setVisible(false);
			this.unPanelMateriel.setVisible(false);
			this.unPanelLocation.setVisible(false);
			this.unPanelStats.setVisible(true);
			this.unPanelBord.setVisible(false);*/
			this.panelProfil.setVisible(false);
		} else if (e.getSource() == this.btBord) {
			this.unPanelClient.setVisible(true);
			this.unPanelContrat.setVisible(false);
			/*this.unPanelFacture.setVisible(false);
			/*this.unPanelTypeMat.setVisible(false);
			this.unPanelMateriel.setVisible(false);
			this.unPanelLocation.setVisible(false);
			this.unPanelStats.setVisible(false);
			this.unPanelBord.setVisible(true);*/
			this.panelProfil.setVisible(false);
		} 
	}
}
