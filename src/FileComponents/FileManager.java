package FileComponents;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private Scanner fileScanner;
    private final File file;

    public FileManager(Scanner scanner) {
        this(scanner.nextLine());
    }

    public FileManager (String fileName) {
        this.file = new File(fileName);
        boolean result;
        try {
            result = file.createNewFile();
            fileScanner = new Scanner(file);
            if (result) {
                System.out.println("file  created" + file.getCanonicalPath());
            } else {
                System.out.println("File already exist " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getFileName() {
        return file.toString();
    }

    public String makeAnswerFileName(){
        String fileNameWithExtension = getFileName().substring(getFileName().lastIndexOf("\\") + 1);
        String fileName = fileNameWithExtension.substring(0, fileNameWithExtension.lastIndexOf("."));
        return getFileName().substring(0, getFileName().lastIndexOf("\\") +1) + fileName + "answer.txt";
    }

    public void editFile(String input) {
        try {
            FileOutputStream fos = new FileOutputStream(getFileName(), true);
            byte[]b = (input + "\n").getBytes();
            fos.write(b);
            fos.close();
            System.out.println("file saved");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String fileReader() {
        var questions = new StringBuilder();
        while (fileScanner.hasNextLine()) {
                questions.append(fileScanner.nextLine()).append("\n");
         }
        fileScanner.close();
        return questions.toString();
    }
}
