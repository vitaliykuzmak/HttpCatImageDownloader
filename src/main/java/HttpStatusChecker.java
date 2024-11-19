import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new Exception("No image found for HTTP status code: " + code);
        }
        return url;
    }
}
