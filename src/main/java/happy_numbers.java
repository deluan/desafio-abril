import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * http://en.wikipedia.org/wiki/Happy_number
 *
 * @author deluan
 */
public class happy_numbers {

    int nextNumber(int number) {
        int digit;
        int result = 0;
        do {
            digit = number % 10;
            result += digit * digit;
            number /= 10;
        } while (number > 0);
        return result;
    }

    Boolean isHappyNumber(Integer seed) {
        Set<Integer> history = new HashSet<Integer>();
        Integer number = seed;

        while (!history.contains(number) && number != 1) {
            history.add(number);
            number = nextNumber(number);
        }

        return (number == 1);
    }

    public static void main(String args[]) {

        happy_numbers instance = new happy_numbers();

        try {
            FileInputStream fstream = new FileInputStream(args[0]);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                Integer number = Integer.parseInt(strLine);
                System.out.println(instance.isHappyNumber(number) ? "1" : "0");
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
