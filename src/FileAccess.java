// This file gives access to the underlying datafile and stores the data in the Workout class.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Scanner;

public class FileAccess {
  
  public static boolean loadPrimes(Primes primes, String filename) {
      try{
          File readFile=new File(Config.DATAPATH+filename);
          Scanner reader = new Scanner(readFile);
          while(reader.hasNextLine()){
              String currentPrime = reader.nextLine();
              BigInteger prime = new BigInteger(currentPrime);
              primes.addPrime(prime);
          }
      }
      catch(Exception e){
          e.printStackTrace();
          return false;
      }
      return true;
  }
  
  public static boolean loadCrosses(Primes primes, String filename) {
      try{
          File readFile=new File(Config.DATAPATH+filename);
          Scanner reader = new Scanner(readFile);
          while(reader.hasNextLine()){
              String crossRow = reader.nextLine();
              String[] hexes = crossRow.split(", ");
              BigInteger left = new BigInteger(hexes[0]);
              BigInteger right = new BigInteger(hexes[1]);

              Pair<BigInteger> crossPair = new Pair<>(left,right);
              primes.addCross(crossPair);
          }
      }
      catch(Exception e){
          e.printStackTrace();
          return false;
      }
      return true;
	}
  
  public static boolean savePrimes(Primes primes, String filename)
  {
      try{
          File file = new File(Config.DATAPATH+filename);
          file.createNewFile();

          FileWriter writer = new FileWriter(file);
          Primes.IterablePrimes itr = primes.iteratePrimes();
          while(itr.hasNext()){
              BigInteger prime = itr.next();
              System.out.println(prime.toString());
              writer.write(prime.toString()+"\n");
              writer.flush();
          }
          writer.close();
      }
      catch(Exception e){
          e.printStackTrace();
          return false;
      }
      return true;
  }
  
  public static boolean saveCrosses(Primes primes, String filename)
  {
      try{
          File file = new File(Config.DATAPATH+filename);
          file.createNewFile();

          FileWriter writer = new FileWriter(file);
          Primes.IterableCrosses itr = primes.iterateCrosses();
          while(itr.hasNext()){
              Pair<BigInteger> prime = itr.next();
              BigInteger left = prime.left();
              BigInteger right = prime.right();
              writer.write(left+", "+right+"\n");
              writer.flush();
          }
          writer.close();
      }
      catch(Exception e){
          e.printStackTrace();
          return false;
      }
      return true;
  }
}