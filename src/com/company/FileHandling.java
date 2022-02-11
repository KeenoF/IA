package com.company;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileHandling {

    //Reads and prints out the contents of a text file
    public static ArrayList<String> readFileData(String fileName) {

        ArrayList<String> fileData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                fileData.add(line);
                line = br.readLine();

            }
        } catch (IOException e) {
            System.out.println("Error reading" + fileName);
        }
        return fileData;
    }

    //Writes content to a file
    public static void writeToFile(String fileName, ArrayList<String> data, boolean append) {
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, append))) {
            for(int i = 0; i < data.size(); i++){
                pr.print(data.get(i));
            }

        }
        catch (IOException e) {
            System.out.println("Error writing" + fileName);
        }

    }

}
