import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileManager {

    // public String readFile(String filePath) throws Exception {
    // try {
    // return new String(Files.readAllBytes(Paths.get(filePath)));
    // } catch (Exception e) {
    // throw new IOException("File not found");
    // }

    // }

    public String readFileBuffered(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
    }


    public void writeToFile(String text, String encryptOrDecrypt) throws IOException {

    

        String outputDirectory = "output_files";

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        String fileName = "";

        if (encryptOrDecrypt.equals("encrypt")) {
            fileName = "encrypted" + timeStamp + ".txt";
        } else if (encryptOrDecrypt.equals("decrypt")) {
            fileName = "decrypted" + timeStamp + ".txt";
        }


        File directory = new File(outputDirectory);

        if (!directory.exists()) {
            throw new IOException("Directory does not exist");
        }

        String filePath = outputDirectory + File.separator + fileName;
        try {
            Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            throw new IOException("Failed to write to file: " + filePath, e);
        }
    }

}
