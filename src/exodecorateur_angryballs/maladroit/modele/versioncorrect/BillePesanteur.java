/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exodecorateur_angryballs.maladroit.modele.versioncorrect;

import java.util.Vector;
import mesmaths.geometrie.base.Vecteur;

/**
 *
 * @author Micael
 */
public class BillePesanteur  extends DecorateurBille
{
	Vecteur pesanteur;

	public BillePesanteur(Bille maBille, Vecteur pesanteur) 
	{
		super(maBille);
		this.pesanteur = pesanteur;
	}

	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		super.gestionAcceleration(billes);
		this.getAcceleration().ajoute(this.pesanteur); 
	}



}
