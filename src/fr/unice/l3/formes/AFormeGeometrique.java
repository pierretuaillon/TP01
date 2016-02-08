package fr.unice.l3.formes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JComponent;

abstract class AFormeGeometrique extends JComponent {
	protected Point ancrage;
	protected Color couleurTrait = Color.black;
	protected AlignementHorizontal horizontal = AlignementHorizontal.GAUCHE;
	protected AlignementVertical vertical = AlignementVertical.HAUT;
	protected int largeur, hauteur;
	protected int trait;

	public void setTrait(int trait) {
		this.trait = trait;
	}

	protected AFormeGeometrique(Point ancrage, int largeur, int hauteur) {
		super();
		this.ancrage = new Point(ancrage);
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	abstract double surface();
	abstract double perimetre();
	public final int getLargeur() { return this.largeur; }
	public final int getHauteur() { return this.hauteur; }
	
	final Point getCoinSuperieurGauche() {
		int x = horizontal.adapt(ancrage.getX(), getLargeur());
		int y = vertical.adapt(ancrage.getY(), getHauteur());
		
		return new Point(x, y);
	}
	final public void setHorizontal(AlignementHorizontal horizontal) {
		this.horizontal = horizontal;
	}
	final public AlignementHorizontal getHorizontal() {
		return horizontal;
	}
	final public void setVertical(AlignementVertical vertical) {
		this.vertical = vertical;
	}
	final public AlignementVertical getVertical() {
		return vertical;
	}
	
	final public Color getCouleurTrait() {
		return couleurTrait;
	}
	final public void setCouleurTrait(Color couleurTrait) {
		this.couleurTrait = couleurTrait;
	}
	
	final protected Point getAncrage() {
		return ancrage;
	}
	
	@Override
	public String toString() {
		return "["+getAncrage()+"; "+getLargeur()+"x"+getHauteur()+"]";
	}
}
