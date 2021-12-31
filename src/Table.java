
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {
	private String cTable = "create table etudiant(\r\n" + "  ine  varchar(250) primary key,\r\n" +
	        "  nom varchar(250),\r\n" + "  prenom varchar(250),\r\n" + "  sexe varchar(250),\r\n" +
			"  datenaissance varchar(250),\r\n" + "  lieunaissance varchar(250),\r\n" + "  adresse varchar(250),\r\n" +
	        "  filiere varchar(250),\r\n" + "  cycle varchar(250),\r\n"+"  niveau varchar(250),\r\n"+ 
	        "  nombreUe integer\r\n" +"  );";

	 public static void main(String[] argv) throws SQLException {
		 Table creertable = new Table();
		 creertable.createTable();
	    }
	
	
	
	 public void createTable() throws SQLException {

	        System.out.println(cTable);
	        
	        try {
	        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet2020?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");	
	            
	            Statement statement = connection.createStatement(); 
	        	System.out.println("niania");
	         
	            statement.execute(cTable);
	            System.out.println("niania"); 
	        } catch (SQLException e) {

	            
	        }

	        
	    }

}
