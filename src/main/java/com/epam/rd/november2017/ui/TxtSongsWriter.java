package com.epam.rd.november2017.ui;

import com.epam.rd.november2017.MyHashMap;
import com.epam.rd.november2017.MyMap;

import java.io.*;

public class TxtSongsWriter<K,V> {

    private static final char SEPARATOR = ';';

    public void writeSongs(MyHashMap<K, V> songsCatalog, String path){
        StringBuilder sb = new StringBuilder();
        for (MyMap.Entry<K, V> entry : songsCatalog){
            sb.append(entry.getKey().toString());
            sb.append(SEPARATOR);
            sb.append(entry.getValue().toString());
            sb.append(SEPARATOR);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        File file = new File(path);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)){
            PrintWriter pw = new PrintWriter(bw);
            pw.print(sb.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
