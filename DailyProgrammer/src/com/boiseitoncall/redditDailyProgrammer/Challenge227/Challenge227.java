/*
 * 
 */
package com.boiseitoncall.redditDailyProgrammer.Challenge227;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JasonRobinson
 */
public class Challenge227 {

    /**Description
     * My grandmother and I are moving to a new neighborhood. The houses haven't
     * yet been built, but the map has been drawn. We'd like to live as close
     * together as possible. She makes some outstanding cookies, and I love
     * visiting her house on the weekend for delicious meals - my grandmother is
     * probably my favorite cook!  Please help us find the two lots that are
     * closest together so we can build our houses as soon as possible.
     * 
     * <em>Example Input:<em>
     * You'll be given a single integer, N, on a line, then N lines of Cartesian coordinates of (x,y) pairs. 
     * Example:
     * <tt>16 
     * (6.422011725438139, 5.833206713226367)
     * (3.154480546252892, 4.063265532639129)
     * (8.894562467908552, 0.3522346393034437)
     * (6.004788746281089, 7.071213090379764)
     * (8.104623252768594, 9.194871763484924)
     * (9.634479418727688, 4.005338324547684)
     * (6.743779037952768, 0.7913485528735764)
     * (5.560341970499806, 9.270388445393506)
     * (4.67281620242621, 8.459931892672067)
     * (0.30104230919622, 9.406899285442249)
     * (6.625930036636377, 6.084986606308885)
     * (9.03069534561186, 2.3737246966612515)
     * (9.3632392904531, 1.8014711293897012)
     * (2.6739636897837915, 1.6220708577223641)
     * (4.766674944433654, 1.9455404764480477)
     * (7.438388978141802, 6.053689746381798)</tt>
     * <em>Example Output</em>
     * 
     * Your program should emit the two points of (x,y) pairs that are closest together.
     * Example:
     * (6.625930036636377,6.084986606308885) (6.422011725438139,5.833206713226367)
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (args.length > 0) {
            File f = new File(args[0]);

            if(f.exists()){
                System.out.println("File exists");
                
		try {
                    ArrayList<House> houses = getInput(f);
                    


		} catch (IOException e) {
			e.printStackTrace();
		}
                
                
            }else{
                System.out.println("ERROR: Argument 1:" +args[0] +" is not a file, or file not found!");
                System.exit(-1);
            }
        }else {
            System.out.println("ERROR: must supply an argument at runtime.");
            System.exit(-1);
        }

    public static double distanceBetween(House x, House y) {
        return 0.0;
    }

    


    public static ArrayList<House> getInput(File f) throws IOException{
        BufferedReader br = null;
        ArrayList<House> houses = new ArrayList<House>();
        String sCurrentLine;

        br = new BufferedReader(new FileReader(args[0]));

        int houseNumber = 0;
        if ((sCurrentLine = br.readLine()) != null) {
            //we have a first line
            int numHouses = Integer.parseInt(sCurrentLine);
            if (numHouses > 0)
                System.out.println("Number of Houses: " + numHouses);
                //get the rest of the houses
            
                while (houseNumber < numHouses) {
                    if ((sCurrentLine = br.readLine()) != null) {
                        houseNumber++;
                        double newX = 0.0; double newY = 0.0;
                        House newHouse = new House(); 
                        String[] coords = sCurrentLine.split(" ");
                        if (coords.length == 2) {
                            newX = Double.parseDouble(coords[0]);
                            newY = Double.parseDouble(coords[1]);
                            }
                        newHouse.setX(newX);newHouse.setY(newY);
                        houses.add(newHouse);
                    } else {
                        //EOF before we expected.
                        System.out.println("ERROR: came to the end of the file before we expected at house#:" +houseNumber);
                    }
                    
                }
                //done with expected # of lines.

            }
        return houses;
    }
}
