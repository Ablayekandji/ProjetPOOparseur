import javax.swing.JFrame;

public class Modification extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Modification(Accueil modif) {
		UserRegistration usermodif= new UserRegistration();
		usermodif.setAlea(modif.getIne());
		usermodif.getNom().setText(modif.getNom());
		usermodif.getPrenom().setText(modif.getPrenom());
		usermodif.setVisible(true);
	}
}
