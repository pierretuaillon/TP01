package fr.unice.l3.formes;

import java.awt.*;
import javax.swing.*;
import fr.unice.l3.formes.*;
import fr.unice.l3.formes.Point;
import fr.unice.l3.formes.Rectangle;

public class EditeurImage extends JFrame {

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
		JPanel pan = new JPanel();
		//Ajout du panel a la frame
		frame.add(pan);
		
		
		/*
		 * Pour supprimer le Layout par défaut d'une classe, il faut appeler la méthode setLayout() avec comme paramètre null.
		 *	Trois méthodes de la classe Component permettent de positionner des composants :
		 *		setBounds(int x, int y, int largeur, int hauteur)
		 *		setLocation(int x , int y)
		 *		setSize(int largeur, int hauteur)
		 */
		
		pan.setLayout(new BorderLayout());
		//On met en blanc le background
		pan.setBackground(Color.white);
		
		//On creer 2 rectangles
		Rectangle r1 = new Rectangle(new Point(100, 100), 100, 100);
		Rectangle r2 = new Rectangle(new Point(10, 10), 50, 150);
		
		//On change la taille du trait
		r1.setTrait(15);
		r2.setTrait(6);
		
		//IOn creer 2 ellipses
		Ellipse e1 = new Ellipse(new Point(150, 150), 20, 50);
		Ellipse e2 = new Ellipse(new Point(25, 250), 60, 60);
		
		//On change la taille du trait
		e1.setTrait(5);
		e2.setTrait(20);
		
		//On ajoute tous les elements au panel
		pan.add(r1);
		pan.add(r2);
		pan.add(e1);
		pan.add(e2);
		
		//Definition de la position de l'objet
		r1.setBounds(r1.getX(), r1.getY(), r1.getLargeur()*10, r1.getHauteur()*10);
		r2.setBounds(r2.getX(), r2.getY(), r2.getLargeur()*10, r2.getHauteur()*10);
		e1.setBounds(e1.getX(), e1.getY(), e1.getLargeur()*10, e1.getHauteur()*10);
		e2.setBounds(e2.getX(), e2.getY(), e2.getLargeur()*10, e2.getHauteur()*10);
		
		//Méthode pour dessiner dans le panel
		pan.repaint();
		frame.setContentPane(pan);
		//pan.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new EditeurImage();
	}

}
