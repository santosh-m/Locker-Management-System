import java.io.*;
import java.nio.charset.StandardCharsets;

public class Driver {

    //E2E placeholders
    //Context !

    public static void main(String[] args) {
        Driver obj = new Driver();
        BufferedReader bufferReader = null;
        String input = null;
        try {

            //Read from input stream
            while (true) {
                bufferReader = new BufferedReader(new InputStreamReader(System.in));
                input = bufferReader.readLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.out.println("Input is : " + input);
                }
            }

            //Read from file
            //obj.readFile();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferReader != null) {
                    bufferReader.close();
                }
            } catch (IOException e1) {
            }
        }
    }

}
