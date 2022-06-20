package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Roille_SA;
import controleur.Client;
import modele.Modele;

public class VueConnexion extends JFrame implements ActionListener, KeyListener{
	private JPanel unPanel = new JPanel();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btConnexion = new JButton("Enregistrer");
	private JTextField txtUsername = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	
	public VueConnexion() {
		this.setTitle("Gestion des stocks de Roille_SA ");
		this.setBounds(0, 0, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		//Construction du panel
		this.unPanel.setBounds(300, 50, 250, 70);
		this.unPanel.setBackground(Color.gray);
		this.unPanel.setLayout(new GridLayout(3, 2));
		this.unPanel.add(new JLabel("Username :"));
		this.unPanel.add(this.txtUsername);
		this.unPanel.add(new JLabel("MDP :"));
		this.unPanel.add(this.txtMdp);
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btConnexion);
		//Ajout de l'image
		ImageIcon uneImage = new ImageIcon ("src/images/Logo_Roille.jpg");
		JLabel logo = new JLabel(uneImage);
		logo.setBounds(20, 10, 200, 350);
		this.add(logo);
		//Ajout du panel
		this.add(unPanel);
		//Rendre les boutons écoutables
		this.btAnnuler.addActionListener(this);
		this.btConnexion.addActionListener(this);
		this.txtUsername.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtMdp.setText("");
			this.txtUsername.setText("");
		} else if (e.getSource() == this.btConnexion) {
			traitement();
		}
		
	}

	public void traitement() {
		String username = this.txtUsername.getText();
		String mdp = new String (this.txtMdp.getPassword());
		
		Client unClient = Modele.selectWhereClientUsername(username, mdp);
		if (unClient == null) {
			JOptionPane.showMessageDialog(this, "Vérifiez vos identifiants");
		} else {
			JOptionPane.showMessageDialog(this, "Bienvenue "+unClient.getNom()+" "+unClient.getPrenom()+" \n \n Vous avez le rôle : "+unClient.getRole());
			//ouverture de l'application
			Roille_SA.instancierVueGenerale(unClient);
			//On cache la VueConnexion
			Roille_SA.rendreVisibleVueConnexion(false);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			traitement();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

