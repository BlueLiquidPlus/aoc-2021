/*
Advent of Code - Exercise 1 - Part 2 :
Start by comparing the first and second three-measurement windows. 
The measurements in the first window are marked A (199, 200, 208); their sum is 199 + 200 + 208 = 607. 
The second window is marked B (200, 208, 210); its sum is 618. 
The sum of measurements in the second window is larger than the sum of the first, 
so this first comparison increased.

Your goal now is to count the number of times the sum of measurements in this sliding window increases 
from the previous sum. So, compare A with B, then compare B with C, then C with D, and so on. 
Stop when there aren't enough measurements left to create a new three-measurement sum.

Consider sums of a three-measurement sliding window. How many sums are larger than the previous sum?
*/
package aoc1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SlidingWindow {
    public static void main(String[] args){
        String fileName = "aoc1input.txt";
        try {
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            String line = read.readLine();
            ArrayList<Integer> slide = new ArrayList<Integer>();
            do{
                slide.add(Integer.parseInt(line));
                line = read.readLine();
            }while(line != null); //This should load the entire arraylist with the input
            //System.out.println(slide.get(0)); //188 (confirmed)
            //System.out.println(slide.get(1)); //192 (confirmed)
            //System.out.println(slide.get(slide.size()-1)); //8710 (confirmed)
            //System.out.println(slide.size()); //2000 (confirmed)

            int sum = 0;
            int sum2 = 0;
            int count = 0;
            for(int i = 0;i<slide.size();i++){
                if(i<slide.size()-3){ 
                    sum = slide.get(i);
                    sum += slide.get(i+1);
                    sum += slide.get(i+2);

                    sum2 = slide.get(i+1);
                    sum2 += slide.get(i+2);
                    sum2 += slide.get(i+3);
                    if(sum < sum2){
                        count++;
                    }
                }
            }
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


//Result should be 1683