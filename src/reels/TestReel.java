package reels;

public class TestReel
{

/**
 * @param args
 */
public static void main(String[] args)
{
int i, n;

double x;

for ( n = 100, i = 0; i < n; ++i)
    {
    x = Reel.random();
    System.out.println(i+"eme reel genere aleatoirement : "+x);
    
    }

} //main

}
