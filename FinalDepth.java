/*
Advent of Code - Exercise 2 - Part 1
It seems like the submarine can take a series of commands like forward 1, down 2, or up 3:

forward X increases the horizontal position by X units.
down X increases the depth by X units.
up X decreases the depth by X units.

Note that since you're on a submarine, down(+depth) and up(-depth) affect your depth, 
and so they have the opposite result of what you might expect.
Your horizontal position and depth both start at 0.

Calculate the horizontal position and depth you would have after following the planned course. 
What do you get if you multiply your final horizontal position by your final depth?
*/
package aoc2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FinalDepth {
    public static void main(String[] args){
        String fileName = "aoc2input.txt";
        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            ArrayList<String> deep = new ArrayList<String>();
            String input = "";
            do{
                input = read.readLine();
                deep.add(input);
            }while(input != null); //load arraylist till EOF
            read.close(); //close reader

            int depth = 0;
            int dist = 0;
            int move = 0;
            String direct = "";
            String out = "";
            for(int i=0;i<deep.size();i++){
                out = deep.get(i);
                if(out != null){
                    String[] temp = out.split(" ");
                    direct = temp[0];
                    move = Integer.parseInt(temp[1]);
                    if(direct.equals("forward")){
                        dist += move;
                        System.out.println("3");
                    }
                    else if(direct.equals("up")){
                        depth -= move;
                        System.out.println("4");
                    }
                    else if(direct.equals("down")){
                        depth += move;
                        System.out.println("5");
                    }
                }
            }
            System.out.println("Your depth travelled is " + depth);
            System.out.println("Your distance is " + dist);
            System.out.println("Your final position is " + (dist*depth));
        }
        catch (FileNotFoundException e) {
        System.out.println("Error. Cannot find the file.");
        e.printStackTrace();
        }
        catch (IOException e) {
        System.out.println("Error. I/O Exception.");
        e.printStackTrace();
        }
    }
    
}
