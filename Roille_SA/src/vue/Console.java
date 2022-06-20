package vue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console 
{
	/* classe Console qui remplace le Scanner avec 5 méthodes 
	 * saisirInt, saisirFloat, saisirDouble, saisirString, saisirChar 
	 */
	
	//instanciation d'un buffer de lecture. 
	private static BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
	
	public static int saisirInt()  //equivalent à nextInt() 
	{
		int nb =0; 
		String chaine ="";
		boolean ok = false; 
		do {
			try {
				chaine = entree.readLine();  //lecture d'une  chaine 
				nb = Integer.parseInt(chaine); //conversion en un entier
				ok = true; 
			}
			catch (IOException exp)
			{
				System.out.println("Erreur de lecture sur le clavier ");
			}
			catch (NumberFormatException exp)
			{
				System.out.println("Erreur de saisie du nombre !");
			}
		}while (ok == false); 
		return nb ; 
	}
	public static float saisirFloat() {
		float nb =0; 
		String chaine ="";
		boolean ok = false; 
		do {
			try {
				chaine = entree.readLine();  //lecture d'une  chaine 
				nb = Float.parseFloat(chaine); //conversion en un entier
				ok = true; 
			}
			catch (IOException exp)
			{
				System.out.println("Erreur de lecture sur le clavier ");
			}
			catch (NumberFormatException exp)
			{
				System.out.println("Erreur de saisie du nombre !");
			}
		}while (ok == false); 
		return nb ; 
	}
	public static double saisirDouble ()
	{
		double nb =0; 
		String chaine ="";
		boolean ok = false; 
		do {
			try {
				chaine = entree.readLine();  //lecture d'une  chaine 
				nb = Double.parseDouble(chaine); //conversion en un entier
				ok = true; 
			}
			catch (IOException exp)
			{
				System.out.println("Erreur de lecture sur le clavier ");
			}
			catch (NumberFormatException exp)
			{
				System.out.println("Erreur de saisie du nombre !");
			}
		}while (ok == false); 
		return nb ; 
	}
	public static String saisirString ()
	{
		String chaine = ""; 
		try {
			chaine = entree.readLine();  //lecture d'une  chaine 
		}
		catch (IOException exp)
		{
			System.out.println("Erreur de lecture sur le clavier ");
		}
		return chaine ; 
	}
	public static char saisirChar ()
	{
		String chaine = ""; 
		try {
			chaine = entree.readLine();  //lecture d'une  chaine 
		}
		catch (IOException exp)
		{
			System.out.println("Erreur de lecture sur le clavier ");
		}
		return chaine.charAt(0) ; 
	}
}

