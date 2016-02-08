package fr.unice.l3.formes;

import java.awt.*;
import javax.swing.*;
import fr.unice.l3.formes.*;
import fr.unice.l3.formes.Point;
import fr.unice.l3.formes.Rectangle;

public class EditeurImage extends JFrame {

	public EditeurImage() {
		JFrame maFenetre = new JFrame();
		
		maFenetre.setVisible(true);
		maFenetre.setTitle("TP1 POO Semestre 6 / Editeur d'image");
		maFenetre.setSize(new Dimension(350, 350));
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel monPanel = new JPanel();
		maFenetre.add(monPanel);
		monPanel.setLayout(new BorderLayout());
		monPanel.setBackground(Color.white);
		
		Rectangle r1 = new Rectangle(new Point(100, 100), 100, 100);
		Rectangle r2 = new Rectangle(new Point(10, 10), 50, 150);
		r1.setTrait(15);
		r2.setTrait(6);
		Ellipse e1 = new Ellipse(new Point(150, 150), 20, 50);
		Ellipse e2 = new Ellipse(new Point(25, 250), 60, 60);
		e1.setTrait(5);
		e2.setTrait(20);
		
		monPanel.add(r1);
		monPanel.add(r2);
		monPanel.add(e1);
		monPanel.add(e2);
		
		r1.setBounds(r1.getX(), r1.getY(), r1.getLargeur()*10, r1.getHauteur()*10);
		r2.setBounds(r2.getX(), r2.getY(), r2.getLargeur()*10, r2.getHauteur()*10);
		e1.setBounds(e1.getX(), e1.getY(), e1.getLargeur()*10, e1.getHauteur()*10);
		e2.setBounds(e2.getX(), e2.getY(), e2.getLargeur()*10, e2.getHauteur()*10);
		
		monPanel.repaint();
		maFenetre.setContentPane(monPanel);
		monPanel.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new EditeurImage();
	}

}
