package fr.unice.l3.formes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import fr.unice.l3.formes.*;
import fr.unice.l3.formes.Point;
import fr.unice.l3.formes.Rectangle;

public class EditeurImage extends JFrame{

	private JPanel pan;
	private JPanel pan2;
	private Color couleurCourante;
	private String LastPressed ;

	public EditeurImage() {
		JFrame frame = new JFrame();

		//Définition des caractéristique de la fenetre
		//on rend la fenetre visible
		frame.setVisible(true);
		//on lui donne un titre
		frame.setTitle("Editeur d'image");
		//on défini sa taille
		frame.setSize(new Dimension(350, 350));
		//permet de stopper le programme à la fermeture de la fenetre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Creation d'un panel
		this.pan = new JPanel();
		//Ajout du panel a la frame
		frame.add(this.pan);


		/*
		 * Pour supprimer le Layout par défaut d'une classe, il faut appeler la méthode setLayout() avec comme paramètre null.
		 *	Trois méthodes de la classe Component permettent de positionner des composants :
		 *		setBounds(int x, int y, int largeur, int hauteur)
		 *		setLocation(int x , int y)
		 *		setSize(int largeur, int hauteur)
		 */

		this.pan.setLayout(new BorderLayout());
		//On met en blanc le background
		this.pan.setBackground(Color.white);

		//On creer 2 rectangles
		Rectangle r1 = new Rectangle(new Point(100, 100), 100, 100);
		Rectangle r2 = new Rectangle(new Point(10, 10), 50, 150);

		//On change la taille du trait
		r1.setTrait(1);
		r2.setTrait(2);

		//On creer 2 ellipses
		Ellipse e1 = new Ellipse(new Point(150, 250), 20, 40);
		Ellipse e2 = new Ellipse(new Point(25, 250), 60, 60);

		//On change la taille du trait
		e1.setTrait(1);
		e2.setTrait(2);

		//On ajoute tous les elements au panel
		this.pan.add(r1);
		this.pan.add(r2);
		this.pan.add(e1);
		this.pan.add(e2);

		//Definition de la position de l'objet
		r1.setBounds(r1.getX(), r1.getY(), r1.getLargeur()*10, r1.getHauteur()*10);
		r2.setBounds(r2.getX(), r2.getY(), r2.getLargeur()*10, r2.getHauteur()*10);
		e1.setBounds(e1.getX(), e1.getY(), e1.getLargeur()*10, e1.getHauteur()*10);
		e2.setBounds(e2.getX(), e2.getY(), e2.getLargeur()*10, e2.getHauteur()*10);

		
		this.pan2 = new JPanel();

		JButton bAucun = new JButton("Aucun");
		JButton bRectangle = new JButton("Rectangle");
		JButton bEllipse = new JButton("Ellipse");
		JButton bCouleur = new JButton("Couleur");
		bAucun.setMaximumSize(new Dimension(100, 30));
		bAucun.setMinimumSize(new Dimension(100, 30));

		bRectangle.setMaximumSize(new Dimension(100, 30));
		bRectangle.setMinimumSize(new Dimension(100, 30));

		bEllipse.setMaximumSize(new Dimension(100, 30));
		bEllipse.setMinimumSize(new Dimension(100, 30));

		bCouleur.setMaximumSize(new Dimension(100, 30));
		bCouleur.setMinimumSize(new Dimension(100, 30));

		this.pan2.add(bAucun);
		this.pan2.add(bRectangle);
		this.pan2.add(bEllipse);
		this.pan2.add(bCouleur);

		this.pan2.setLayout(new BoxLayout(pan2, BoxLayout.PAGE_AXIS));

		bAucun.addActionListener(new CreationForme(this));
		bRectangle.addActionListener(new CreationForme(this));
		bEllipse.addActionListener(new CreationForme(this));
		bCouleur.addActionListener(new ChoixCouleur(this));
		
		this.pan.addMouseListener(new CreationForme(this));
		this.pan.addMouseMotionListener(new CreationForme(this));
		
		Box boxVide = Box.createVerticalBox();
		boxVide.add(Box.createVerticalStrut(frame.getHeight()));
		this.pan2.add(boxVide);

		frame.add(pan2, BorderLayout.WEST);
		this.pan2.setBackground(Color.white);
		this.pan.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));
		JColorChooser choixCouleur = new JColorChooser();

		this.pan2.add(choixCouleur);
		//Méthode pour dessiner dans le panel
		this.pan.repaint();
	}

	public JPanel getZoneDessin(){
		return this.pan;
	}

	public JPanel getZoneOutil(){
		return this.pan2;
	}

	public Color getCouleurCourante(){
		return this.couleurCourante;
	}

	public void setCouleurCourante(Color c){
		this.couleurCourante=c;
		JPanel panOutil = this.getZoneOutil();
		Component [] compo = panOutil.getComponents();
		for (int i = 0; i<compo.length; i++){
			if (compo[i].getClass().equals(JButton.class)){
				JButton b = (JButton) compo[i];
				if (b.getText().equals("Couleur")){
					b.setBackground(c);
				}
			}
		}
	}
	
	public void setString(String titreBoutton){
		this.LastPressed = titreBoutton;
	}
	
	public static void main(String[] args) {
		new EditeurImage();
	}
}
