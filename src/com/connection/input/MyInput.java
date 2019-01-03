package com.connection.input;

import com.connection.connect.Connection;
import com.connection.exception.MyException;

import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class MyInput {

    public void writeToFile(String filePath) throws MyException {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            for (Connection c : Connection.connections) {
                writer.write("\n" + c.getTime() + " " + c.getSession() + " " + c.getIp());
            }
            writer.close();
        } catch (Exception e) {
            Logger.getLogger(MyInput.class.getName()).log(new LogRecord(Level.WARNING, "Check PATH to the file, or file didn't find!"));
            throw new MyException(e);
        }
    }


}
