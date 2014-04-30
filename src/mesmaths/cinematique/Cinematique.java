package mesmaths.cinematique;

import mesmaths.geometrie.base.Vecteur;

public class Cinematique
{
/**
 * suppose qu'un objet mobile subit un mouvement rectiligne uniforme (c'e-d un deplacement en ligne droite e vitesse constante)
 * 
 * le mouvement de l'objet est e tout instant defini par le vecteur position et le vecteur vitesse.
 * 
 *  DONNEES : position et vitesse e l'instant t, deltaT (deltaT est le delai entre 2 mises e jour, deltaT est suppose petit) 
 * 
 * RESULTATS : position e l'instant t + deltaT
 * 
 * vitesse est laisse inchange par la methode
 * 
 * 
 * Le calcul peut etre note comme suit :
 * 
 * p(t+deltaT) = p(t) + deltaT * v(t)
 * v(t+deltaT) = v(t)
 * 
 * */
private static void mouvementRectiligneUniforme(Vecteur position, Vecteur vitesse, double deltaT)
{
position.ajoute(vitesse.produit(deltaT));   
}

/**
 * suppose qu'un objet mobile subit un mouvement uniformement accelere entre t et t+deltaT (c'e-d un deplacement comme la chute libre)
 * 
 * le mouvement de l'objet est e tout instant defini par le vecteur position, le vecteur vitesse et le vecteur acceleration
 * 
 *  DONNEES : position, vitesse et acceleration e l'instant t, deltaT (deltaT est le delai entre 2 mises e jour, deltaT est suppose petit) 
 * 
 * RESULTATS : position et  vitesse  e l'instant t + deltaT. 
 * 
 * acceleration reste inchange par la methode. Il faudra le recalculer  l'instant t+deltaT avec une autre methode 
 * 
 * 
 * * Les calculs peuvent etre notes comme suit :
 * 
 * p(t+deltaT) = p(t) + deltaT * v(t) + (1/2) * deltaT^2 * a(t)
 * v(t+deltaT) = v(t) + deltaT * a(t)
 * a(t + deltaT) = a(t)
 * 
 * @param position : vecteur position du mobile e l'instant t. ce parametre est modifie par la methode : en sortie il represente la position e l'instant t+deltaT 
 * @param vitesse : vecteur vitesse du mobile e l'instant t. ce parametre est modifie par la methode : en sortie il represente la vitesse e l'instant t+deltaT
 * @param acceleration : vecteur acceleration du mobile e l'instant t
 * @param deltaT : une duree tres courte
 * 
 * */
public static void mouvementUniformementAccelere(Vecteur position, Vecteur vitesse, Vecteur acceleration, double deltaT)
{
mouvementRectiligneUniforme( position, vitesse, deltaT);
position.ajoute(acceleration.produit(0.5*deltaT*deltaT));
mouvementRectiligneUniforme(vitesse, acceleration, deltaT);
//acceleration.set(Vecteur.VECTEURNUL);
}
}
