import java.math.BigInteger;

public class NaiveTest
{
	public static boolean oldIsPrime(BigInteger candidate)
	{
		if (!candidate.isProbablePrime((100))) return false; // Weed out the likely not primes.
		
		BigInteger loopStop = candidate.sqrt().add(BigInteger.ONE);
		for (BigInteger outerIndex = BigInteger.TWO; !outerIndex.equals(loopStop); outerIndex = outerIndex.add(BigInteger.ONE))
		{
			for (BigInteger innerIndex = outerIndex; !innerIndex.equals(loopStop); innerIndex = innerIndex.add(BigInteger.ONE))
			{
				if (candidate.equals(innerIndex.multiply(outerIndex))) return false;
			}
		}
		return true;
	}

	//My isPrime method from the first assignment
	public static boolean isPrime(BigInteger value){
		if (value.compareTo(BigInteger.valueOf(2)) < 0) { //If it's less than 2,
			//Both 0 and 1 are not primes
			return false;
		}
		//For loop with bigintegers
		//goes from i: 2->value
		//Then we check if the value mod i is == 0
		//If so, return false since we found a non-prime
		//If we never find this, then it's prime and we return true
		for (BigInteger i = new BigInteger("2"); i.compareTo(value) < 0; i = i.add(BigInteger.valueOf(1))) {
			if (value.mod(i).compareTo(BigInteger.ZERO) == 0) {
				return false;
			}
		}
		return true;
	}
}
