/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exodecorateur_angryballs.maladroit.modele.versioncorrect;

import mesmaths.cinematique.Collisions;

/**
 *
 * @author Micael
 */
public class BilleBloque  extends DecorateurBille
{

	public BilleBloque(Bille maBille) 
	{
		super(maBille);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) 
	{
		Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonneeCoinHautGauche, hauteur);
	}
}
