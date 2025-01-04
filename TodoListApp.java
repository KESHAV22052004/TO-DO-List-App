import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private ArrayList<String> todoList;
    private Scanner scanner;

    public TodoListApp() {
        todoList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Todo List App");
        System.out.println("1. Add Todo");
        System.out.println("2. View Todos");
        System.out.println("3. Remove Todo");
        System.out.println("4. Exit");
    }

    public void addTodo() {
        System.out.print("Enter a todo: ");
        String todo = scanner.nextLine();
        todoList.add(todo);
        System.out.println("Todo added.");
    }

    public void viewTodos() {
        System.out.println("Your Todos:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
    }

    public void removeTodo() {
        viewTodos();
        System.out.print("Enter the number of the todo to remove: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline
        if (index >= 0 && index < todoList.size()) {
            todoList.remove(index);
            System.out.println("Todo removed.");
        } else {
            System.out.println("Invalid number.");
        }
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addTodo();
                    break;
                case 2:
                    viewTodos();
                    break;
                case 3:
                    removeTodo();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        TodoListApp app = new TodoListApp();
        app.run();
    }
}
