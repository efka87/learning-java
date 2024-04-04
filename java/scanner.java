import java.util.Scanner; // import the Scanner class 

class scanner {
  public static void main(String[] args) {
    Scanner canon = new Scanner(System.in);

    System.out.println("Welcome to Story tellers!");
    System.out.println("");

    System.out.println("Please enter your name:"); 
    String name = canon.nextLine(); 
    System.out.println("Hello, " + name); 
    System.out.println("");

    System.out.println("Tell me your age:");
    String age = canon.nextLine();
    System.out.println("");

    System.out.println("What is your gender? (male, female)");
    String gender = canon.nextLine();
    System.out.println("");

    System.out.println("Who is your favorite animal? ");
    String animal = canon.nextLine();
    System.out.println("Very interesting!");
    System.out.println("");

    System.out.println("Where do you live?");
    String city = canon.nextLine();
    System.out.println(city + " is a nice place!");
    System.out.println("");

    System.out.println("What is your favorite food?");
    String food = canon.nextLine();
    System.out.println(food + " is always a good choice");
    System.out.println("");

    System.out.println("Do you have any hobbies?");
    String hobby = canon.nextLine();
    System.out.println("");
    System.out.println("");


    System.out.println("Thank you for telling me about yourself!\nHere is the story recapped:");
    System.out.println("");

    // Generate and print story
    String story = story(name, age, city, food, hobby, animal, gender);
    System.out.println(story);

    canon.close();    
  }

  public static String story(String name, String age, String city, String food, String hobby, String animal, String gender) {
    String pronoun = (gender.equalsIgnoreCase("female")) ? "She" : "He";

    // Generate the story
    String story = "Once upon a time, there was a person named " + name + ". " +
    pronoun + " was " + age + " years old and lived in " + city + ". " +
    pronoun + " loves to eat a lot of " + food + " and the favorite animal was a " + animal + ". " +
    " Favourite hobbies included " + hobby + ". ";

    return story;
  }
}
