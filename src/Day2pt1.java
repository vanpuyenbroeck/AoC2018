import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day2pt1 {
    public static void main(String[] args) throws Exception{
        //store each line of the input stream in an arrayList
        ArrayList<String> inputList = new ArrayList<>();

        //read puzzle input file
        try (FileReader inputStream = new FileReader("C:/Users/Victor/Downloads/AoC/Day2input.txt")) {
            BufferedReader reader = new BufferedReader(inputStream);

            String line;
            while((line = reader.readLine()) != null){
                inputList.add(line);
            }
        }

        //initialize checksum lists for 2 and 3 character repeats
        int list2 = 0; //indexes with exactly 2 of any letter
        int list3 = 0; //indexes with exactly 3 of any letter

        //loop for all lines in input list
        for(int i = 0; i < inputList.size(); i++){

            //load first string from list
            String ID = inputList.get(i);
            System.out.println("Current string ID: " + ID);

            //use a list to track which characters of the current string have been analysed used so far
            List<String> unique = new ArrayList<>();

            boolean reached2 = false; //to check if string is already added to list2
            boolean reached3 = false; //to check if string is already added to list3

            //loop for all characters in input string
            for(int j = 0; j < ID.length(); j++){
                char ch = ID.charAt(j);

                if(!unique.contains(Character.toString(ch))){
                    //count how many times chosen char occurs in string
                    int charCount = 0;

                    for(int k = 0; k < ID.length(); k++){
                        if(ID.charAt(k) != ch){
                            continue;
                        }
                        else{
                            charCount++;
                        }
                    }
                    System.out.println("Current char: " + ch + " occurs " + charCount + " times");
                    //classify character count
                    if(charCount == 3){
                        //check if string was already added to list3
                        if(!reached3){
                            list3++;
                            reached3 = true;
                        }
                    }
                    else if(charCount == 2){
                        //check if string was already added to list2
                        if(!reached2){
                            list2++;
                            reached2 = true;
                        }
                    }
                }
                unique.add(Character.toString(ch));
            }
        }
        int checksum = (list2*list3);
        System.out.println("list2: " + list2);
        System.out.println("list3: " + list3);
        System.out.println("Checksum: " + checksum);
    }
}
