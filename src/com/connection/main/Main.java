package com.connection.main;

import com.connection.connect.Connection;
import com.connection.exception.MyException;
import com.connection.input.FilePath;
import com.connection.output.MyOutput;

import java.io.IOException;


public class Main implements FilePath {
    public static void main(String[] args) throws MyException, IOException {
        Connection connection = new Connection();
        connection.generateLog(10); // create logs

        MyOutput myOutput = new MyOutput();
        myOutput.deleteStringFromFile(FilePath.FILE_PATH, 0); // delete logs and re-create file
        myOutput.findDate(FilePath.FILE_PATH, "Jan 2, 2018"); //read logs of current data

    }
}
