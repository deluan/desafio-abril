import java.nio.ByteOrder;

/**
 * @author deluan
 */
public class endian {

    static public void main(String args[]) {
        ByteOrder b = ByteOrder.nativeOrder();
        if (b.equals(ByteOrder.BIG_ENDIAN)) {
            System.out.println("BigEndian");
        } else {
            System.out.println("LittleEndian");
        }
    }

}
