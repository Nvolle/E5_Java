package vue;
import java.awt.Color;
import javax.swing.JPanel;

public abstract class PanelDeBase extends JPanel{
	
	public PanelDeBase(Color uneCouleur) {
		this.setBounds(50,50,800,400);
		this.setLayout(null);
		this.setBackground(uneCouleur);
		this.setVisible(false);
	}
}
