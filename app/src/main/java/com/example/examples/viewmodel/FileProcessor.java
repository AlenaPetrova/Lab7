package com.example.examples.viewmodel;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
    public static String loadFileContent() {
        String result;
        StringBuilder stringBuilder = new StringBuilder();
        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(downloadsDir, "resultLog.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(myFile));

            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        result = stringBuilder.toString();
        return result;


    }
    public static void writeToFile(String message) {
        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(downloadsDir,"resultLog.txt");
        try {
            FileWriter out = new FileWriter(myFile, true);
            out.write(message+"\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
