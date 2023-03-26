import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    int array_Size = 100;
    int[] dataPoints;
    int sum = 0;
    dataPoints = new int[array_Size];
    int loopAmount = 0;
    //sets the values 0 - 99



        Random rng = new Random();
        Scanner scan = new Scanner(System.in);



        for(int x = 0; x < dataPoints.length; x++)
        {
            dataPoints[x] = rng.nextInt(100) + 1;
        }
        for(int x = 0; x < dataPoints.length; x++)
        {
            System.out.printf("%5d", dataPoints[x]);
            if(x % 20 == 0 && x > 0)
            {
                System.out.println("");
            }

        }
        System.out.println("");

        for(int x = 0; x < dataPoints.length; x++)
        {
            sum = sum + dataPoints[x];
            //sum += x
        }
        System.out.println("The sum of the numbers are " + sum);
        int ave = sum / dataPoints.length;

        System.out.println("The average of the data set is " + ave);

        int min = dataPoints[0];
        int max = dataPoints[0];

        for(int x = 0; x < dataPoints.length; x++)
        {
            if(min > dataPoints[x])
            {
                min = dataPoints[x];
            }
            if(max < dataPoints[x])
            {
                max = dataPoints[x];
            }
        }
        System.out.println("The min is " + min);
        System.out.println("The max is " + max);


        int userNum = 0;
        int userSecondNum = 0;

        userNum = SafeInput.getRangedInt(scan,"Enter a number please: ",0,100);
        //this is where the user enters the number they are searching for


        boolean numberFound = false;

        for(int x = 0; x < dataPoints.length; x++)

        {
            if(dataPoints[x] == userNum)
            {
                loopAmount++;
                numberFound = true;
                System.out.println("Your number " + userNum + " has been found at location " + x);
                System.out.println("Your number was found a total of " + loopAmount + " times.");
            }
        }
        if (!numberFound)
        {
            System.out.println("Your number: " + userNum + " was not found.");
        }

        userSecondNum = SafeInput.getRangedInt(scan,"Enter a second number please: ",0,100);

        for(int x = 0; x < dataPoints.length; x++)
        {
            if(dataPoints[x] == userSecondNum) {
                numberFound = true;
                System.out.println("Your number has been found first at location " + x);
                break;
            }
            if(!numberFound)
            {
                System.out.println("Your number has not been found.");
                break;
            }
        }






    }
}