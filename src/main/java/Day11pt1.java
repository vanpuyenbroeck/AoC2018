public class Day11pt1 {
    private int serial;

    //X,Y coordinates of cell block with highest power
    private int bestX = 0;
    private int bestY = 0;
    private int highestPower = 0;

    private Day11pt1(int serialNo){
        serial = serialNo;
    }

    //find fuel cell power level
    private int cellPower(int x, int y){
        int rackID = (x + 10);
        int powerLevel = (((rackID * y) + serial) * rackID);
        if(powerLevel >= 100){
            String power100 = Integer.toString(powerLevel);
            char char100 = power100.charAt(power100.length()-3);
            powerLevel = (Character.getNumericValue(char100) - 5);
        }
        else{
            powerLevel = -5;
        }
        return powerLevel;
    }

    //calculate sum of power in 3x3 square, given coordinates of the top-left cell
    private int squarePower(int x, int y){
        int powerSum = 0;
        for(int i = x; i <= (x+2); i++){
            for(int j = y; j <= (y+2); j++){
                if((i > 0) && (i < 300)){
                    if((j > 0) && (j < 300)){
                        powerSum += cellPower(i,j);
                    }
                }
            }
        }
        return powerSum;
    }

    //find cells with largest 3x3 power
    private void calculateLargestPower(){

        //evaluate total power of each 3x3 grid, store in a separate array
        int[][] squarePowers = new int[300][300];
        for(int i = 0; i < 300; i++){
            for(int j = 0; j < 300; j++){
                squarePowers[i][j] = squarePower(i,j);
            }
        }

        //search highest value
        for(int i = 0; i < 300; i++){
            for(int j = 0; j < 300; j++){
                int testPower = squarePowers[i][j];
                if(testPower > highestPower){
                    highestPower = testPower;
                    bestX = i;
                    bestY = j;
                }
            }
        }
    }

    public static void main(String[] args){

        Day11pt1 device = new Day11pt1(3463);
        device.calculateLargestPower();
        System.out.println("3x3 grid with largest power (" + device.highestPower + ") found at X,Y: " + device.bestX + "," + device.bestY);
    }
}
