package fr.unice.l3.formes;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChoixCouleur implements ActionListener{
	private EditeurImage editeurImage;
	
	ChoixCouleur (EditeurImage editeurImage){
		this.editeurImage = editeurImage;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JColorChooser color = new JColorChooser();
		Color couleurChoisie = color.showDialog(null, "Couleur du trait", Color.CYAN);
		this.editeurImage.setCouleurCourante(couleurChoisie);
	}
}
