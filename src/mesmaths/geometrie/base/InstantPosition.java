package mesmaths.geometrie.base;

/**
 * Definit un triplet (t,x(t),y(t)) representant la position e un instant t d'un point mobile dans le plan
 * 
 * */
public class InstantPosition
{
public double instant; // instant t
public Vecteur position; // position sur la courbe e l'instant t. cf. trajectoire
/**
 * @param instant
 * @param position
 */
public InstantPosition(double instant, Vecteur position)
{
this.instant = instant;
this.position = position;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString()
{
return "(" + this.instant + ", "
        + this.position + ")";
}



}
