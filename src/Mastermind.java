import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Mastermind
{
    private static final Random rando = new Random();

    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        String[] colorsOfThisRound;
        String input;
        String[] input2;
        boolean won;
        boolean playagain = true;
        int rightPins;
        String decision;
        int counter;


        while (playagain)
        {
            won = false;
            counter = 0;
            rightPins = 0;
            colorsOfThisRound = ColorGenerate.getRoundColors();
            System.out.println(Arrays.toString(colorsOfThisRound));
            System.out.println("Hello and Welcome to MasterMind.");
            System.out.println(
                    "Please enter your guess (rouge(R), jaune (J), bleu (B), orange (O), vert (V), noir (N)), and seperate them with a ',' ");
            System.out.println(
                    "You only have 10 time to try! ");
            for(int time=1;time<11;time++)
            {
                int nbo= 0;
                int nbm = 0;
                input = reader.nextLine();
                counter++;
                rightPins = 0;
                input = input.replaceAll(" ", "");
                input2 = input.split("\\,", -1);
                System.out.println(time+"/10");
                if (input2.length == 4)
                {
                    for (int i = 0; i < 4; i++)
                    {
                        input2[i] = input2[i].toUpperCase();

                        if (colorsOfThisRound[i].equals(input2[i].toString()))
                        {
                            input2[i] = "√";
                            rightPins++;
                        } else if (Arrays.asList(colorsOfThisRound).contains(input2[i]))
                        {
                            input2[i] = "m";
                            rightPins = 0;
                        } else
                        {
                            input2[i] = "×";
                            rightPins = 0;
                        }

                    }

                    for (int k = 0; k < 4; k++)
                    {
                        System.out.print(input2[k]);
                        if(input2[k].equals("√")){nbo = nbo + 1 ;};
                        if(input2[k].equals("m")){nbm = nbm + 1 ;};
                    }
                    System.out.println(nbo+"|"+nbm);
                    System.out.println();
                    if (rightPins == 4)
                    {
                        won = true;
                        break;
                    }
                } else
                {
                    System.out.println("There has been an Error, please try again.");
                }
            }
            if(won){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Congratulations, you won! It only took you "+counter+" tries!");
            }else{
                System.out.println("sorry, you have lost this game!");
            }
            System.out.println("Do you want to play again? (yes/no)");
            decision = reader.nextLine();
            if (decision.toLowerCase().equals("yes"))
            {

            } else
            {
                playagain = false;
            }
        }
    }

}