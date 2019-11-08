/*
 * 	Alex Ramponi
 * 	Commented over the methods that I implemented
 * 	Lupoli CSCE-314-502, Fall 2019
 */
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

public class PrimeOperations {
    //List of big ints
    private List<BigInteger> primes;

    //List of pairs
    private List<Pair<BigInteger>> twinPrimes;

    //List of pairs of pairs
    private List<Pair<Pair<BigInteger>>> hexaPrimes;

    PrimeOperations() {
        //Initialize our arraylist of primes
        primes = new ArrayList<>();
        twinPrimes = new ArrayList<>();
        hexaPrimes = new ArrayList<>();
    }

    // Pair class implementation
    private class Pair<T> {
        private T first;
        private T second;

        Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public T getSecond() {
            return second;
        }

        public void setSecond(T second) {
            this.second = second;
        }

        public String toString() {
            return first + ", " + second;
        }
    }

    // Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.

    // Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
    public void addPrime(BigInteger x) {
        if (!primes.contains(x)) {
            primes.add(x);
        }
    }

    // Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
    public void printPrimes() {
        for (BigInteger prime : primes) {
            System.out.println(prime);
        }
        System.out.println("Total Primes: " + primes.size());
    }

    // Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
    public void printTwins() {
        //Just uses the toString value
        for (Pair<BigInteger> pair : twinPrimes) {
            System.out.println(pair);
        }
        System.out.println("Total Twins: " + twinPrimes.size());
    }

    // Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
    public void printHexes() {
        //Foreach loop through the hexaPrimes pairs to iterate and display
        for (Pair<Pair<BigInteger>> pairOfPair : hexaPrimes) {
            //Left side of the hexagon pair aka the smaller one
            Pair<BigInteger> left = pairOfPair.getFirst();
            //Right side of the hexagon pair aka the larger one
            Pair<BigInteger> right = pairOfPair.getSecond();
            BigInteger smallerMiddle = left.getSecond().subtract(BigInteger.ONE);
            BigInteger doubleMiddle = right.getSecond().subtract(BigInteger.ONE);
            System.out.println("Prime Pairs: " + left + " and " + right + " separated by " + smallerMiddle + ", " + doubleMiddle);
        }
        System.out.println("Total Hexes: " + hexaPrimes.size());
    }

    public boolean isPrime(BigInteger value) {
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

    // Generate and store a list of primes.
    public void generatePrimes(int count) {
        //Start with 0 and just go until we have count number of primes
        BigInteger primeIteration = BigInteger.ZERO;
        while (primes.size() != count) {
            if (isPrime(primeIteration)) {
                primes.add(primeIteration);
            }
            primeIteration = primeIteration.add(BigInteger.ONE);
        }
    }

    // Generate and store a list of twin primes.
    public void generateTwinPrimes() {
        //Basically we're just going to track the previous value (-1 never prime so a good starter) as well as the current
        BigInteger previous = BigInteger.valueOf(-1);
        for (int i = 0; i < primes.size(); i++) {
            BigInteger current = primes.get(i);
            BigInteger diff = current.subtract(previous);
            //If the two back to back primes have a difference of two, then this is a pair and we store it
            if (diff.equals(BigInteger.valueOf(2))) {
                Pair<BigInteger> foundPair = new Pair<>(previous, current);
                twinPrimes.add(foundPair);
            }
            //Increment our previous
            previous = current;
        }
    }

    // Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
    public void generateHexPrimes() {
        //Use this hashmap to find the number that is double
        //Hashmap will most likely make this way quicker
        HashMap<BigInteger, Pair<BigInteger>> hexaLookup = new HashMap<>();
        for (Pair<BigInteger> pair : twinPrimes) {

            //Get the middle number that we will divide by 2. We're going to look at this from the right side left
            BigInteger middle = pair.getSecond().subtract(BigInteger.ONE);
            //Get out key by doing middle/2
            BigInteger key = middle.divide(BigInteger.valueOf(2));

            //Now we just check if we already got the half/key value. If we did, add both pairs to the list of pairs of pairs
            if (hexaLookup.containsKey(key)) {
                Pair<BigInteger> smaller = hexaLookup.get(key);
                Pair<Pair<BigInteger>> pairOfPair = new Pair<>(smaller, pair);
                hexaPrimes.add(pairOfPair);
            } else {
                hexaLookup.put(middle, pair);
            }
        }
    }
}
