import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws Exception {
        //store each line of the input stream in an arrayList
        List<String> list = new ArrayList<>();

        //read puzzle input file
        try (FileReader inputStream = new FileReader("C:/Users/Victor/Downloads/AoC/Day1input.txt")) {
            BufferedReader reader = new BufferedReader(inputStream);

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }

        //report how many elements were added to the list
        System.out.println("Read " + list.size() + " lines in the input file:");

        //list all elements, then add them to starting value of 0.
        int currentFrequency = 0;
        for (int i = 0; i < list.size(); i++) {
            //convert String to numbers
            currentFrequency += Integer.valueOf(list.get(i));
            System.out.println(list.get(i));
        }
        //print result of summation
        System.out.println("The sum of all elements is: " + currentFrequency);
    }
}
