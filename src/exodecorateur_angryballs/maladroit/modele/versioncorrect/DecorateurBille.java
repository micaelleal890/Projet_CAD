/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exodecorateur_angryballs.maladroit.modele.versioncorrect;

import java.awt.Graphics;
import java.util.Vector;
import mesmaths.geometrie.base.Vecteur;

/**
 *
 * @author Micael
 */
public class DecorateurBille extends Bille
{
	protected Bille maBille;
	
	public DecorateurBille(Bille maBille) 
	{
		this.maBille = maBille;
	}
	
	@Override
	public void dessine(Graphics g) 
	{	
		this.maBille.dessine(g);
	}
	
	@Override
	public void deplacer(double deltaT) 
	{	
		this.maBille.deplacer(deltaT);
	}
	
	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		this.maBille.gestionAcceleration(billes);
	}
	
	@Override
	public Vecteur getPosition() 
	{
		return this.maBille.getPosition();
	}
	
	@Override
	public int getClef()
	{
		return this.maBille.getClef();
	}
	
	@Override
	public Vecteur getAcceleration() 
	{
		return this.maBille.getAcceleration();
	}
	
	@Override
	public double getRayon() 
	{
		return this.maBille.getRayon();
	}
	
	@Override
	public Vecteur getVitesse() 
	{
		return this.maBille.getVitesse();
	}
	
	@Override
	public double masse() 
	{
		return this.maBille.masse();
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) 
	{
		this.maBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
	}

}
