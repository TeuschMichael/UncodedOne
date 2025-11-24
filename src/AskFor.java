import java.util.Scanner;
import java.util.function.Predicate;

public class AskFor {
    private static Scanner input = new Scanner(System.in);

    //TODO loop toevoegen of invoer wel valide is. (predicate of string bv om te checken of het geen lege string of alleen maar nummers zijn)
    public static String line(String message){
        System.out.println(message);
        return input.nextLine();
    }

    //TODO toetsen op predicate 
    public static String line(Predicate<String> predicate, String message){
        System.out.println(message);
        return input.nextLine();
    }

}
