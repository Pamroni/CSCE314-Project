import java.math.BigInteger;

public class Project1 {
	public static void main(String[] args) 
	{
		//Instantiate Primes Class
		Primes p = new Primes();

		//Create the main window
		MainWindow mw = new MainWindow(Config.APPLICATIONNAME, p);
	}
}
