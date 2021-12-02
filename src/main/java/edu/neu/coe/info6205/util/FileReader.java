package edu.neu.coe.info6205.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader {

    public static void main(String[] args) throws URISyntaxException, IOException {

        String fileName = "shuffledChinese.txt";
        System.out.println("******** tEST **********");
        String[] k = fileReader(fileName);

        System.out.println(k[0]);


    }

    public static String[] fileReader(String fileName) throws URISyntaxException, IOException {

        String[] stringArray;
        BufferedReader br = null;
        URL resource = null;
        ArrayList<String> lines = new ArrayList<>();

        try {
            resource = FileReader.class.getClassLoader().getResource(fileName);
            br = new BufferedReader(new java.io.FileReader(new File(resource.toURI())));

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (Exception e) {
            System.out.println("*** Error occured in FileReader.java class ====> " + e.getMessage());
        } finally {
            br.close();
        }


        Object[] gfg = lines.toArray();
        stringArray = Arrays.copyOf(gfg, gfg.length, String[].class);


        return stringArray;
    }


}
