import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AffichePilote extends JFrame implements ActionListener{
	
	
	private JPanel panGlobal;
	private JPanel panhaut;
	private JPanel panBas;
	
	private JButton btnAfficher;
	
	
	public AffichePilote(int i){
		
		this.panGlobal = new JPanel();
		this.panhaut = new JPanel();
		this.panBas = new JPanel();
		
		this.btnAfficher = new JButton("Afficher");
		
		this.setTitle("Affichage Pilote");
		this.setLocation(450, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(350, 300);
		this.setResizable(false);
		
		this.btnAfficher.addActionListener(this);
		
		this.panhaut.setLayout(new BorderLayout());
		this.panhaut.add(btnAfficher, BorderLayout.CENTER);
		
		
		
		if(i==1){
			try {
				Class.forName("org.postgresql.Driver");
				Connection connexion = DriverManager.getConnection("jdbc:postgresql:bdmohamed", "amohamed", "jasmine95");
				Statement st = connexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM pilotes");
				
				JLabel jnum = new JLabel("Num Pilote");
				JLabel jnom = new JLabel("Nom Pilote");
				JLabel jprenom = new JLabel("Prenom Pilote");
				while (rs.next()) {
					
					String num = rs.getString("numpilote");
					String nom = rs.getString("nompilote");
					String prenom = rs.getString("prenompilote");
					JLabel lblnum = new JLabel(num);
					JLabel lblnom = new JLabel(nom);
					JLabel lblprenom = new JLabel(prenom);
					panBas.setLayout(new GridLayout(rs.getFetchSize(),3));
					System.out.println("NumPilote : "+num+" Nom : "+nom+" Prenom : "+prenom);
					panBas.add(lblnum);
					panBas.add(lblnom);
					panBas.add(lblprenom);
					}
					rs.close() ;

			} 
			catch (ClassNotFoundException erreur) {
				
				System.out.println("Driver non chargé !"+erreur);
			}
			catch(SQLException erreur){
				System.out.println("Erreur Connexion BD !"+erreur);
			}
			finally{
				
				System.out.println("Fait !");
			}
			
		}
		
		this.panGlobal.add(panhaut, BorderLayout.NORTH);
		this.panGlobal.add(panBas, BorderLayout.CENTER);
		
		this.getContentPane().add(panGlobal);
		this.setVisible(true);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAfficher){
			int i = 1;
			this.setVisible(false);
			new AffichePilote(i);
			
	
		}
	
	
	}
}
