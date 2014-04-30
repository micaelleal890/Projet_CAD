package exodecorateur_angryballs.maladroit.modele.versioncorrect;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Vector;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * 
 * Operations utiles sur les billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class OutilsBille
{
/**
 * @param billes est la liste de TOUTES les billes en mouvement
 * @param cetteBille est l'une d'entre elles.
 * @return la liste des autres billes que cetteBille, c'est-e-dire la liste de toutes les billes sauf cetteBille 
 * 
 * */
public static Vector<Bille> autresBilles(Bille cetteBille, Vector<Bille> billes)
{
Vector<Bille> autresBilles = new Vector<Bille>();

Bille billeCourante;

int i;

for( i = 0; i < billes.size(); ++i)
   {
   billeCourante = billes.get(i);
   if ( billeCourante.getClef() != cetteBille.getClef())
     autresBilles.add(billeCourante);
   }

return autresBilles;
}


/**
 * @param cetteBille : une bille particuliere
 * @param billes : une liste de billes, cette liste peut contenir cettebille
 *
 * gestion de l'eventuelle  collision de cette bille avec les autres billes
 *
 * billes est la liste de toutes les billes en mouvement
 * 
 * Le comportement par defaut est le choc parfaitement elastique (c-e-d rebond sans amortissement)
 * 
 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquees dans le choc sont modifiees
 * si renvoie false, il n'y a pas de collision et les billes sont laissees intactes 
 * */
public static  boolean gestionCollisionBilleBille(Bille cetteBille, Vector<Bille> billes)
{
//--- on recupere d'abord dans autresBilles toutes les billes sauf cetteBille ----

Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

//--- on cherche e present la 1ere des autres billes avec laquelle cetteBille est en collision ---------------------
//-------------- on suppose qu'il ne peut y avoir de collision qui implique plus de deux billes e la fois ---------------

Bille billeCourante;

int i;

for ( i = 0 ; i < autresBilles.size(); ++i)
    {
    billeCourante = autresBilles.get(i);
    if (Collisions.CollisionBilleBille(    cetteBille.getPosition(),    cetteBille.getRayon(),    cetteBille.getVitesse(),    cetteBille.masse(), 
                                        billeCourante.getPosition(), billeCourante.getRayon(), billeCourante.getVitesse(), billeCourante.masse()))
        {

                java.io.File file = new java.io.File(System.getProperty("user.dir")+"\\src\\sounds\\sonmortel.wav");
                AudioClip sound = null;
                try {
                    sound = Applet.newAudioClip(file.toURL());
                } catch (MalformedURLException ex) {
                    Logger.getLogger(OutilsBille.class.getName()).log(Level.SEVERE, null, ex);
                }
                     sound.play();
                return true;
        } 
    }
return false;
}

/**
 * @param cetteBille : une bille particuliere
 * @param billes : une liste de billes, cette liste peut contenir cettebille
 * 
 * On suppose que cetteBille subit l'attraction gravitationnelle due aux billes contenues dans "billes" autres que cetteBille.
 * 
 * teche : calcule a, le vecteur acceleration subi par cetteBille resultant de l'attraction par les autres billes de la liste.
 * 
 * @return a : le vecteur acceleration resultant
 * 
 * */
public static Vecteur gestionAccelerationNewton(Bille cetteBille, Vector<Bille> billes)
{

//--- on recupere d'abord dans autresBilles toutes les billes sauf celle-ci ----

Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

//-------------- e present on recupere les masses et les positions des autres billes ------------------
int i;
Bille billeCourante;

int d = autresBilles.size();

double masses [] = new double[d];   // les masses des autres billes
Vecteur C [] = new Vecteur[d];      // les positions des autres billes

for ( i = 0; i < d; ++i)
    {
    billeCourante = autresBilles.get(i);
    masses[i] = billeCourante.masse();
    C[i] = billeCourante.getPosition();
    }

//------------------ e present on calcule le champ de gravite exerce par les autres billes sur cette bille ------------------

return  MecaniquePoint.champGraviteGlobal( cetteBille.getPosition(),  masses, C);
}
}
