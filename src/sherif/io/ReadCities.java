/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sherif.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import org.jgap.Gene;
import org.jgap.IChromosome;
import org.jgap.impl.IntegerGene;

import sherif.AbstractTSPData;

/**
 *
 * @author kadersh
 */
public class ReadCities extends AbstractTSPData {

    public int[] optimal = null;

    public ReadCities(String input) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(new File(input)));

            String line = in.readLine();

            counter = Integer.valueOf(line.trim());

            coordinateArray = new double[counter][2];

            for (int i = 0; i < counter; i++) {
                line = in.readLine();

                StringTokenizer st = new StringTokenizer(line, " ");
                st.nextToken();

                coordinateArray[i][0] = Double.valueOf(st.nextToken());//the channel number
                coordinateArray[i][1] = Double.valueOf(st.nextToken());//count

            }
            //Parse $DATA:
            //Get numOfChannels
            //Get counts
        } catch (IOException e) {
            // catch io errors from FileInputStream or readLine()
            e.printStackTrace();

        } finally {
            // if the file opened okay, make sure we close it
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            } // end if

        } // end finally
    }

    public ReadCities(String input, String optFile) {
        this(input);

        optimal=new int[counter];

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(new File(optFile)));

            for (int i = 0; i < counter; i++) {
                String line = in.readLine();                
                optimal[i]=Integer.parseInt(line);
            }
         
        
        } catch (Exception e) {
            // catch io errors from FileInputStream or readLine()
            e.printStackTrace();

        } finally {
            // if the file opened okay, make sure we close it
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            } // end if

        } // end finally
    }
}
