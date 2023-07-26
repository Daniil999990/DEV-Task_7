import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        try (InputStream in = new java.net.URL(imageUrl).openStream()) {
            Path resourcesPath = Paths.get("src/main/resources");
            if (!Files.exists(resourcesPath)) {
                Files.createDirectories(resourcesPath);
            }

            String fileName = resourcesPath.resolve(code + ".jpg").toString();
            try (OutputStream out = new FileOutputStream(fileName)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                System.out.println("Uploaded to src/main/resources");
            }
        } catch (IOException e) {
            throw new Exception("The image could not be loaded: " + e.getMessage());
        }
    }
}
