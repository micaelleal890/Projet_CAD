/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package observer;

/**
 *
 * @author Micael
 */
public interface Observable {
    	public void notifyObservers(String action);
	
	/**
	 * Ajoute un observeur
     * @param observateur
	 */
	public void addObserveur(Observateur observateur);
}
