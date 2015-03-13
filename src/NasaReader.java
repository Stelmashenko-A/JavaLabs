import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 13.03.2015.
 */
public class NasaReader {
    public static List<String> Read(String from, int startIndex, int number) throws IOException {
        FileReader fr = new FileReader(from);
        BufferedReader in = new BufferedReader(fr);
        if (startIndex >= 0 && startIndex < number && number > 0) {
            List<String> str = new ArrayList<String>();
            for (int i = 0; i < startIndex; i++) {
                if(in.readLine() == null) {
                    return null;
                }
            }
            String tmp;
            for (int i = 0; i < number; i++) {
                tmp = in.readLine();
                if (tmp == null) {
                    return str;
                }
                str.add(in.readLine());
            }
            return str;
        }

        in.close();

        return null;
    }

}
