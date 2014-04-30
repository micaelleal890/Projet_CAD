package mesmaths;

import complexes.Complexe;

/**
 * Quelques operations mathematiques generales utiles
 * 
 * */
public class MesMaths
{

/**
 * 
 * @return une valeur aleatoire dans l'intervalle [xMin, xMax]
 * */
public static double creationAleatoire(double xMin, double xMax)
{
double dX = xMax - xMin;

return xMin + dX*Math.random();
}
/**
 * @param a : borne inferieure de l'intervalle [a,b]
 * @param b : borne superieure de l'intervalle [a,b]
 * @return  la valeur de l'expression: x est dans [a,b]
 * 
 * */
public static boolean appartient(double x, double a, double b)
{
return (a <= x) && (x <= b);
}

/**
 * @param a : le coefficient de x^2
 * @param b : le coefficient de x
 * @param c : le coefficient du terme constant de l'equation
 * resout a * x^2 + b * x + c = 0 dans R
 * 
 * suppose a non nul
 * 
 * @return un tableau t contenant  soit 2 solutions reelles soit 0 solution
 * 
 * le tableau t renvoye contient donc soit 2 double soit 0 element
 * 
 * Les solutions sont  classees par ordre croissant telles que t[0] < = t[1]
 * 
 * */
public static double[] resoudre( double a, double b, double c)  // resout ax^2+bx+c=0. en sortie t[0] <= t[1]
{
double []t;
double delta;

delta = b*b-4*a*c;

if (delta >=0)
    {
    double racine, denom;
    racine = Math.sqrt(delta);
    denom = 2*a;
    t = new double[2];
    t[0] = (-b-racine)/denom;
    t[1] = (-b+racine)/denom;
    }
else
    t = new double[0];

return t;
}

/**
 * resout a * x^2 + b * x + c = 0 dans C
 * 
 * @param a : le coefficient de x^2
 * @param b : le coefficient de x
 * @param c : le coefficient du terme constant de l'equation
 * 
 * suppose a non nul
 * 
 * @return un tableau t contenant soit 2 solutions reelles soit 2 solutions complexes conjuguees
 * 
 * le tableau t renvoye contient donc soit 2 Double soit 2 Complexe placees dans t[0] et t[1]
 * 
 * si les solutions sont reelles, elles sont classees par ordre croissant telles que t[0] < = t[1]
 * 
 * */
public static Object [] resoutEquationDegre2(double a, double b, double c)
{
if (a == 0) throw new ArithmeticException("l'equation e resoudre n'est pas du 2eme degre");

Object [] t = new Object[2];

double delta, a2;


delta = b*b - 4*a*c;
a2 = 2*a; 

if (delta > 0) /* les solutions sont reelles */
    {
    double racineDelta = Math.sqrt(delta);
    double x1, x2;
    
    x1 = (-b - racineDelta)/a2;
    x2 = (-b + racineDelta)/a2;
    t[0] = new Double(x1);
    t[1] = new Double(x2);
    }
else
    {
    double racineDelta1 = Math.sqrt(-delta);
    t[0] = new Complexe(-b/a2,-racineDelta1/a2);
    t[1] = new Complexe(-b/a2, racineDelta1/a2);
    }
return t;
}


/**
 * 
 * resout dans R, par la methode de Cardan, l'equation de degre 3 reduite : x^3 + p * x + q = 0
 * 
 * @param p : le coefficient de x
 * @param q : le coefficient du terme constant
 *
 *  @return un tableau t contenant 1 ou 3 solutions 
 * */
public static double[] resoutEquationDegre3Reduite(double p, double q)
{
double [] t;

Object [] XY = MesMaths.resoutEquationDegre2(1, q, -p*p*p/27);

if (XY[0] instanceof Double) /* les solutions sont reelles : il y a donc une solution e l'equation */
    {
    t = new double[1];
    
    double X,Y, a, b;
    
    X = ((Double)(XY[0])).doubleValue();
    Y = ((Double)(XY[1])).doubleValue();
    
    a = Math.pow(X, 1./3);
    b = Math.pow(Y, 1./3);
    
    t[0] = a+b; // l'unique solution de l'equation
    }
else // les solutions sont complexes conjuguees
    {
    t = new double[3];
    
    Complexe [] racinesCubiquesX;
    Complexe [] racinesCubiquesY;
    
    racinesCubiquesX = ((Complexe)(XY[0])).racines(3);
    racinesCubiquesY = ((Complexe)(XY[1])).racines(3);
    
    Complexe x0,x1, x2;
    
    x0 = racinesCubiquesX[0].somme(racinesCubiquesY[0]);    // on sait que x0 est reel
    
    x1 = racinesCubiquesX[1].somme(racinesCubiquesY[2]);    // on sait que x1 est reel
    
    x2 = racinesCubiquesX[2].somme(racinesCubiquesY[1]);    // on sait que x2 est reel
    
    t[0] = x0.getX();
    t[1] = x1.getX();
    t[2] = x2.getX();
    
    }

return t;
}

/**
 * resout dans R, par la methode de Cardan, l'equation a3*t^3 + a2*t^2 + a1*t + a0 = 0
 * 
 * @param a0 : coefficient du terme constant
 * @param a1 : coefficient de x
 * @param a2 : coefficient de x^2
 * @param a3 : coefficient de x^3
 * 
 * on suppose a3 non nul
 * 
 * @return un tableau t contenant 1 ou 3 solutions
 * 
 * */
public static double [] resoutEquationDegre3(double a0, double a1, double a2, double a3)
{
if (a3 == 0) throw new ArithmeticException("l'equation e resoudre n'est pas du 3eme degre");

double A, B, C;

A = a2/a3; B = a1/a3; C = a0/a3;

// on a reduit l'equation e : t^3 + A * t^2 + B * t + C = 0

double alfa = -A/3;  // changnement de variable : t = x + alfa

double u, p, q;

u = A*A/3; // u = A^2/3 
p = B-u;
q = 2*A*u/9 - A*B/3 + C;

// x est solution de x^3+ p * x + q = 0

double [] x = MesMaths.resoutEquationDegre3Reduite(p, q);

double [] t = new double[x.length];

int i;
for ( i = 0;  i < t.length; ++i)
    t[i] = x[i] + alfa;

return t;
}

/**
 * 
 * Resout dans R, l'equation a*x + b == 0
 * 
 * */
public static double resoutEquationDegre1(double a, double b)
{
if (a == 0) throw new ArithmeticException("l'equation e resoudre n'est pas du 1er degre");

return -b/a;

}
}
