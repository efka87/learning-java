import java.util.Scanner;

public class Main { //Is the UI - frontend

    public static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        createTask();
        taskManager.setTaskAsDone("asd");
        showTodoList();
        //Create a menu:
        //Put it in a while loop
        //Use scanner
        //if the user presses 1, we call CreateTask
        //if the user presses 2, we call showTodoList
        //if the user presses 3, ask the task name with isDone = true
        //if the user presses x, close the loop


        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press 1 to create a task");
            System.out.println("Press 2 to show the todo list");
            System.out.println("Press 3 to set a task as done");
            var userInput = scanner.nextLine();
            if(userInput.equals("1")){
                createTask();
            }else if(userInput.equals("2")){
                showTodoList();
            }else if(userInput.equals("3")){
                showTodoList();
                System.out.println("Enter the finished task name:");
                var taskName = scanner.nextLine();
                taskManager.setTaskAsDone(taskName);
            }else{
                break;
            }
        }
    }

    public static void createTask(){
        Scanner scanner = new Scanner(System.in);
        // Input the task name
        System.out.println("Please input the name of the task");
        var name = scanner.nextLine();
        // Input the task description
        System.out.println("Please input the description of the task");
        var description = scanner.nextLine();

        var task = new Task(name, description);
        taskManager.addTask(task);
    }
    public static void showTodoList(){
        var tasks = taskManager.getTasks();
        for(var task : tasks){
            System.out.println("This is a TASK");
            System.out.println(task.name);
            System.out.println(task.description);
            System.out.println(task.isDone);
        }
    }
}