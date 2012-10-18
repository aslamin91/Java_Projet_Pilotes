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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Formulaire_Pilote extends JFrame implements ActionListener{
	
	private JPanel panGlobal;
	private JPanel panhaut;
	private JPanel panBas;
	
	private JMenuBar menu;
	
	private JMenu menuPilote;
	private JMenuItem ajoutPilote;
	private JMenuItem affichePilote;
	
	private JLabel lblnom;
	private JLabel lblprenom;
	
	private JTextField jtfnom;
	private JTextField jtfprenom;
	
	private JButton btnVallider;
	private JButton btnAfficher;
	
	
	public Formulaire_Pilote(int i){
		
		
		
		if(i==1){
			
			this.panGlobal = new JPanel();
			this.panhaut = new JPanel();
			this.panBas = new JPanel();
			
			this.menu = new JMenuBar();
			this.menuPilote = new JMenu("Pilote");
			this.ajoutPilote = new JMenuItem("Ajouter un Pilote");
			this.affichePilote = new JMenuItem("Affiche les Pilotes");
			
			this.ajoutPilote.addActionListener(this);
			this.affichePilote.addActionListener(this);
			
			menuPilote.add(ajoutPilote);
			menuPilote.add(affichePilote);
			
			menu.add(menuPilote);
			this.setJMenuBar(menu);
			
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
		else{
		this.panGlobal = new JPanel();
		this.panhaut = new JPanel();
		this.panBas = new JPanel();
		
		this.menu = new JMenuBar();
		this.menuPilote = new JMenu("Pilote");
		this.ajoutPilote = new JMenuItem("Ajouter un Pilote");
		this.affichePilote = new JMenuItem("Affiche les Pilotes");
		
		this.ajoutPilote.addActionListener(this);
		this.affichePilote.addActionListener(this);
		
		menuPilote.add(ajoutPilote);
		menuPilote.add(affichePilote);
		
		menu.add(menuPilote);
		this.setJMenuBar(menu);
		

		
		this.lblnom = new JLabel("Nom : ");
		this.lblprenom = new JLabel("Prenom : ");
		
		this.jtfnom = new JTextField();
		this.jtfprenom = new JTextField();
		
		this.btnVallider = new JButton("Valider");
		
		this.setTitle("Formulaire Pilote");
		this.setLocation(450, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(350, 300);
		this.setResizable(false);
		
		this.btnVallider.addActionListener(this);

		

		
		panhaut.setLayout(new GridLayout(2, 2));
		panhaut.add(lblnom);
		panhaut.add(jtfnom);
		
		panhaut.add(lblprenom);
		panhaut.add(jtfprenom);
		
		panBas.setLayout(new BorderLayout());
		panBas.add(btnVallider, BorderLayout.CENTER);
		
		panGlobal.setLayout(new BorderLayout());
		panGlobal.add(panhaut, BorderLayout.NORTH);
		panGlobal.add(panBas, BorderLayout.CENTER);
		
		//Tourjours en dernière instruction !!!!
		
		this.getContentPane().add(panGlobal);
		this.setVisible(true);
		}
		
		
		
		
		
	}


	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnVallider){
			
			try {
				Class.forName("org.postgresql.Driver");
				Connection connexion = DriverManager.getConnection("jdbc:postgresql:bdmohamed", "amohamed", "jasmine95");
				Statement st = connexion.createStatement();
				st.executeUpdate
				("INSERT INTO pilotes (nompilote, prenompilote) VALUES ('"+jtfnom.getText()+"', '"+jtfprenom.getText()+"');");
				connexion.close();
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
		if(e.getSource() == ajoutPilote){
			int i = 0;
			this.setVisible(false);
			new Formulaire_Pilote(i);
		}
		if(e.getSource() == affichePilote){
			System.out.println("Affiche");
			int i = 1;
			this.setVisible(false);
			new AffichePilote(i);
			
	
		}
		
		
	}

}
