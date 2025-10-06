package Class;

import java.io.*;

public class FileWordLineCounter {
    public static void main(String[] args) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        // Load file from resources folder
        try (InputStream is = FileWordLineCounter.class.getResourceAsStream("/Sessional3/sample.txt")) {
            if (is == null) {
                System.out.println("File not found in resources folder!");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;

                // Count words
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }

                // Count characters (excluding spaces)
                charCount += line.replaceAll("\\s+", "").length();
            }

            br.close();

            System.out.println("Total Lines: " + lineCount);
            System.out.println("Total Words: " + wordCount);
            System.out.println("Total Characters (excluding spaces): " + charCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
