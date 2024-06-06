import java.util.ArrayList;

public class TaskManager{
    //MVP: Minimum Viable Product
    //Be able to add a Task -> DONE
    //Have a list of all the tasks -> getTasks();
    //Set a task as done, by Task name

    private ArrayList<Task> tasks = new ArrayList<Task>();

    //Because we want to use the default construcor
    // new TaskManager() - we don't need to add a custom constructor

    public void addTask(Task task){
        tasks.add(task);
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void setTaskAsDone(String taskName){
        tasks.stream()
                .filter(x -> x.name.equals(taskName))
                .findFirst()
                .ifPresent(x -> x.isDone = true);
    }

    //BONUS:
    //Get a random quote to stop procrastinating
    //A list of undone tasks - filter
    //A list of done tasks - filter
}