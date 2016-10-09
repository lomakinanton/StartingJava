
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SimpleInternetConnection {

    public String getPage(String pageUrl) throws MalformedURLException, IOException {
        URL url = new URL(pageUrl);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        int responseCode = httpConnection.getResponseCode();
        switch (responseCode) {
            case HttpURLConnection.HTTP_OK:
                httpConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close();
                

               return builder.toString();
            default:
                return String.format("error=%s", responseCode);
        }

       
    }
}
