import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    static int calculateCurrentFrequency(List<String> frequencyChanges) {
        return frequencyChanges.stream()
                .map(Integer::valueOf)
                .reduce(0, (a,b) -> a + b);
    }

    public static void main(String[] args) throws Exception {
        //store each line of the input stream in an arrayList
        List<String> frequencyChanges = new ArrayList<>();

        //read puzzle input file
        try (FileReader inputStream = new FileReader("C:/Users/Victor/Downloads/AoC/Day1input.txt")) {
            BufferedReader reader = new BufferedReader(inputStream);

            String line;
            while ((line = reader.readLine()) != null) {
                frequencyChanges.add(line);
            }
        }

        //report how many elements were added to the list
        System.out.println("Read " + frequencyChanges.size() + " lines in the input file:");

        int currentFrequency = calculateCurrentFrequency(frequencyChanges);
        //print result of summation
        System.out.println("The sum of all elements is: " + currentFrequency);
    }

}
