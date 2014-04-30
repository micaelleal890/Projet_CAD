package exodecorateur_angryballs.maladroit.vues.versioncorrect;

import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.versioncorrect.Bille;


public class TestCadreAngryBallsSeul
{

/**
 * @param args
 */
public static void main(String[] args)
{
Vector<Bille> billes = new Vector<Bille>();
CadreAngryBalls cadre =new CadreAngryBalls("angry balls", "animation de billes marrantes", billes);
cadre.montrer();
}

}
