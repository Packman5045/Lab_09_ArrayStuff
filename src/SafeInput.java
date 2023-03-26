import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author wulft
 */
public class SafeInput
{
    static Random rng = new Random();
    public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi)
    {
        int result = 0;
        boolean done = false;
        String trash = "";
        do
        {
            // Code and control logic to loop until validated
            System.out.print(prompt + "[" + lo + " - " + hi + "]: ");
            if(pipe.hasNextInt())
            {
                result = pipe.nextInt();
                pipe.nextLine(); // clear input buffer
                if(result >= lo && result <= hi)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value in range [" + lo + " - " + hi + "]: " + result);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int [" + lo + " - " + hi + "]: " + trash);
            }

        }while(!done);

        return result;

    }
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; //Set this to zero length. Loop runs until it isn't do
        {
            System.out.print("\n" + prompt + ":"); //show prompt add space
            retString = pipe.nextLine(); //clears buffer
        }
        while (retString.length() == 0) ;

        return retString;
    }




    //Get an int value with no constraints
    //@param pipe Scanner instance to read the data System.in in most cases
    //@param prompt input prompt message should not include range information
    //@return unconstrained int value
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        }while(!done);

        return retVal;

    }


//get a Double value within a range
//@param pipe Scanner instance to read the data System.in in most cases
//@param prompt input prompt message should not contain range information
//@param low the low value is provided
//@param high the high value is provided
//@return double value withing specified range

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: " + retVal);
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }

        }while(!done);
        return retVal;
    }


//get an unconstrained double value
//@param pipe Scanner instance to read the data System.in in most cases
//@param prompt input prompt message should not contain range information
//@return an unconstrained double value

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        }while(!done);

        return retVal;

    }

//get a yes no confirmation from the user
//@param pipe Scanner instance to read the data System.in in most cases
    //@param prompt input prompt message for user does not need yes or no
    //@return true for yes false for no

    public static boolean getYNConfirmation(Scanner pipe, String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotVal = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                gotVal = true;
                retVal = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                gotVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must answer [Y/N]! " + response);
            }

        }while(!gotVal);

        return retVal;
    }

    //get a string that matches a RegEx pattern! This is a very powerful method
    //@param pipe Scanner instance to read the data System.in in most cases
    //@param prompt prompt for the user
    //@param regExPattern java style RegEx patter to constrain the input
    //@return a String that matches the RegEx pattern supplied

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String response = "";
        boolean gotVal = false;

        do
        {
            System.out.print("\n" + prompt + ": " + regExPattern);
            response = pipe.nextLine();
            if(response.matches(regExPattern))
            {
                gotVal = true;
            }
            else

            {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }

        }while(!gotVal);

        return response;


    }
    //prettyHeader is used to create a star lined header using loops
//header will always be 60 stars across
//'if/else' statement is used to create the gap for the stars in the middle
    public static void prettyHeader(String msg)
    {
        int n = 60;
        for (int i = 60; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }

            System.out.println();


        }

        for (int i = 60; i <= n; i++) {
            for (int j = 1; j <= n; j++)
            {
                if(j==1 || j == 58 || j==2 || j == 59 || j==3 || j == 60)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();


        }
        for (int i = 60; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }

public static double getAverage(int values[], String prompt)
{
    int array_Size = 100;
    double[] dataPoints;
    dataPoints = new double[array_Size];
    double sum = 0;

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

    double ave = sum / dataPoints.length;

    System.out.println(prompt);
    return ave;
}


}
