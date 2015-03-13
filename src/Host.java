/**
 * Created by Андрей on 13.03.2015.
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Host {
    public boolean isIp;
    InetAddress ipAddress;
    private String stringAddress;
    public Host(String str) {
        stringAddress = str;
        isIp = validate(str);
        if(isIp)
        {
            try {
                ipAddress = InetAddress.getByName(str);
            }
            catch (UnknownHostException e)
            {
                //ignore
            }
        }
    }
    private static final String PATTERN =
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public static boolean validate(final String ip){
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    @Override
    public String toString()
    {
        if(isIp)
            return ipAddress.toString();
        return stringAddress;
    }
}
