import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * <b>Double Squares</b>
 * <p/>
 * A double-square number is an integer X which can be expressed as the sum of two perfect squares.
 * For example, 10 is a double-square because 10 = 32 + 12. Your task in this problem is, given X,
 * determine the number of ways in which it can be written as the sum of two squares.
 * For example, 10 can only be written as 32 + 12 (we don’t count 12 + 32 as being different).
 * On the other hand, 25 can be written as 52 + 02 or as 42 + 32.
 * <p/>
 * <em>Input</em><br/>
 * You should first read an integer N, the number of test cases. The next N lines will contain N values of X.
 * <p/>
 * </em>Constraints</em><br/>
 * 0  <  X  <  2147483647<br/>
 * 1  < N  < 100<br/>
 * <p/>
 * </em>Output</em><br/>
 * For each value of X, you should output the number of ways to write X as the sum of two squares.
 *
 * @author deluan
 */
public class double_squares {

    boolean isInt(Double num) {
        return num == Math.round(num);
    }

    int dp(int number) {
        if (number <= 1) {
            return 1;
        }

        Integer result = 0;
        Integer half = (int) Math.ceil(Math.sqrt(number / 2));

        for (int i = 0; i < half; i++) {
            Double diff = Math.sqrt(number - (i * i));

            if (isInt(diff)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        double_squares instance = new double_squares();

        try {
            FileInputStream fstream = new FileInputStream(args[0]);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();
            Integer n = Integer.parseInt(strLine);

            while (n-- > 0) {
                strLine = br.readLine();
                Integer number = Integer.parseInt(strLine);
                System.out.println(instance.dp(number));
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
