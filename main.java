import java.sql.*;

public class main {

	public static void main(String[] args) {
		Formulaire_Pilote Unformulaire = new Formulaire_Pilote();
		/*try {
			Class.forName("org.postgresql.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:postgresql:bdmohamed", "amohamed", "jasmine95");
			Statement st = connexion.createStatement();
			st.executeUpdate
			("INSERT INTO pilotes (nompilote, prenompilote) VALUES ('"+unNom+"', '"+unPrenom+"');");
		} 
		catch (ClassNotFoundException e) {
			
			System.out.println("Driver non chargé !"+e);
		}
		catch(SQLException e){
			System.out.println("Erreur Connexion BD !"+e);
		}
		finally{
			
			System.out.println("Fait !");
		}*/
		
		/*try {
			Class.forName("org.postgresql.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:postgresql:bdmohamed", "amohamed", "jasmine95");
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM pilotes");
			while (rs.next()) {
				int num = rs.getInt("numpilote");
				String nom = rs.getString("nompilote");
				String prenom = rs.getString("prenompilote");
				System.out.println("NumPilote : "+num+" Nom : "+nom+" Prenom : "+prenom);
				}
				rs.close() ;

		} 
		catch (ClassNotFoundException e) {
			
			System.out.println("Driver non chargé !"+e);
		}
		catch(SQLException e){
			System.out.println("Erreur Connexion BD !"+e);
		}
		finally{
			
			System.out.println("Fait !");
		}*/
		
		
		
		

	}

}
