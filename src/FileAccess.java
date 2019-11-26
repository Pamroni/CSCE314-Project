// This file gives access to the underlying datafile and stores the data in the Workout class.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Scanner;

public class FileAccess {

  //Load the filename into the primes in memory
  public static boolean loadPrimes(Primes primes, String filename) {
    try {
      File readFile = new File(Config.DATAPATH + filename);
      Scanner reader = new Scanner(readFile);
      //Process through the file and save each biginteger to the primes passed
      while (reader.hasNextLine()) {
        String currentPrime = reader.nextLine();
        BigInteger prime = new BigInteger(currentPrime);
        primes.addPrime(prime);
      }
    } catch (Exception e) {
      //Any exception just return false
      e.printStackTrace();
      return false;
    }
    return true;
  }
  //Load the filename into the crosses in memory
  public static boolean loadCrosses(Primes primes, String filename) {
    try {
      File readFile = new File(Config.DATAPATH + filename);
      Scanner reader = new Scanner(readFile);
      //Process through the file and save each pair to the crosses passed
      while (reader.hasNextLine()) {
        String crossRow = reader.nextLine();
        //The crosses are stored as #, # with a , and a space seperating both numbers
        String[] hexes = crossRow.split(", ");

        //Convert both strings to bigintegers and save the pair
        BigInteger left = new BigInteger(hexes[0]);
        BigInteger right = new BigInteger(hexes[1]);

        Pair<BigInteger> crossPair = new Pair<>(left, right);
        primes.addCross(crossPair);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  //Save whatever primes are in primes to the file
  public static boolean savePrimes(Primes primes, String filename) {
    try {
      //We need to make sure the data directory is there or else we get an exception
      new File(Config.DATAPATH).mkdir();

      //Once we get the directory we can create the file there
      File file = new File(Config.DATAPATH + filename);
      file.createNewFile();

      FileWriter writer = new FileWriter(file);
      //Use the IterablePrimes iterator and process through everything with a foreach loop
      Primes.IterablePrimes iterablePrimes = primes.iteratePrimes();
      for(BigInteger prime: iterablePrimes){
        System.out.println(prime.toString());
        writer.write(prime.toString() + "\n");
        writer.flush();
      }
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  //Save whatever crosses are in memory to the given file name
  public static boolean saveCrosses(Primes primes, String filename) {
    try {
      //We need to make sure the data directory is there or else we get an exception
      new File(Config.DATAPATH).mkdir();

      //Once the directory is set we can save the file there
      File file = new File(Config.DATAPATH + filename);
      file.createNewFile();

      FileWriter writer = new FileWriter(file);
      //Use the inner iterablecrosses object to iterate through the crosses
      Primes.IterableCrosses iterableCrosses = primes.iterateCrosses();
      for(Pair<BigInteger> pair: iterableCrosses){
        BigInteger left = pair.left();
        BigInteger right = pair.right();
        //Save the pair as #, # so the load can process it correctly
        writer.write(left + ", " + right + "\n");
        writer.flush();
      }
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
