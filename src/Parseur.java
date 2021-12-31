import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Parseur {
	int verification=0; //pour savoir si les donnees sont integres
	int tmpsexe,tmpcycle; //pour verifier lequel des cycles ou sexes est choisi
	public Parseur( UserRegistration fiche) {
		
		//pour verifier si les champs qui sont dans la condition sont vide
		if(fiche.getNom().getText().isEmpty() ||fiche.getPrenom().getText().isEmpty()||fiche.getNomFiliere().getText().isEmpty()) {
			if(fiche.getNom().getText().isEmpty()) {
				fiche.getNom().setBackground(Color.red);
				verification++;
			}
			if(fiche.getPrenom().getText().isEmpty())
			{
				fiche.getPrenom().setBackground(Color.red);
				verification++;
			}
			if(fiche.getNomFiliere().getText().isEmpty())
			{
				fiche.getNomFiliere().setBackground(Color.red);
				verification++;
			}
			
		}
		
		
		if(!fiche.getSexeMasculin().isSelected()&& !fiche.getSexeFeminin().isSelected()) {
			fiche.getSexeMasculin().setBackground(Color.red);
			fiche.getSexeFeminin().setBackground(Color.red);
			verification++;
		}
		
		
		
		if(!fiche.getCycleLicence().isSelected()&& !fiche.getCycleMaster().isSelected()) {
			fiche.getCycleLicence().setBackground(Color.red);
			fiche.getCycleMaster().setBackground(Color.red);
			verification++;
		}
		
		if(fiche.getNiveau().getSelectedItem().equals("")) {
			fiche.getNiveau().setBackground(Color.red);
			verification++;
		}
		
		if(fiche.getNom().getText().isEmpty()||fiche.getPrenom().getText().isEmpty()||(fiche.getSexeMasculin().isSelected()&&fiche.getSexeFeminin().isSelected())||fiche.getNomFiliere().getText().isEmpty()||(fiche.getCycleLicence().isSelected()&&fiche.getCycleMaster().isSelected())||fiche.getNiveau().getSelectedItem().equals(""))
		{
			
			 JOptionPane.showMessageDialog(fiche.getBtnNewButton(), "Faut saisir au moins les champs en rouge");
			verification++;
		}
		
		if(!Pattern.matches("[a-zA-Z]*", fiche.getNom().getText().toString())|| !Pattern.matches("[a-zA-Z]*", fiche.getPrenom().getText().toString())|| !Pattern.matches("[a-zA-Z]*", fiche.getNomFiliere().getText().toString())) {
			
			if(!Pattern.matches("[a-zA-Z]*", fiche.getNom().getText().toString())) {
				fiche.getNom().setBackground(Color.red);
			}
			if(!Pattern.matches("[a-zA-Z]*", fiche.getPrenom().getText().toString())) {
				fiche.getPrenom().setBackground(Color.red);
			}
			if(!Pattern.matches("[a-zA-Z]*", fiche.getNomFiliere().getText().toString())) {
				fiche.getNomFiliere().setBackground(Color.red);
			}
			
			JOptionPane.showMessageDialog(fiche.getBtnNewButton(), "Faut pas mettre de chiffre ou de caracteres speciaux sur les champs nom,prenom,filiere");
			verification++;
		}
		if(!fiche.getLieuNaissance().getText().isEmpty()&& !Pattern.matches("[a-zA-Z]*", fiche.getLieuNaissance().getText().toString())) {
			JOptionPane.showMessageDialog(fiche.getBtnNewButton(), " Faut mettre uniquement une chaine de caractere sur le champ Lieu de Naissance");
			verification++;
		}
		
		
		
		if(!fiche.getNombreUe().getText().isEmpty()&& !Pattern.matches("[0-9]*", fiche.getNombreUe().getText().toString())) {
			JOptionPane.showMessageDialog(fiche.getBtnNewButton(), " Faut mettre uniquement un nombre sur le champ Nombre UE");
			verification++;
		}
		
		if(fiche.getSexeMasculin().isSelected()) {
			tmpsexe=1;
		}
		if(fiche.getSexeFeminin().isSelected()) {
			tmpsexe=0;
		}
			
		
		if(fiche.getCycleLicence().isSelected()) {
			tmpcycle=1;
		}
		if(fiche.getCycleMaster().isSelected()) {
			tmpcycle=0;
		}
		/*Si tout est bon on enregistre dans la base de donnees */
		if(verification==0) {
			    String prenom = fiche.getNom().getText();
            String nom = fiche.getPrenom().getText();
            String sexe="";
            if(tmpsexe==1)
            	sexe = fiche.getSexeMasculin().getText();
            if(tmpsexe==0)
            	sexe = fiche.getSexeFeminin().getText();
            String filiere = fiche.getNomFiliere().getText();
            String niveau = fiche.getNiveau().getSelectedItem().toString();
            String ine = fiche.aleatoire();
            String msg = "" + prenom;
            String lieunaissance=fiche.getLieuNaissance().getText();
            if(lieunaissance.equals(""))
            	lieunaissance="null";
            String datenaissance=fiche.getDateNaissance().getText();
            if(datenaissance.equals(""))
            	datenaissance="null";
            	
            String adresse=fiche.getAdresse().getText();
            if(adresse.equals(""))
            	adresse="null";
            String cycle="";
            if(tmpcycle==1)
            	cycle=fiche.getCycleLicence().getText();
            if(tmpcycle==0)
            	cycle=fiche.getCycleMaster().getText();
            int nbreue;
            if(fiche.getNombreUe().getText().equals(""))
            	nbreue=0;
            else
            	nbreue=Integer.parseInt(fiche.getNombreUe().getText().toString());
            msg += " \n";

            try {
            	
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet2020?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");

                String query = "INSERT INTO etudiant values('" + ine + "','" + nom + "','" + prenom + "','" +
                sexe + "','" + datenaissance +"','"+ lieunaissance +"','"  + adresse +"','"+ filiere + "','"+ cycle + "','" + niveau + "','" + nbreue +"')";

                Statement sta = connection.createStatement();
                int reponse = sta.executeUpdate(query);
                if (reponse == 0) {
                    JOptionPane.showMessageDialog(fiche.getBtnNewButton(), "Deja inscrit Verifier bien les informations!!");
                } else {
                    JOptionPane.showMessageDialog(fiche.getBtnNewButton(),
                        "Bienvenue, " + msg + "Inscription avec succes");
                }
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
		}
					
			
	}

}
