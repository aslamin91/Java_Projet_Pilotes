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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class AffichePilote extends JFrame implements ActionListener{
	
	private JPanel panGlobal;
	private JPanel panhaut;
	private JPanel panBas;
	
	private JMenuBar menu;
	
	private JMenu menuPilote;
	private JMenuItem ajoutPilote;
	private JMenuItem affichePilote;
	private JMenuItem afficheUnPilote;
	
	private JLabel lblnom;
	private JLabel lblprenom;
	
	private JButton btnAfficher;
	
	public AffichePilote(){
		
		this.panGlobal = new JPanel();
		this.panhaut = new JPanel();
		this.panBas = new JPanel();
		
		this.menu = new JMenuBar();
		this.menuPilote = new JMenu("Pilote");
		this.ajoutPilote = new JMenuItem("Ajouter un Pilote");
		this.affichePilote = new JMenuItem("Affiche les Pilotes");
		this.afficheUnPilote = new JMenuItem("Affiche les Pilotes");
		
		this.ajoutPilote.addActionListener(this);
		this.affichePilote.addActionListener(this);
		this.afficheUnPilote.addActionListener(this);
		
		menuPilote.add(ajoutPilote);
		menuPilote.add(affichePilote);
		menuPilote.add(afficheUnPilote);
		
		menu.add(menuPilote);
		this.setJMenuBar(menu);
		
		this.btnAfficher = new JButton("Afficher");
		
		this.setTitle("Affichage Pilote");
		this.setLocation(450, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setResizable(true);
		
		this.btnAfficher.addActionListener(this);
		
		this.panhaut.setLayout(new BorderLayout());
		this.panhaut.add(btnAfficher, BorderLayout.CENTER);
		
			try {
				Class.forName("org.postgresql.Driver");
				Connection connexion = DriverManager.getConnection("jdbc:postgresql:bdmohamed", "amohamed", "jasmine95");
				Statement st = connexion.createStatement();
				Statement st2 = connexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM pilotes");
				ResultSet rs2 = st2.executeQuery("SELECT * FROM pilotes");
				
				/*JLabel jnum = new JLabel("Num Pilote");
				JLabel jnom = new JLabel("Nom Pilote");
				JLabel jprenom = new JLabel("Prenom Pilote");
				panBas.add(jnum);
				panBas.add(jnom);
				panBas.add(jprenom);*/
				int j = 0;
				int t = 0;
				//Recupère une variable t qui sera le nombre de ligne récupéré
				while(rs2.next()){
					
					t++;
				}
				Object[][] data = new Object[t][3];
				String title[] = {"Num Pilote", "Nom Pilote", "Prenom Pilote"};
				while (rs.next()) {
					
					String num = rs.getString("numpilote");
					String nom = rs.getString("nompilote");
					String prenom = rs.getString("prenompilote");
					/*JLabel lblnum = new JLabel(num);
					JLabel lblnom = new JLabel(nom);
					JLabel lblprenom = new JLabel(prenom);
					panBas.setLayout(new GridLayout(rs.getFetchSize(),3));*/
					System.out.println("NumPilote : "+num+" Nom : "+nom+" Prenom : "+prenom);
					/*panBas.add(lblnum);
					panBas.add(lblnom);
					panBas.add(lblprenom);*/
					data[j][0] = num;
					data[j][1] = nom;
					data[j][2] = prenom;
					j++;
					}
				
					rs.close() ;
					JTable tab = new JTable(data, title);
					this.getContentPane().add(new JScrollPane(tab));
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
		
		//this.panGlobal.add(panhaut, BorderLayout.NORTH);
		
		//this.panGlobal.add(panBas, BorderLayout.CENTER);
		
		//this.getContentPane().add(panGlobal);
		this.setVisible(true);

		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ajoutPilote){
			this.dispose();
			new Formulaire_Pilote();
		}
		if(e.getSource() == affichePilote){
			System.out.println("Affiche");
			this.dispose();
			new AffichePilote();
	
		}
		if(e.getSource() == afficheUnPilote){
			System.out.println("AfficheP");
			this.dispose();
			new InfoPilote();
	
		}
}
}
