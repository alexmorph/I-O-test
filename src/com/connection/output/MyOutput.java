package com.connection.output;

import com.connection.dateformat.DateFormat;

import java.io.*;
import java.util.Date;

public class MyOutput {

    public void findDate(String fileName, String dateToFind) throws IOException {
        exists(fileName);

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = reader.readLine()) != null) {
            String[] words = s.split(" ");
            if (s.isEmpty())
                continue;
            String currentData = DateFormat.formatFileDate(words[0]);
            if (currentData.equals(dateToFind)) {
                System.out.println("log: " + currentData + "; " + s);
            }
        }
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }


    private String daysToDelete(int days) {
        if (days >= 0) {
            Date date = new Date();
            long diff = date.getTime() - ((24 * 60 * 60 * 1000) * days);
            return String.valueOf(diff);
        }
        return "-1";
    }


    public void deleteStringFromFile(String fileName, int days) {
        String definiteString = daysToDelete(days);
        definiteString = definiteString.substring(0, 5);
        String string = null;
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            while ((string = reader.readLine()) != null) {
                if (string.startsWith(definiteString)) {
                    sb.append(string).append("\n");
                }
            }
            string = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] buffer = new char[string.length()];
        string.getChars(0, string.length(), buffer, 0);

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
