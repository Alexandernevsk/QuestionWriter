import java.util.Scanner;

public abstract class Question {
    Scanner scanner = new Scanner(System.in);
    private final String questionName;
    private final String text;
    private final String answer;

    private String question;


    public Question() {
        System.out.println("What is the name of the question?");
        this.questionName = scanner.nextLine();
        System.out.println("Give the question text");
        this.text = scanner.nextLine();
        System.out.println("What is the answer to the question?");
        this.answer = scanner.nextLine();
    }

    public Question(String question){
        this();
        this.question = question;
    }

    public String getQuestionName() {
        return questionName;
    }

    public String getText() {
        return text;
    }

    public String getAnswer() {
        return answer;
    }
}

class MultipleChoice extends Question {
    private final char[] choices;
    private final String[] questions;

    public MultipleChoice() {
        super();
        System.out.println("How many multiple choice do you want to have?");
        int numbOfOptions = scanner.nextInt();
        scanner.nextLine();
        this.choices = new char[numbOfOptions];
        this.questions = new String[numbOfOptions];
        char firstOption = 'a';
        for(int i = 0; i < this.choices.length; i++){
            System.out.printf(("Give the option for: %c the multiple choice%n"), firstOption);
            String question = scanner.nextLine();
            questions[i] = question;
            choices[i] = firstOption;
            firstOption += 1;
        }
    }


    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append(("%s\n\t%s\n\n").formatted(getQuestionName(), getText()));
        for(int i = 0; i < choices.length; i++){
            stringBuilder.append(("%s:\t%s\n").formatted(choices[i], questions[i]));
        }
        return stringBuilder.toString();
    }
}

class openQuestion extends Question {

    public openQuestion(String question) {
        super(question);
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append(("%s\n\t%s\n\n").formatted(getQuestionName(), getText()));
        return stringBuilder.toString();
    }
}

class yesOrNOQuestion extends Question {
    public yesOrNOQuestion(String question){
        super(question);
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append(("%s\n\t%s\n\n").formatted(getQuestionName(), getText()));
        return stringBuilder.toString();
    }
}