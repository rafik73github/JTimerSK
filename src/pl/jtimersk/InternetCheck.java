package pl.jtimersk;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class InternetCheck {



    /**
     *
     * @return true if is internet connection
     * @throws IOException throw exception if no internet connection
     */
    public static boolean isReachable() throws IOException
    {
        HttpURLConnection httpUrlConnection = (HttpURLConnection) new URL(
                "https://www.google.pl").openConnection();
        httpUrlConnection.setRequestMethod("HEAD");

        try
        {
            int responseCode = httpUrlConnection.getResponseCode();

            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (UnknownHostException noInternetConnection)
        {
            return false;
        }
    }

    public static boolean checkToken(JSONObject toCheck){
        boolean result = false;
        try {
            JSONObject requestJSON = new JSONObject(new HttpHandler().sendPost(URLS.URL_CHECK, toCheck));
            int request = requestJSON.getInt("request");
            if(request == 1){
                result = true;
            }
            } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

}
