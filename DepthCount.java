/*
Advent of Code - Exercise 1:
This report indicates that, scanning outward from the submarine, the sonar sweep found depths of 199, 200, 208, 210, and so on.

The first order of business is to figure out how quickly the depth increases, just so you know what you're dealing with - you never know if the keys will get carried into deeper water by an ocean current or a fish or something.

To do this, count the number of times a depth measurement increases from the previous measurement.

How many measurements are larger than the previous measurement?
*/
package aoc1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DepthCount {
    public static void main(String[] args){
        String fileName = "aoc1input.txt";
        try {
            int count = 0;
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            String line = read.readLine();
            int depth = Integer.parseInt(line);
            do{
                if(depth < Integer.parseInt(line)){
                    depth = Integer.parseInt(line);
                    line = read.readLine();
                    count++;
                }
                else{
                    depth = Integer.parseInt(line);
                    line = read.readLine();
                }
            }while(line != null);
            System.out.println(count);
            read.close();
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
