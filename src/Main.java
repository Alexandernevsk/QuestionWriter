import FileComponents.FileManager;

import java.util.Arrays;
import java.util.Scanner;

//C:\Users\Alexa\Desktop\test.txt

public class Main {
    public static void main(String[] args) {
       FileManager file = new FileManager(new Scanner(System.in));
       QuestionFile.createQuestionFile(file);
        System.out.println(file.getFileName());
        System.out.println(file.makeAnswerFileName());

    }
}

