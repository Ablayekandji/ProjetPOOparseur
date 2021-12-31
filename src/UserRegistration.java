
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

import javax.swing.JScrollPane;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class UserRegistration extends JFrame {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewUserRegister;
    private JTextField nom;
    private JButton btnNewButton;
    private JTextField prenom;
    private JTextField dateNaissance;
    private JTextField lieuNaissance;
    private JTextField adresse;
    private JTextField nomFiliere;
    private final JScrollPane scrollPane = new JScrollPane();
    private JTextField nombreUe;
    private JCheckBox sexeFeminin,sexeMasculin;
    private JCheckBox cycleLicence,cycleMaster;
    private JComboBox niveau;
    private String alea="";

    /**
     * Lancement de la formulaire
     */
    public static void main(String[] args) {
     
                    UserRegistration frame = new UserRegistration();
                    
                    frame.setVisible(true);
    
    }

    /**
     * Creation de la formulaire
     */
    
    

    public UserRegistration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 644, 732);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        alea= aleatoire();
        lblNewUserRegister = new JLabel("Numero de la fiche: "+alea);
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewUserRegister.setBounds(136, 11, 402, 31);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel(" Nom(*)");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblName.setBounds(22, 94, 104, 31);
        contentPane.add(lblName);
        nom = new JTextField();
        nom.setBounds(136, 96,389, 26);
        contentPane.add(nom);
        btnNewButton = new JButton("Inscription");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Parseur parse = new Parseur(UserRegistration.this);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(215, 637, 145, 37);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Prenom(*)");
        lblNewLabel.setBounds(22, 136, 104, 26);
        contentPane.add(lblNewLabel);
        
        prenom = new JTextField();
        prenom.setBounds(136, 136, 389, 26);
        contentPane.add(prenom);
        prenom.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Sexe(*)");
        lblNewLabel_1.setBounds(22, 173, 69, 21);
        contentPane.add(lblNewLabel_1);
        
         sexeMasculin = new JCheckBox("Masculin");
         sexeMasculin.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		if(sexeMasculin.isSelected()) {
          			sexeFeminin.setEnabled(false);
          		}
          		else
          			sexeFeminin.setEnabled(true);
      
          	}
          });
   
        sexeMasculin.setBounds(137, 172, 97, 23);
        contentPane.add(sexeMasculin);
        
         sexeFeminin = new JCheckBox("Feminin");
         sexeFeminin.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		if(sexeFeminin.isSelected()) {
         			sexeMasculin.setEnabled(false);
         		}
         		else
         			sexeMasculin.setEnabled(true);
     
         	}
         });
      
        sexeFeminin.setBounds(286, 172, 97, 23);
        contentPane.add(sexeFeminin);
        
        JLabel lblNewLabel_2 = new JLabel("Date de naissance");
        lblNewLabel_2.setBounds(22, 205, 108, 26);
        contentPane.add(lblNewLabel_2);
        
        dateNaissance = new JTextField();
        dateNaissance.setBounds(136, 205, 164, 26);
        contentPane.add(dateNaissance);
        dateNaissance.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Lieu de naissance");
        lblNewLabel_3.setBounds(314, 205, 105, 26);
        contentPane.add(lblNewLabel_3);
        
        lieuNaissance = new JTextField();
        lieuNaissance.setBounds(429, 205, 96, 26);
        contentPane.add(lieuNaissance);
        lieuNaissance.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Adresse");
        lblNewLabel_4.setBounds(22, 242, 80, 26);
        contentPane.add(lblNewLabel_4);
        
        adresse = new JTextField();
        adresse.setBounds(136, 240, 164, 28);
        contentPane.add(adresse);
        adresse.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("     FORMATION");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel_5.setBounds(174, 281, 245, 31);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Nom fili\u00E9re(*)");
        lblNewLabel_6.setBounds(22, 322, 87, 26);
        contentPane.add(lblNewLabel_6);
        
        nomFiliere = new JTextField();
        nomFiliere.setBounds(136, 323, 152, 25);
        contentPane.add(nomFiliere);
        nomFiliere.setColumns(10);
        
        JLabel lblNewLabel_7 = new JLabel("Cycle(*)");
        lblNewLabel_7.setBounds(314, 325, 46, 21);
        contentPane.add(lblNewLabel_7);
        
         cycleLicence = new JCheckBox("Licence");
         cycleLicence.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		if(cycleLicence.isSelected()) {
          			cycleMaster.setEnabled(false);
          		}
          		else
          			cycleMaster.setEnabled(true);
      
          	}
          });
        
        cycleLicence.setBounds(362, 321, 97, 25);
        contentPane.add(cycleLicence);
        
         cycleMaster = new JCheckBox("Master");
         cycleMaster.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e) {
           		if(cycleMaster.isSelected()) {
           			cycleLicence.setEnabled(false);
           		}
           		else
           			cycleLicence.setEnabled(true);
       
           	}
           });
        
        cycleMaster.setBounds(461, 323, 97, 23);
        contentPane.add(cycleMaster);
        
        JLabel lblNewLabel_8 = new JLabel("Niveau(*)");
        lblNewLabel_8.setBounds(22, 359, 69, 24);
        contentPane.add(lblNewLabel_8);
		 niveau = new JComboBox();
        getNiveau().setModel(new DefaultComboBoxModel(new String[] {"", "Licence 1", "Licence 2", "Licence 3", "Master 1", "Master 2"}));
        getNiveau().setBounds(136, 360, 152, 22);
        contentPane.add(getNiveau());
        
        JLabel lblNewLabel_9 = new JLabel("PEDAGOGIE");
        lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel_9.setBounds(207, 384, 176, 37);
        contentPane.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("Nombre d'UE");
        lblNewLabel_10.setBounds(317, 358, 81, 24);
        contentPane.add(lblNewLabel_10);
        
        nombreUe = new JTextField();
        nombreUe.setBounds(406, 358, 53, 24);
        contentPane.add(nombreUe);
        nombreUe.setColumns(10);
        
        JLabel lblNewLabel_11 = new JLabel("Liste des UE");
        lblNewLabel_11.setBounds(22, 433, 80, 21);
        contentPane.add(lblNewLabel_11);
        
        JComboBox listeUe = new JComboBox();
        listeUe.setBounds(136, 432, 152, 22);
        contentPane.add(listeUe);
        
        JLabel lblNewLabel_12 = new JLabel("DETAILS OPTIONNELLE");
        lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel_12.setBounds(201, 472, 337, 29);
        contentPane.add(lblNewLabel_12);
        
        JLabel lblNewLabel_13 = new JLabel("Liste des EC");
        lblNewLabel_13.setBounds(22, 532, 80, 21);
        contentPane.add(lblNewLabel_13);
        
        JLabel lblNewLabel_14 = new JLabel("  IDENTITE");
        lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel_14.setBounds(196, 55, 164, 30);
        contentPane.add(lblNewLabel_14);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(136, 531, 152, 22);
        contentPane.add(comboBox);
        
        JLabel lblNewLabel_15 = new JLabel("Liste UE");
        lblNewLabel_15.setBounds(314, 532, 90, 21);
        contentPane.add(lblNewLabel_15);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(379, 531, 120, 21);
        contentPane.add(comboBox_1);
       
        
      
    }
    
 

	public String aleatoire() {
    	Random rand = new Random();
    	String recu="";
    	String alphabet = "ABCDEFGHIJKLMMN123567890";
    	int longueur = alphabet.length();
    	for(int i = 0; i < 12; i++) {
    	  int k = rand.nextInt(longueur);
    	  System.out.print(alphabet.charAt(k)+" ");
    	  recu+=alphabet.charAt(k);
    	}
    	return recu;
    }
	
	
	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	public void setPrenom(JTextField prenom) {
		this.prenom = prenom;
	}

	public void setDateNaissance(JTextField dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setLieuNaissance(JTextField lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public void setAdresse(JTextField adresse) {
		this.adresse = adresse;
	}

	public void setNomFiliere(JTextField nomFiliere) {
		this.nomFiliere = nomFiliere;
	}

	public void setNombreUe(JTextField nombreUe) {
		this.nombreUe = nombreUe;
	}

	public void setSexeFeminin(JCheckBox sexeFeminin) {
		this.sexeFeminin = sexeFeminin;
	}

	public void setSexeMasculin(JCheckBox sexeMasculin) {
		this.sexeMasculin = sexeMasculin;
	}

	public void setCycleLicence(JCheckBox cycleLicence) {
		this.cycleLicence = cycleLicence;
	}

	public void setCycleMaster(JCheckBox cycleMaster) {
		this.cycleMaster = cycleMaster;
	}

	public void setNiveau(JComboBox niveau) {
		this.niveau = niveau;
	}

	public void setAlea(String alea) {
		this.alea = alea;
	}

	public String getAlea() {
		return alea;
	}
	
	public JLabel getLblNewUserRegister() {
		return lblNewUserRegister;
	}

	

	public JTextField getNom() {
		return nom;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public JTextField getPrenom() {
		return prenom;
	}

	public JTextField getDateNaissance() {
		return dateNaissance;
	}

	public JTextField getLieuNaissance() {
		return lieuNaissance;
	}

	public JTextField getAdresse() {
		return adresse;
	}

	public JTextField getNomFiliere() {
		return nomFiliere;
	}

	public JTextField getNombreUe() {
		return nombreUe;
	}
	public JCheckBox getSexeMasculin() {
		return sexeMasculin;
	}

	public JCheckBox getSexeFeminin() {
		return sexeFeminin;
	}


	public JCheckBox getCycleLicence() {
		return cycleLicence;
	}

	public JCheckBox getCycleMaster() {
		return cycleMaster;
	}

	public JComboBox getNiveau() {
		return niveau;
	}
}