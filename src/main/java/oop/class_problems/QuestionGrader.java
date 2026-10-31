import java.util.Scanner;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();

    abstract String getType();
}

class MCQQuestion extends Question {
    MCQQuestion(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {
    TFQuestion(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double grade() {
        String[] keywords = correctAnswer.split(",");
        int matched = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase()
                    .contains(keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class QuestionGrader {
    static String[] parseQuotedFields(String line) {
        java.util.ArrayList<String> fields = new java.util.ArrayList<>();
        java.util.regex.Matcher matcher =
                java.util.regex.Pattern.compile("\"([^\"]*)\"|(\\S+)")
                        .matcher(line);

        while (matcher.find()) {
            fields.add(matcher.group(1) != null
                    ? matcher.group(1) : matcher.group(2));
        }

        return fields.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {
            String[] data = parseQuotedFields(sc.nextLine());

            String type = data[0].toUpperCase();
            String q = data[1];
            String correct = data[2];
            String student = data[3];
            double points = Double.parseDouble(data[4]);

            switch (type) {
                case "MCQ":
                    questions[i] = new MCQQuestion(q, correct, student, points);
                    break;
                case "TF":
                    questions[i] = new TFQuestion(q, correct, student, points);
                    break;
                case "ESSAY":
                    questions[i] = new EssayQuestion(q, correct, student, points);
                    break;
                default:
                    System.out.println("Invalid question type");
                    return;
            }
        }

        double total = 0;

        for (Question question : questions) {
            double score = question.grade();
            System.out.printf("%s: %.2f%n", question.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
