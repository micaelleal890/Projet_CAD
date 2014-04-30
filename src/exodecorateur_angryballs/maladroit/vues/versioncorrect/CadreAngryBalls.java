package exodecorateur_angryballs.maladroit.vues.versioncorrect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;


import exodecorateur_angryballs.maladroit.modele.versioncorrect.Bille;
import outilsvues.EcouteurTerminaison;
import outilsvues.Outils;
import observer.Observable;
import observer.Observateur;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contrele (arret du programme, lancer les billes, arreter les billes) 
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class CadreAngryBalls extends Frame implements VueBillard, Observable
{
/**
	 * 
	 */
	private static final long serialVersionUID = 6226062900686753070L;
	TextField presentation;
	Billard billard;
	public Button lancerBilles, arreterBilles;
	Panel haut, centre, bas;
	
	EcouteurTerminaison ecouteurTerminaison;
	
	private ArrayList<Observateur> maListeObservateur=new ArrayList<Observateur>();
	
	public CadreAngryBalls(String titre, String message, Vector<Bille> billes) throws HeadlessException
	{
		super(titre);
		
		Outils.place(this, 0.33, 0.33, 0.5, 0.5);
		this.ecouteurTerminaison = new EcouteurTerminaison(this);
		
		
		this.haut = new Panel(); this.haut.setBackground(Color.LIGHT_GRAY);
		this.add(this.haut,BorderLayout.NORTH);
		
		this.centre = new Panel();
		this.add(this.centre,BorderLayout.CENTER);
		
		this.bas = new Panel(); this.bas.setBackground(Color.LIGHT_GRAY);
		this.add(this.bas,BorderLayout.SOUTH);
		
		this.presentation = new TextField(message, 100); this.presentation.setEditable(false);
		this.haut.add(this.presentation);
		
		this.billard = new Billard(billes);
		this.add(this.billard);
		
		this.lancerBilles = new Button("lancer les billes"); this.bas.add(this.lancerBilles);
		this.arreterBilles = new Button("arreter les billes"); this.bas.add(this.arreterBilles);
		
		this.lancerBilles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				notifyObservers("lancer");
			}
		});
		this.arreterBilles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				notifyObservers("arreter");
			}
		});
		
			
			
		
		
	}
	
	public double largeurBillard() 
	{
	return this.billard.getWidth();
	}
	
	public double hauteurBillard()
	{
	return this.billard.getHeight();
	}
	
	@Override
	public void miseAJour()
	{
	this.billard.repaint();
	}
	
	/* (non-Javadoc)
	 * @see exodecorateur.vues.VueBillard#montrer()
	 */
	@Override
	public void montrer()
	{
	this.setVisible(true);
	}
	
	@Override
	public void notifyObservers(String action) 
	{
		for( Observateur obs : this.maListeObservateur)
		{
			obs.update(action);
		}
		System.out.println("Button was pressed");
	}
	
	@Override
	public void addObserveur(Observateur observeur) 
	{
		this.maListeObservateur.add(observeur);
	}
	

}