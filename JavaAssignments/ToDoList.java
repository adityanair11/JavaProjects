import java.util.ArrayList;
public class ToDoList {

    // Exercise 1 - To-Do List
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Complete Java Assignments");
        tasks.add("Study for CAO test");
        tasks.add("Push code to GitHub");
        tasks.add("Review commits");
        tasks.remove("Study for CAO test");
        
        StringBuffer sb = new StringBuffer();
        sb.append("\nTo-Do List\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + ". " + tasks.get(i) + "\n");
        }
        System.out.println(sb.toString());
    }
}