import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException{
        int prev = System.in.read();
        while (prev != -1) {
            int next = System.in.read();
            if (prev != 13 || next != 10) {
                System.out.write(prev);
            }
            prev = next;
        }
    }
}
