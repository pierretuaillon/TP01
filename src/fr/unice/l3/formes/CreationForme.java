package fr.unice.l3.formes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.*;

public class CreationForme  implements ActionListener, MouseInputListener {

	private EditeurImage editeurImage;
	private int xDep;
	private int xFin;
	private int yDep;
	private int yFin;
	
	public CreationForme(EditeurImage editeurImage) {
		this.editeurImage = editeurImage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		this.editeurImage.setString(button.getText());
		/*
		System.out.println(button.getText());
		JPanel zoneDessin = this.editeurImage.getZoneDessin();
		
		int x = (int) (Math.random()*zoneDessin.getWidth()*0.8);
		int width = (int) (Math.random()*zoneDessin.getWidth()*0.2);
		int y = (int) (Math.random()*zoneDessin.getHeight()*0.8);
		int height = (int) (Math.random()*zoneDessin.getHeight()*0.2);
		int epaisseur = (int) (Math.random()*5 + 1);
		switch (button.getText()){
		case "Rectangle" :
			Rectangle r = new Rectangle(new Point(x, y), width, height);
			r.setTrait(epaisseur);
			zoneDessin.add(r);
		break;
		
		case "Ellipse" :
			Ellipse el = new Ellipse(new Point(x, y), width, height);
			el.setTrait(epaisseur);
			zoneDessin.add(el);
		break;
		
		default :
			
		
		}
		
		zoneDessin.validate();
		*/
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		this.xDep = arg0.getX();
		this.yDep = arg0.getY();	
		/*JPanel zoneDessin = this.editeurImage.getZoneDessin();
		Rectangle r = new Rectangle(new Point(this.xDep, this.yFin), 20, 20);
		zoneDessin.add(r);
		zoneDessin.validate();*/
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		JPanel zoneDessin = this.editeurImage.getZoneDessin();
		int longFin;
		int largFin;
		if (this.xDep < this.xFin){
			longFin = this.xFin - this.xDep;
		}else{
			longFin = this.xDep - this.xFin;
		}
		
		if (this.yDep < this.yFin){
			largFin = this.yFin - this.yDep;
		}else{
			largFin = this.yDep - this.yFin;
		}
		
		Rectangle r = new Rectangle(new Point(this.xDep, this.yDep), longFin, largFin);
		zoneDessin.add(r);
		zoneDessin.validate();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		this.xFin = arg0.getX();
		this.yFin = arg0.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}
}
