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
    public static int numDistanceCalcs=0;
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
            for(String s : args) {

                File f = new File(s);

                if(f.exists()){
                    System.out.println("File exists: \"" + f.getPath().toString() + "\"");

                    try {
                        ArrayList<double[]> houses = getInput(f);

                        //spitOutHouses(houses);

                        long start = System.currentTimeMillis();
                        ArrayList<double[]> result = solveBruteForce(houses);
                        long end = System.currentTimeMillis();
                        double[] house1 = result.get(0);
                        double[] house2 = result.get(1);
                        System.out.println("Found Solution in: "+ ((end-start)/1000.0) + "seconds");
                        System.out.println("Number of distance Calculations: " + numDistanceCalcs);
                        System.out.println("Closest Houses: (" + house1[0] + ", "+ house1[1] + ") and (" + + house2[0] + ", "+ house2[1] + ")");

                        //findCorrectHouses(houses);


                    } catch (IOException e) {
                            e.printStackTrace();
                    }


                }else{
                    System.out.println("ERROR: Argument 1:" +args[0] +" is not a file, or file not found!");
                    System.exit(-1);
                }
            }
        }else {
            System.out.println("ERROR: must supply at least one argument at runtime.");
            System.exit(-1);
        }
    }

    public static double distanceSquared(double[] x, double[] y) {
        numDistanceCalcs++;
        double xDist = (y[0]-x[0]);
        double yDist = (y[1]-x[1]);
        return ((yDist*yDist) + (xDist*xDist));
    }

    


    public static ArrayList<double[]> getInput(File f) throws IOException{
        BufferedReader br = null;
        ArrayList<double[]> houses = new ArrayList();
        String sCurrentLine;
        
        br = new BufferedReader(new FileReader(f));


        if ((sCurrentLine = br.readLine()) != null) {
            //we have a first line
            int numHouses = Integer.parseInt(sCurrentLine);
            if (numHouses > 0)
                System.out.println("Number of Houses: " + numHouses);
                
                //get the rest of the houses
                int houseNumber = 0;
                while (houseNumber < numHouses) {
                    if ((sCurrentLine = br.readLine()) != null) {
                        //House newHouse = new House(); 
                        double[] newHouse = new double[2];
                        String[] coords = sCurrentLine.split(" ");
                        if (coords.length == 2) { 
                            newHouse[0] = Double.parseDouble(coords[0]);
                            newHouse[1] = Double.parseDouble(coords[1]);
                            houses.add(newHouse);
                        } else {
                            System.out.println("Wrong number of coords on this line.");
                            System.exit(-1);
                        }
                        houseNumber++;
                    } else {
                        //EOF before we expected.
                        System.out.println("ERROR: came to the end of the file before we expected at house#:" +houseNumber);
                        }
                    //
                }//end while loop on counter < numHouses
                //done with expected # of lines.
            }
        return houses;
        }
    
    public static void spitOutHouses(ArrayList<double[]> houses){
        int counter = 0;
        for(double[] d : houses) {
            counter++;
            System.out.println("House #" + counter + " : " + d[0] + ", " + d[1]);
        }
    }
    
    public static ArrayList<double[]> solveBruteForce(ArrayList<double[]> houses) {
        double[] closest1 = new double[2];
        double[] closest2 = new double[2];
        ArrayList<double[]> result = new ArrayList<double[]>();
        
        
        double smallest = -1.0;
        int problemSize = houses.size();
        
        for(int i=0;i<problemSize;i++) {
            for(int j=i+1;j<problemSize;j++) {
                if(i!=j) {
                    double temp = distanceSquared(houses.get(i),houses.get(j));
                    if(smallest < 0.0) {
                        closest1 = houses.get(i);
                        closest2 = houses.get(j);
                        smallest = temp;
                    } else {
                        if(smallest>temp){
                            closest1 = houses.get(i);
                            closest2 = houses.get(j);
                            smallest = temp;
                        }
                    }
                    
                }//throw out the case of i ==j
            }//end of Y loop
        }//end of X loop
        result.add(closest1);result.add(closest2);
        return result;
    }
    
    public static void findCorrectHouses(ArrayList<double[]> houses){
        double[] house1 = new double[2];
        house1[0] = 5.305665745194435;
        house1[1] = 5.6162850431000875;
        
        double[] house2 = new double[2];
        house2[0] = 5.333978668303457;
        house2[1] = 5.698128530439982;
        
        
        for (double[] d: houses){
            if (d[0] == house1[0])
                if (d[1] == house1[1])
                    System.out.println("House #1 Found: (" + d[0] + ", " +d[1] + ")");
            if (d[0] == house2[0])
                if (d[1] == house2[1])
                    System.out.println("House #2 Found: (" + d[0] + ", " +d[1] + ")");
            
        }
    }

    // 32-bits version!
void radix_sort_3(float array[], int count)
 {
  int zeroes=0;
 
  float temp_array[count]; // c99 only
  float * warray = temp_array;
 
  for (uint32_t radix=1;radix;radix<<=1)
   {
    uint32_t * iarray = (uint32_t *)array;
 
    int count0=0;
    int count1=0;
 
    zeroes=0;
    for (int j=0; j<count; ++j)
     zeroes += !(iarray[j]&radix);
 
    count1=zeroes;
 
    for (int j=0; j < count; ++j)
     if (iarray[j]&radix)
      {
       warray[count1]=array[j];
       ++count1;
      }
     else
      {
       warray[count0]=array[j];
       ++count0;
      }
 
    // we won't copy that 
    // each time!
    swap((float**)&warray,&array);
   }
  // here 'array' is restored to
  // its original value.
 
  // are there negatives?
  //
  if (zeroes<count)
   {
    // oh noes! we must swap parts
    // before leaving!
 
    memcpy( warray+(count-zeroes), array, zeroes*sizeof(float));
 
    for (int d=0,j=count-1;j>=zeroes;j--,d++)
     warray[d]=array[j];
    memcpy( array, warray, count * sizeof(float));
   }
 }
    
    
    
    }
