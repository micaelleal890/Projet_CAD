package reels;

/**
 * 
 * quelques methodes utiles pour les r�els
 * 
 * */
public class Reel
{
/**
 * 
 * renvoie un reel quelconque dans ]-infini,+infini[
 * 
 *
     * @return  */
public static double random()
{
return ( Math.random()- 0.5)/Math.random();
}

}
