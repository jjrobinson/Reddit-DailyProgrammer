/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package challenge302.intermediate;



import org.jjrobinson.util.fileio.ChallengeInput;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Jason Robinson github.com/jjrobinson
 */
public class ASCIIHistogramMaker {
    
    public static void main(String[] args){
        String inFile="/data/challenge302intermediate.txt";
        
//        ArrayList<int[]> graphData = new ArrayList<int[]>();
        ArrayList<String> input = new ChallengeInput()
                .getInputByLines(ASCIIHistogramMaker.class, inFile);
//take first line as the chart bounds and create new BarChart with those bounds
        IntBasedBarChart chart = new IntBasedBarChart(input.remove(0).split(" "));
        
        //take next line as the number of chart elements
        int size = Integer.parseInt(input.remove(0));
        
        for(int i=0; i<size ;i++){
//            System.out.println("Parsing: graph data line=\""+input.get(i)+"\"");
            chart.addData(stringArraytoIntArray(input.get(i).split(" ")));
        }//end adding all lines


        printChart(chart, size);
        
    }//end main
    
    
    private static void printChart(IntBasedBarChart c, int size){
        ArrayList<int[]> data = c.getData();
        if (data.size() == size){
            //what is the step between elements
            int step = ((c.getBounds().getMaxX() - c.getBounds().getMinX()) / size);

            //find the MAX # of chars for each entry in the chart
            //if chart starts at 0 and goes to 100, the step should be 3 chars
            int charStep = String.valueOf(c.getMaxX()).length();
            char chartChar = '*';
            int numColumns=((size+1)*(charStep+1));
//            System.out.println("MinY="+c.getMinY());
//            System.out.println("MaxY="+c.getMaxY());
//            System.out.println("MinX="+c.getMinX());
//            System.out.println("MaxX="+c.getMaxX());
//            System.out.println("number of X columns="+numColumns);

            //chreate a 2D char array to store the final barChart
            //the height is the difference between maxX-minX +1 (for x axis labels)
    //        char[][] graph = new char[c.getMaxX()-c.getMinX()+1]
    //                //and the width of the chart is the charStep
    //                [(charStep+1)*size];

            int yAxisCharMax = String.valueOf(c.getMaxY()).length();
//print the x axis guide significant digit
//            System.out.print(StringUtils.repeat(" ", yAxisCharMax));
//            for(int i=1;i<numColumns;i++){
//                if(i/10 >0)
//                    System.out.print(i/10);
//                else
//                    System.out.print(" ");
//            }
//            System.out.println("|");

//print the x axis guide
//            System.out.print(StringUtils.repeat(" ", yAxisCharMax));
//            for(int i=1;i<numColumns;i++){
//                System.out.print(i%10);
//            }
//            System.out.println("|");
//
//print if this column is a printing column
//            System.out.print(StringUtils.repeat(" ", yAxisCharMax));
//            for(int i=1;i<numColumns;i++){
//                if(i % (charStep+1) == 0 && i >0)
//                    System.out.print("p");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println("|");
//


            for(int y=c.getMaxY();y>=c.getMinY();y--){
                System.out.print(String.format("%0"+yAxisCharMax+"d",y));
                int maxX = 0;
                for(int x = 1;x<numColumns;x++){

                    //need to find if the current column is a printing column
                    if(x % (charStep+1) == 0 && x >0){
                        
//calc the current column in the data, check the value
//if the data value is <= current y axis, print chartChar
                        if(y <= data.get(x/(charStep+1)-1)[2]){
                            System.out.print(chartChar);
                        } else {//Y is > data value, so print space
                            System.out.print(" ");
                        }
                    } else {//not a printing column, print space
                        System.out.print(" ");
                    }
                    maxX = x;
                }//end looping through x Axis

                //print newline at the end of the X axis on this level of Y axis
                System.out.println();//end the printed line
            }//end of loop on data

//    //print if this column is a printing column
//            System.out.print(StringUtils.repeat(" ", yAxisCharMax));
//            for(int i=1;i<numColumns;i++){
//                if(i % (charStep+1) == 0 && i >0)
//                    System.out.print("p");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println("|");
//
    //print the X axis
            System.out.print(StringUtils.repeat(" ", yAxisCharMax));
            for(int[] d: c.getData()){
                System.out.print(String.format("%0"+String.valueOf(c.getMaxX()).length()+"d", d[0])+" ");
            }
            System.out.println(String.valueOf(c.getMaxX()));
        
        }//the data we got returned is the expected size
        else {
            System.out.println("ERROR: data size \""+data.size()+"\" is !="+size);
        }
    }
    
    
    
    private static int[] stringArraytoIntArray(String[] s){
//        System.out.println("Size="+s.length);
        int[] asInts = new int[s.length];
        try{
        for(int i=0;i<s.length;i++){
//            System.out.println("Parsing: "+s[i]);
            asInts[i]= Integer.parseInt(s[i]);
            }
        } catch(Exception e){
            System.out.println("ERROR: NumberFormatException: "+e
                    +"\n"+Arrays.toString(s));
        }
        return asInts;
    }
}
