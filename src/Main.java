/**
 * Created by Андрей on 13.03.2015.
 */
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            String fileInName = args[0];
            int startIndex = Integer.parseInt(args[1]);
            int num = Integer.parseInt(args[2]);
            String fileOutName = args[3];
            NasaWriter.Writer(fileOutName, NasaParser.Parse(NasaReader.Read(fileInName, startIndex, num)));
        }
        catch (FileNotFoundException e) {
            System.out.println("File " + e.getMessage() + " not found\n");
        }
        catch (Exception e) {
            System.out.println("Error:\n"
                    + e.getMessage());
        }
    }
}

