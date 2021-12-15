/*
Advent of Code - Day 2 Part 2 :
In addition to horizontal position and depth, 
you'll also need to track a third value, aim, which also starts at 0. 
The commands also mean something entirely different than you first thought:

down X increases your aim by X units.
up X decreases your aim by X units.
forward X does two things:
    It increases your horizontal position by X units.
    It increases your depth by your aim multiplied by X.

Using this new interpretation of the commands, 
calculate the horizontal position and depth you would have after following the planned course.
What do you get if you multiply your final horizontal position by your final depth?
*/
package aoc2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AimDepth {
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
            int aim = 0;
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
                        depth += (move*aim);
                    }
                    else if(direct.equals("up")){
                        aim -= move;
                    }
                    else if(direct.equals("down")){
                        aim += move;
                    }
                }
            }
            System.out.println(dist*depth);
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
