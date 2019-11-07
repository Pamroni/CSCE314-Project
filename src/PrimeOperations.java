import java.util.ArrayList; 
import java.math.BigInteger;
import java.util.List;

/*
 *  Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class PrimeOperations {
	private List<BigInteger> primes;

	PrimeOperations(){
		//Initialize our arraylist of primes
		primes=new ArrayList<>();
	}

	// Pair class implementation
	private class Pair<T> {
	}
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	
	// Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
	public void addPrime(BigInteger x)
	{
	}
	
	// Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
	public void printPrimes()
	{
		for(BigInteger prime: primes){
			System.out.println(prime);
		}
		System.out.println("Total Primes: "+primes.size());
	}
		
	// Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
	public void printTwins()
	{
	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
	}
	public boolean isPrime(BigInteger value){
		if(value.compareTo(BigInteger.valueOf(2))<0){ //If it's less than 2,
			//Both 0 and 1 are not primes
			return false;
		}
		//For loop with bigintegers
		//goes from i: 2->value
		//Then we check if the value mod i is == 0
		//If so, return false since we found a non-prime
		//If we never find this, then it's prime and we return true
		for(BigInteger i=new BigInteger("2"); i.compareTo(value)<0; i=i.add(BigInteger.valueOf(1))){
			if(value.mod(i).compareTo(BigInteger.ZERO)==0){
				return false;
			}
		}
		return true;
	}
	// Generate and store a list of primes.
	public void generatePrimes(int count)
	{
		BigInteger primeIteration=BigInteger.ZERO;
		while(primes.size()!=count){
			if(isPrime(primeIteration)){
				primes.add(primeIteration);
			}
			primeIteration=primeIteration.add(BigInteger.ONE);
		}
	}
	
	// Generate and store a list of twin primes.
	public void generateTwinPrimes()
	{
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
	}
}
