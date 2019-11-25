import java.math.BigInteger;

public class Project1 {
	public static void main(String[] args) 
	{
		// Instantiate Primes Class
		Primes p = new Primes();
		p.generatePrimes(BigInteger.valueOf(1),100);
		System.out.println("Print primes");
		p.printPrimes();
		p.generateTwinPrimes();
		p.generateHexPrimes();
		Primes.IterablePrimes iterator=p.iteratePrimes();
		System.out.println("ITERATOR FOR PRIMES");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("Print hexes");
		p.printHexes();
		System.out.println("ITERATOR FOR HEX PRIMES");
		Primes.IterableCrosses crossIterator=p.iterateCrosses();
		while(crossIterator.hasNext()){
			Pair<BigInteger> current=crossIterator.next();
			System.out.println(current.left()+", "+current.right());
		}
		System.out.println(p.sizeofLastPrime());
		//MainWindow mw = new MainWindow(Config.APPLICATIONNAME, p);
	}
}
