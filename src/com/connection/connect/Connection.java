package com.connection.connect;

import com.connection.exception.MyException;
import com.connection.input.FilePath;
import com.connection.input.MyInput;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Connection implements FilePath {

    private long time;
    private String ip;
    private int session;
    public static List<Connection> connections = new ArrayList<>();

    public long getTime() {
        return time;
    }

    public String getIp() {
        return ip;
    }

    public int getSession() {
        return session;
    }

    public Connection() {
        Date date = new Date();
        Random random = new Random();
        this.time = date.getTime();
        this.session = 100000000 + random.nextInt(900000000);
        this.ip = (random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) +
                "." + random.nextInt(256));
    }

    public void generateLog(int count) throws MyException {
        for (int i = 0; i < count; i++) {
            connections.add(new Connection());
        }
        MyInput myinput = new MyInput();
        myinput.writeToFile(FilePath.FILE_PATH);
    }


}
