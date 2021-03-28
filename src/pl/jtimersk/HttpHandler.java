package pl.jtimersk;

import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class HttpHandler {

    /**
     *
     * @param r_url API server URL
     * @param postDataParams data to post, JSON Object
     * @return return response string
     * @throws Exception exceptions for connection
     */
    public String sendPost(String r_url , JSONObject postDataParams) throws Exception {
        URL url = new URL(r_url);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(20000);
        conn.setConnectTimeout(20000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(os, StandardCharsets.UTF_8));
        writer.write(encodeParams(postDataParams));
        writer.flush();
        writer.close();
        os.close();

        int responseCode=conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {

            InputStream in = new BufferedInputStream(conn.getInputStream());
            return convertStreamToString(in);
        }
        return null;
    }

    /**
     *
     * @param is InputStream from POST request
     * @return return data request in string format
     */
    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     *
     * @param params JSON Object to be encoded to POST string
     * @return string send to server value_name1=value1&value_name2=value2...
     */
    private String encodeParams(JSONObject params) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        Iterator<String> itr = params.keys();
        while(itr.hasNext()){
            String key= itr.next();
            Object value = params.get(key);
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), StandardCharsets.UTF_8));
        }
        return result.toString();
    }

}
