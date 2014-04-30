package exodecorateur_angryballs.maladroit.versioncorrect;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

import exodecorateur_angryballs.maladroit.vues.versioncorrect.CadreAngryBalls;
import exodecorateur_angryballs.maladroit.modele.versioncorrect.Bille;
import exodecorateur_angryballs.maladroit.modele.versioncorrect.BilleBloque;
import exodecorateur_angryballs.maladroit.modele.versioncorrect.BilleFrottement;
import exodecorateur_angryballs.maladroit.modele.versioncorrect.BilleFranchissement;
import exodecorateur_angryballs.maladroit.modele.versioncorrect.BilleNewton;
import exodecorateur_angryballs.maladroit.modele.versioncorrect.BilleNue;
import exodecorateur_angryballs.maladroit.modele.versioncorrect.BillePesanteur;
import exodecorateur_angryballs.maladroit.modele.versioncorrect.BilleRebond;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement different
 * 
 * Ideal pour mettre en place le DP decorator
 * */
public class TestAngryBalls
{

/**
 * @param args
 */
public static void main(String[] args)
{
//------------------- creation de la liste (pour l'instant vide) des billes -----------------------

Vector<Bille> billes = new Vector<Bille>();

//---------------- creation de la vue responsable du dessin des billes -------------------------

CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                                        "Animation de billes ayant des comportements differents. Pattern Decorateur + Observateur + Son implementes",
                                        billes);

cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 4 billes -------------------------------



double xMax, yMax;
double vMax = 0.1;
xMax = cadre.largeurBillard();      // abscisse maximal
yMax = cadre.hauteurBillard();      // ordonnee maximale

double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le meme rayon, mais ce n'est pas obligatoire

Vecteur p0, p1, p2, p3, p4,p5,  v0, v1, v2, v3, v4,v5;    // les positions des centres des billes et les vecteurs vitesse au demarrage. 
                                                    // Elles vont etre choisies aleatoirement

//------------------- creation des vecteurs position des billes ---------------------------------

p0 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
p1 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
p2 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
p3 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
p4 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
p5 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
//------------------- creation des vecteurs vitesse des billes ---------------------------------

v0 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
v1 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, 0);
v2 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
v3 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
v4 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
v5 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie e changer ---------------------------------

Bille billeRouge, billeJaune, billeVerte, billeBleue, billeNoire, billeRose;
//Bille rouge -> absence d´acceleration, rebond sur les bords
billeRouge=new BilleRebond(new BilleNue(p0, rayon, v0, Color.red));
billeJaune=new BilleRebond(new BilleFrottement(new BillePesanteur(new BilleNue(p1, rayon, v1, Color.yellow), new Vecteur(0,0.001))));
billeVerte=new BilleRebond(new BilleFrottement(new BilleNewton(new BilleNue(p2, rayon, v2, Color.green))));
billeBleue=new BilleFranchissement(new BilleNue(p3, rayon, v3, Color.cyan));
billeNoire=new BilleBloque(new BilleNewton(new BilleNue(p4, rayon, v4, Color.black)));
billeRose = new BillePesanteur(new BilleFrottement(new BilleFranchissement(new BilleNewton(new BilleNue(p5, rayon, v5, Color.pink)))),new Vecteur(0,0.001));
billes.add(billeRouge);
billes.add(billeJaune);
billes.add(billeVerte);
billes.add(billeBleue);
billes.add(billeNoire);
billes.add(billeRose);

//---------------------- ici finit la partie e changer -------------------------------------------------------------


System.out.println("billes = " + billes);


//-------------------- creation de l'objet responsable de l'animation (c'est un thread separe) -----------------------

AnimationBilles animationBilles = new AnimationBilles(billes, cadre);


cadre.addObserveur(animationBilles);


}

}
