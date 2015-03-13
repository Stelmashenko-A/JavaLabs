/**
 * Created by Андрей on 13.03.2015.
 */
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static java.util.Locale.ENGLISH;

public class NasaHttp {
    public Host RequestHost;
    public Date RequestDate;
    public String Request;
    public int HttpReplyCode;
    public int BytesInTheReply;

    @Override
    public String toString()
    {
        SimpleDateFormat isoFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", ENGLISH);
        return RequestHost.toString() + " - - ["
                + isoFormat.format(RequestDate) + "] \""
                + Request + "\" "
                + HttpReplyCode+" "
                + BytesInTheReply + "\n";
    }
}

