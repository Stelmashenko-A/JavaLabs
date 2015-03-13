import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Андрей on 13.03.2015.
 */
public class NasaWriter {
    public static void Writer(String fileName, List<NasaHttp> nasa) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false) );
        for(NasaHttp item: nasa) {
            out.write(item.toString());
        }
        out.close();
    }
}
