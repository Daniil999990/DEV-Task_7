import java.util.Scanner;

public class HttpImageStatusCli {
    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter HTTP status code: ");

        try {
            int code = Integer.parseInt(scanner.nextLine());

            HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
            downloader.downloadStatusImage(code);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
