package fr.unice.l3.formes;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ellipse extends AFormeGeometrique {
	public Ellipse(Point centre, int largeur, int hauteur) {
		super(centre, largeur, hauteur);
	}
	
	@Override
	double surface() {
		return Math.PI*getLargeur()*getHauteur()/4;
	}

	@Override
	double perimetre() {
		return Math.PI*(getLargeur() + getHauteur())/2;
	}

	Point getCentre() {
		return super.getAncrage();
	}
	
	@Override
	public String toString() {
		return "Ellipse"+super.toString();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setStroke(new BasicStroke(this.trait));
		g2d.draw(new Ellipse2D.Double(this.ancrage.x, this.ancrage.y, this.largeur, this.hauteur));
			
	}
}
