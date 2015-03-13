import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static java.util.Locale.ENGLISH;

/**
 * Created by Андрей on 13.03.2015.
 */
public class NasaParser {
    public static NasaHttp Parse(String str)  {
        NasaHttp nasa = new NasaHttp();
        String pattern = " - - \\[";
        String[] tmp = str.split(pattern);
        str = tmp[1];
        nasa.RequestHost = new Host(tmp[0]);
        tmp = str.split("] \"");
        str = tmp[1];
        SimpleDateFormat isoFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", ENGLISH);
        try {
            nasa.RequestDate = isoFormat.parse(tmp[0]);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        nasa.Request = str.substring(0, str.lastIndexOf('\"'));
        str = str.substring(str.lastIndexOf('"'));
        tmp = str.split(" ");
        nasa.HttpReplyCode = Integer.parseInt(tmp[1]);
        tmp[1] += "\n";
        try {
            nasa.BytesInTheReply = Integer.parseInt(tmp[2]);
        } catch (NumberFormatException e) {
            nasa.BytesInTheReply = 0;
        }
        return nasa;
    }

    public static List<NasaHttp> Parse(List<String> data) {
        List<NasaHttp> list = new ArrayList<NasaHttp>();
        for(String str: data)
        {
            list.add(Parse(str));
        }
        return list;
    }

}
