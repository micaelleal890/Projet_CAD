/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exodecorateur_angryballs.maladroit.modele.versioncorrect;

import java.awt.Color;
import mesmaths.geometrie.base.Vecteur;

/**
 *
 * @author Micael
 */
public class BilleNue extends Bille{
    
    	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param acceleration
	 * @param couleur
	 */
    public BilleNue(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acceleration, Color couleur)
    {
	this.position = centre;
	this.rayon = rayon;
	this.vitesse = vitesse;
	this.acceleration = acceleration;
	this.couleur = couleur;
	this.clef = BilleNue.prochaineClef ++;
    }
    
    	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
    public BilleNue(Vecteur position, double rayon, Vecteur vitesse, Color couleur)
    {
	this(position,rayon,vitesse,new Vecteur(),couleur);
    }
}
