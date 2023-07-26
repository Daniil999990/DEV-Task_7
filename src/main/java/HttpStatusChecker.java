import java.io.IOException;

public class HttpStatusChecker {
    private HttpClient httpClient;

    public HttpStatusChecker() {
        this.httpClient = new HttpClient();
    }

    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";
        String response = httpClient.get(url);

        if (response.contains("404 Not Found")) {
            throw new Exception("Image not found for HTTP status " + code);
        }

        return url;
    }
}
