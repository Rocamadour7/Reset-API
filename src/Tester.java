import java.nio.CharBuffer;

public class Tester {
    public static void main(String[] args) {
        System.out.println(CharBuffer.allocate(5).toString().replace( '\0', '0'));
    }
}
