/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exodecorateur_angryballs.maladroit.modele.versioncorrect;

import java.util.Vector;


/**
 *
 * @author Micael
 */
public class BilleNewton  extends DecorateurBille
{

	public BilleNewton(Bille mabille) 
	{
		super(mabille);
	}

	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		super.gestionAcceleration(billes);                              // remise a zero du vecteur acceleration
		this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes));     // contribution de l'acceleration due a l'attraction des autres billes
	}

}