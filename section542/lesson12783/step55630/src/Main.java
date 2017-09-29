import java.io.IOException;
import java.io.InputStream;

class Main {
    //Stepik code: start
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        // your implementation here
        int checkSum = 0;
        int nextByte;
        while ((nextByte = inputStream.read()) != -1) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ nextByte;
        }
        return 0;
    }
//Stepik code: end
}
