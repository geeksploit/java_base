import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class Main {
    //Stepik code: start
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // your implementation here
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        StringBuilder stringBuilder = new StringBuilder();
        int nextChar;
        return "";
    }
//Stepik code: end
}
