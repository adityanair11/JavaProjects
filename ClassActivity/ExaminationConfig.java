package ClassActivity;

public final class ExaminationConfig {

    final double examFee;

    public ExaminationConfig(double fee) {
        examFee=fee;
    }

    public final String calculateResult(double marksObtained) {
        if (marksObtained >= 90) {
            return "A";
        } else if (marksObtained >= 80) {
            return "B";
        } else if (marksObtained >= 70) {
            return "C";
        } else if (marksObtained >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        ExaminationConfig obj = new ExaminationConfig(100.0);
        System.out.println("Exam fee is: " + obj.examFee);
        String grade = obj.calculateResult(85.0);
        System.out.println("Grade: " + grade);
    }
}

class Exam
{
    public static void main(String[] args) {
        System.out.println("Exam fee is: ");
    }
}