import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Accueil extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private static final String QUERY = "select *from etudiant where ine =?";
    private JPanel contentPane;
    private String ine ="",nom="",prenom="",sexe="",datenaissance="",lieunaissance="",adresse="",filiere="",cycle="",niveau="";
    private int nbreue=0;
    
    public static void main(String[] args) {
        
        UserLogin frame = new UserLogin();
        frame.setVisible(true);
        

}


	public Accueil(UserLogin b) {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	setBounds(450, 190, 644, 732);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        String ine ="",nom="",prenom="",sexe="",datenaissance="",lieunaissance="",adresse="",filiere="",cycle="",niveau="";
	        int nbreue=0;
	        
	        try {
	         	
	             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet2020?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");

	             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
	                 preparedStatement.setString(1,b.getIneetudiant());
	                 System.out.println(preparedStatement);
	                 // Step 3: Execute the query or update query
	                 ResultSet rs = preparedStatement.executeQuery();

	                 // Step 4: Process the ResultSet object.
	                 while (rs.next()) {
	                      ine = rs.getString("ine");
	                      nom = rs.getString("nom");
	                      prenom = rs.getString("prenom");
	                      sexe = rs.getString("sexe");
	                      datenaissance = rs.getString("datenaissance");
	                      lieunaissance = rs.getString("lieunaissance");
	                      adresse = rs.getString("adresse");
	                      filiere =rs.getString("filiere");
	                      cycle=rs.getString("cycle");
	                      niveau =rs.getString("niveau");
	                      nbreue=rs.getInt("nombreUe");
	                     System.out.println(ine + "," + nom + "," + prenom + "," + sexe + "," + datenaissance+ "," + lieunaissance+ "," + adresse+ "," + filiere+ "," + "," + cycle+ "," + niveau+ "," + nbreue);
	                 }
	         } catch (Exception exception) {
	             exception.printStackTrace();
	         }
	        
	        JLabel lblNewLabel = new JLabel("Bonjour M./Mme: "+prenom);
	        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel.setBounds(55, 11, 476, 42);
	        contentPane.add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("INE:  "+ine);
	        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_1.setBounds(55, 64, 476, 42);
	        contentPane.add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("Nom :"+nom);
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_2.setBounds(55, 117, 460, 42);
	        contentPane.add(lblNewLabel_2);
	        
	        JLabel lblNewLabel_3 = new JLabel("Prenom:"+prenom);
	        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_3.setBounds(55, 170, 481, 42);
	        contentPane.add(lblNewLabel_3);
	        
	        JLabel lblNewLabel_4 = new JLabel("Sexe: "+sexe);
	        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_4.setBounds(55, 223, 460, 42);
	        contentPane.add(lblNewLabel_4);
	        
	        JLabel lblNewLabel_5 = new JLabel("Date de Naissance: "+datenaissance);
	        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_5.setBounds(55, 276, 460, 42);
	        contentPane.add(lblNewLabel_5);
	        
	        JLabel lblNewLabel_6 = new JLabel("Lieu de Naissance: "+lieunaissance);
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_6.setBounds(55, 330, 460, 42);
	        contentPane.add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_6_1 = new JLabel("Adresse:  "+adresse);
	        lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_6_1.setBounds(55, 383, 460, 42);
	        contentPane.add(lblNewLabel_6_1);
	        
	        JLabel lblNewLabel_6_2 = new JLabel("Filiere: "+filiere);
	        lblNewLabel_6_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_6_2.setBounds(55, 436, 460, 42);
	        contentPane.add(lblNewLabel_6_2);
	        
	        JLabel lblNewLabel_6_3 = new JLabel("Cycle: "+cycle);
	        lblNewLabel_6_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_6_3.setBounds(55, 489, 460, 42);
	        contentPane.add(lblNewLabel_6_3);
	        
	        JLabel lblNewLabel_6_4 = new JLabel("Niveau: "+niveau);
	        lblNewLabel_6_4.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_6_4.setBounds(55, 542, 205, 42);
	        contentPane.add(lblNewLabel_6_4);
	        
	        JLabel lblNewLabel_6_5 = new JLabel("NombreUE: "+nbreue);
	        lblNewLabel_6_5.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblNewLabel_6_5.setBounds(327, 542, 192, 42);
	        contentPane.add(lblNewLabel_6_5);
	        
	        JButton btnNewButton = new JButton("Modifier");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Modification modifier= new Modification(Accueil.this);
	        	
	        		
	        	}
	        });
	        btnNewButton.setBounds(230, 618, 117, 35);
	        contentPane.add(btnNewButton);
		
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getIne() {
		return ine;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getSexe() {
		return sexe;
	}


	public String getDatenaissance() {
		return datenaissance;
	}


	public String getLieunaissance() {
		return lieunaissance;
	}


	public String getFiliere() {
		return filiere;
	}


	public String getCycle() {
		return cycle;
	}


	public String getNiveau() {
		return niveau;
	}


	public int getNbreue() {
		return nbreue;
	}
}
