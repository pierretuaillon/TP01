package fr.unice.l3.formes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;

public class Rectangle extends AFormeGeometrique {
	public Rectangle(Point coin, int largeur, int hauteur) {
		super(coin, largeur, hauteur);
	}
	
	@Override
	double surface() {
		return getLargeur()*getHauteur();
	}

	@Override
	double perimetre() {
		return 2*(getLargeur() + getHauteur());
	}
	
	@Override
	public String toString() {
		return "Rectangle"+super.toString();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(this.trait));
		g2d.setBackground(getBackground());
		g2d.drawRect(this.ancrage.x, this.ancrage.y, this.hauteur, this.largeur);
	}
}
