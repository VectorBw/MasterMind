import java.util.Arrays;
import java.util.Random;

public class ColorGenerate
{

    public static enum Color
    {
        R, G, B, O, V, N
    }

    private static final Color[] colors = Color.values();
    private static final Random rando = new Random();

    public ColorGenerate()
    {
        super();

    }

    public static final Color getRandomColor()
    {
        return colors[rando.nextInt(colors.length)];
    }

    public static final String[] getRoundColors()
    {
        String[] colorsOfThisRound = new String[4];
        String color;
        boolean go = false;

        for (int i = 0; i < 4; i++)
        {

                color = (ColorGenerate.getRandomColor()).toString();

                    colorsOfThisRound[i] = color;
                }

        return colorsOfThisRound;

    }

}