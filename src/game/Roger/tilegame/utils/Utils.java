package game.Roger.tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//helper functions for the game
public class Utils {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path)); //read from file
            String line;
            while ((line = br.readLine()) != null) //when there is still information to be read
                builder.append(line).append("\n");

            br.close();//close reader
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString(); //return read items in string format
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number); // convert the string to number
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
