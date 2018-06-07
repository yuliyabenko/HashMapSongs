package com.epam.rd.november2017.ui;

import com.epam.rd.november2017.MyHashMap;
import com.epam.rd.november2017.MyMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtSongsReader {
    public MyHashMap<String,String> readSongs(String path){
        File file = new File(path);
        if (file.isDirectory()|| !file.exists()){
            throw new IllegalArgumentException("Incorrect file name!");
        }
        MyHashMap<String,String> songsCatalog = new MyHashMap<>();
        try (Scanner s = new Scanner(file)){
            while (s.hasNextLine()){
                String line = s.nextLine();
                songsCatalog.put(parse(line).getKey(),parse(line).getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return songsCatalog;
    }

    private MyMap.Entry<String,String> parse(String line){
        MyMap.Entry entry;

        String[] array = line.split(";");
        if (array.length !=2 ){
            throw new IllegalArgumentException("Incorrect data in file!" + line);
        }
        entry = new MyMap.Entry(array[0],array[1]);

        return entry;
    }
}
