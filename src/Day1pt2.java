import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day1pt2 {
    public static void main(String[] args) throws Exception{
        //store each line of the input stream in an arrayList
        ArrayList<String> inputList = new ArrayList();

        //read puzzle input file
        try (FileReader inputStream = new FileReader("C:/Users/Victor/Downloads/AoC/Day1input.txt")) {
            BufferedReader reader = new BufferedReader(inputStream);

            String line = new String();
            while((line = reader.readLine()) != null){
                inputList.add(line);
            }
        }
        //create a list to store frequency results
        ArrayList<String> frequencyList = new ArrayList();

        //initial value of frequency list is 0
        frequencyList.add("0");
        int currentFrequency = 0;
        System.out.println("Initial frequency: " + currentFrequency);

        //update current frequency with input list items
        String newFrequency = "";
        boolean duplicate = false;
        int loopCounter = 1;
        do {
            for (String item : inputList) {
                //obtain frequency change, convert to integer and add to current frequency
                currentFrequency += Integer.valueOf(item);
                //check if the new frequency occurs in the frequency list
                newFrequency = Integer.toString(currentFrequency);
                if (frequencyList.contains(newFrequency)) {
                    duplicate = true;
                    break;
                }
                //store result in frequency list
                else {
                    frequencyList.add(newFrequency);
                }
            }
            loopCounter++;
        } while(!duplicate);

        //print double frequency
        System.out.println("First frequency that is reached twice is: " + currentFrequency);
        System.out.println("Computation required " + loopCounter + " frequency change list iterations");
    }
}

