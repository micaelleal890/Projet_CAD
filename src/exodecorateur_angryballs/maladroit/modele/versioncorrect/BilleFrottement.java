/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exodecorateur_angryballs.maladroit.modele.versioncorrect;

import java.util.Vector;
import mesmaths.mecanique.MecaniquePoint;

/**
 *
 * @author Micael
 */
public class BilleFrottement  extends DecorateurBille
{

	public BilleFrottement(Bille maBille) 
	{
		super(maBille);
	}

	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		super.gestionAcceleration(billes); 
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'acceleration due au frottement dans l'air
	}


}

