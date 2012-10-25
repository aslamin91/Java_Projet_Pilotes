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


public class InfoPilote extends JFrame implements ActionListener {

	private JPanel panGlobal;
	private JPanel panhaut;
	private JPanel panBas;
	
	private JMenuBar menu;
	
	private JMenu menuPilote;
	private JMenuItem ajoutPilote;
	private JMenuItem affichePilote;
	private JMenuItem afficheUnPilote;
	
	private JLabel lblnum;
	private JLabel lblnom;
	private JLabel lblprenom;
	
	private JButton btnpremier;
	private JButton btnsuivant;
	private JButton btnprecedent;
	private JButton btndernier;
	
	public InfoPilote(){
		
		this.panGlobal = new JPanel();
		this.panhaut = new JPanel();
		this.panBas = new JPanel();
		
		this.menu = new JMenuBar();
		this.menuPilote = new JMenu("Pilote");
		this.ajoutPilote = new JMenuItem("Ajouter un Pilote");
		this.affichePilote = new JMenuItem("Affiche les Pilotes");
		this.afficheUnPilote = new JMenuItem("Affiche un Pilotes");
		
		this.ajoutPilote.addActionListener(this);
		this.affichePilote.addActionListener(this);
		this.afficheUnPilote.addActionListener(this);
		
		menuPilote.add(ajoutPilote);
		menuPilote.add(affichePilote);
		menuPilote.add(afficheUnPilote);
		
		menu.add(menuPilote);
		this.setJMenuBar(menu);
		
		
		this.setTitle("Affichage Un Pilote");
		this.setLocation(450, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setResizable(true);
		
		
		panGlobal.setLayout(new BorderLayout());
		panGlobal.add(panhaut, BorderLayout.NORTH);
		panGlobal.add(panBas, BorderLayout.CENTER);
		
		this.getContentPane().add(panGlobal);
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
