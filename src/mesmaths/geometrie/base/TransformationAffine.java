package mesmaths.geometrie.base;


/**
 * represente une transformation affine de R^2 dans R^2
 * 
 * definie par u |---> A*u + b  oe u est un vecteur quelconque
 * 
 * La transformation est entierement definie par la donnee de A et de b oe A est une matrice carree d'ordre 2 et b un vecteur quelconque de R^2
 * 
 * 
 * 
 * */
public class TransformationAffine
{
Matrice A; Vecteur b;



/**
 * @param a
 * @param b
 */
public TransformationAffine(Matrice a, Vecteur b)
{
A = a;
this.b = b;
}
 



/**
 * cree la rotation affine d'angle "angle" et de centre "centre" 
 * 
 * Soit P un point quelconque et P' son image par la transfo T creee. Soient a l'angle et C le centre alors T respecte les 2 conditions suivantes :
 * 1) |CP| = |CP'|
 * 2) angle oriente(CP,CP') = a
 * 
 * @param angle : angle de la rotation (en radians)
 * @param centre : centre de la rotation
 * 
 * */
public static TransformationAffine creeRotation(double angle, Vecteur centre)
{
Matrice R = Matrice.creeRotation(angle);
Vecteur u = centre.difference(R.produit(centre));
return new TransformationAffine(R, u);
}


/* *
 * Notons R l'ancien repere et R' le nouveau repere
 * Construit le changement de repere tel que le rectangle (P1a, P2a) dans l'ancien repere soit le rectangle (P1n,P2n)
 * dans le nouveau repere
 * 
 * On suppose que i et i' sont colineaires et que j et j' sont colineaires
 * oe (i,j) est la base de l'ancien repere R et (i',j') est la base du nouveau repere R'
 * 
 * Soit t la transformation affine ainsi obtenue
 * 
 * Soit P un point tel que P = [Y] dans R et P = [Y'] dans R'
 * 
 *  alors t.applique(Y') = Y
 * 
 * */
/*public TransformationAffine(Vecteur P1a, Vecteur P2a, Vecteur P1n, Vecteur P2n)
{
double m11, m22;
Vecteur deltaA, deltaN, I;
deltaA = P2a.difference(P1a); deltaN = P2n.difference(P1n);


m11 = deltaA.x/deltaN.x;
m22 = deltaA.y/deltaN.y;

this.A = Matrice.creeMatriceDiagonale(m11, m22);
I = A.produit(P2n);

this.b = P2a.difference(I);
}*/

/* *
 * Notons R (O,i,j) l'ancien repere et R'(O',i',j') le nouveau repere
 * P1a et P2a sont exprimes dans R avec P1a(x1,y1) et P2a(x2,y2)
 * P1n et P2n sont exprimes dans R'avec P1n(x1',y1') et P2n(x2',y2')
 * Construit la transformation affine t telle que :
 * Soit le rectangle rect(Q1,Q2) tel que t(rect(Q1,Q2))=rect(P1a,P2a). Q1 et Q2 sont exprimes dans R'
 * t verifie les conditions suivantes :
 * 1) il n'y a pas de deformation
 * c-e-d que  rect(P1a,P2a) a les memes proportions que rect(Q1,Q2)
 * 2) rect(P1n, P2n) contient rect(Q1,Q2)
 * 3) rect(Q1,Q2) est le plus grand possible
 * 4) Soit C le centre de rect(P1a,P2a) et soit C' le centre de (P1n,P2n) alors on a t(C') = C. c-e-d que t centre dans
 * rect(P1n,P2n) l'image contenue initialement dans rect(P1a,P2a) 
 * 
 * On suppose que i et i' sont colineaires et que j et j' sont colineaires
 * oe (i,j) est la base de l'ancien repere R et (i',j') est la base du nouveau repere R'
 * 
 * a est tel que a*i = i' et b est tel que b*j = j'
 * 
 * on suppose que x1 < x2 et y1 < y2 et |x2'-x1'| > 0 et |y2'-y1'| > 0 
 * Soit t la transformation affine ainsi obtenue
 * 
 * Soit P un point tel que P = [Y] dans R et P = [Y'] dans R'
 * 
 *  alors t.applique(Y') = Y
 * 
 * */
/*public TransformationAffine1(Vecteur P1a, Vecteur P2a, Vecteur P1n, Vecteur P2n, double a, double b)
{
double vl1,vl2; // |lambda1| et |lambda2|
double l1, l2;  // lambda1 et lambda2
Vecteur P1aP2a, P1nP2n;

// d'abord on determine |lambda1| et |lambda2|

P1aP2a = P2a.difference(P1a);
P1nP2n = P2n.difference(P1n);

double r1,r2, rbsura;

rbsura = Math.abs(b)/Math.abs(a);

r1 = Math.abs(P1aP2a.x)/Math.abs(P1nP2n.x);
r2 = Math.abs(P1aP2a.y)/Math.abs(P1nP2n.y);
vl1 = Math.max(r1, r2/rbsura);
vl2 = rbsura*vl1;

// maintenant on construit lambda1 et lambda2 grece aux v. absolues et aux signes


l1 =(P1nP2n.x > 0  ? vl1: -vl1 );
l2 =(P1nP2n.y > 0  ? vl2: -vl2 );

this.A = Matrice.creeMatriceDiagonale(l1, l2); // matrice de l'A.L. associee

// Il reste e calculer le terme constant tel que t(C')=C

Vecteur Ca, Cn;
Ca = P1a.somme(P2a).produit(0.5); // Ca est le centre de rect(P1a,P2a)
Cn = P1n.somme(P2n).produit(0.5); // Cn est le centre de rect(P1n,P2n)

Vecteur LCn = this.A.produit(Cn);
this.b = Ca.difference(LCn);
} // ouf! c'est fini
*/
/**
 * Notons R (O,i,j) l'ancien repere et R'(O',i',j') le nouveau repere
 * P1a et P2a sont exprimes dans R avec P1a(x1,y1) et P2a(x2,y2)
 * P1n et P2n sont exprimes dans R'avec P1n(x1',y1') et P2n(x2',y2')
 * Construit la transformation affine t telle que :
 * Soit le rectangle rect(Q1,Q2) tel que t(rect(Q1,Q2))=rect(P1a,P2a). Q1 et Q2 sont exprimes dans R'
 * t verifie les conditions suivantes :
 * 1) il n'y a pas de deformation
 * c-e-d que  rect(P1a,P2a) a les memes proportions que rect(Q1,Q2), plus exactement les vecteurs P1aP2a et Q1Q2 sont colineaires et de meme sens
 * 2) rect(P1n, P2n) contient rect(Q1,Q2)
 * 3) rect(Q1,Q2) est le plus grand possible
 * 4) Soit C le centre de rect(P1a,P2a) et soit C' le centre de (P1n,P2n) alors on a t(C') = C. c-e-d que t centre dans
 * rect(P1n,P2n) l'image contenue initialement dans rect(P1a,P2a) 
 * 
 * On suppose que i et i' sont colineaires et que j et j' sont colineaires
 * oe (i,j) est la base de l'ancien repere R et (i',j') est la base du nouveau repere R'
 * 
 * a est tel que a*i = i' et b est tel que b*j = j'
 * 
 * on suppose que x1 != x2 et y1 != y2 et |x2'-x1'| > 0 et |y2'-y1'| > 0 
 * Soit t la transformation affine ainsi obtenue
 * 
 * Soit P un point tel que P = [Y] dans R et P = [Y'] dans R'
 * 
 *  alors t.applique(Y') = Y
 * 
 * */
public TransformationAffine(Vecteur P1a, Vecteur P2a, Vecteur P1n, Vecteur P2n)
{
double vl1,vl2; // |lambda1| et |lambda2|
double l1, l2;  // lambda1 et lambda2
Vecteur P1aP2a, P1nP2n;

// d'abord on determine |lambda1| et |lambda2|

P1aP2a = P2a.difference(P1a);
P1nP2n = P2n.difference(P1n);

double r1,r2;

r1 = P1aP2a.x/P1nP2n.x;
r2 = P1aP2a.y/P1nP2n.y;

vl1 = vl2 = Math.max(Math.abs(r1), Math.abs(r2));

//maintenant on construit lambda1 et lambda2 grece aux v. absolues et aux signes

l1 = ( r1 > 0 ? vl1: -vl1);

l2 = ( r2 > 0 ? vl2: -vl2);

this.A = Matrice.creeMatriceDiagonale(l1, l2); // matrice de l'A.L. associee

// Il reste e calculer le terme constant tel que t(C')=C

Vecteur Ca, Cn;
Ca = P1a.somme(P2a).produit(0.5); // Ca est le centre de rect(P1a,P2a)
Cn = P1n.somme(P2n).produit(0.5); // Cn est le centre de rect(P1n,P2n)

Vecteur LCn = this.A.produit(Cn);
this.b = Ca.difference(LCn);
} // ouf! c'est fini



public Vecteur applique(Vecteur u)
{
return A.produit(u).somme(b);
}
public Vecteur [] applique(Vecteur [] u)
{
Vecteur [] r = new Vecteur [u.length];
int i;
for ( i = 0; i < r.length; ++i)
    r[i] = this.applique(u[i]);
return r;
}

public TransformationAffine reciproque()
{
Matrice A_1 = A.inverse();

return new TransformationAffine(A_1,A_1.produit(b).oppose());
}
}
