import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker checker = new HttpStatusChecker();

    public void downloadStatusImage(int code) {
        try {
            String imageUrl = checker.getStatusImage(code);
            try (BufferedInputStream in = new BufferedInputStream(new URL(imageUrl).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(code + ".jpg")) {
                byte[] dataBuffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
                System.out.println("Image downloaded: " + code + ".jpg");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
