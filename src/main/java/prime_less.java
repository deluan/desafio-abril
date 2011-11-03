import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * http://en.wikipedia.org/wiki/Prime-counting_function
 *
 * @author deluan
 */
public class prime_less {
    TreeSet<Integer> primes = new TreeSet<Integer>();
    Integer biggest = 0;

    public Set<Integer> findAllPrimesUntil(Integer number) {
        if (number > biggest) {
            for (int n = biggest + 1; n <= number; n++) {
                if (isPrime(n)) {
                    primes.add(n);
                }
            }
            biggest = number;
        }

        return primes.headSet(number);
    }

    public boolean isPrime(long n) {
        if (n % 2 == 0 && n != 2) {
            return false;
        }
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        return ((prime && n > 2) || n == 2);
    }

    public static void main(String args[]) {

        prime_less instance = new prime_less();

        try {
            FileInputStream fstream = new FileInputStream(args[0]);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                Integer number = Integer.parseInt(strLine);
                Set<Integer> result = instance.findAllPrimesUntil(number);
                Iterator<Integer> iterator = result.iterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next());
                    if (iterator.hasNext()) {
                        System.out.print(',');
                    }
                }
                System.out.println();
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

}
