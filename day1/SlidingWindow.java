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
            slide.add(Integer.parseInt(line));
            do{
                slide.add(Integer.parseInt(line));
                line = read.readLine();
            }while(line != null); //This should load the entire arraylist with the input
            //System.out.println(slide.get(0)); //188 (confirmed)
            //System.out.println(slide.get(slide.size()-1)); //8710 (confirmed)
            //System.out.println(slide.size()-1); //2000 (confirmed)

            int sum = 0;
            int sum2 = 0;
            int count = 0;
            for(int i = 1;i<slide.size()-1;i++){
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
