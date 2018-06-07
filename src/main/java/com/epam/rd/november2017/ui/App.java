package com.epam.rd.november2017.ui;

import com.epam.rd.november2017.MyHashMap;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;


public class App {

    private MyHashMap<String, String> songsCatalog;

    private enum Action {
        PUT,
        GET,
        SIZE
    }

    private String myJarPath = App.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    private String path = "songsCatalog/songs.txt";

    @Option(name = "-k", usage = "song")
    private String key;

    @Option(name = "-v", usage = "singer")
    private String value;

    @Argument(usage = "action", required = true, metaVar = "action")
    private Action action;


    public static void main(String[] args) throws CmdLineException {
        new App().doMain(args);
    }

    private void doMain(String[] args) throws CmdLineException {
        CmdLineParser parser = new CmdLineParser(this);
        if (args.length == 0) {
            System.out.println("My example with songs catalog. Usage: ");
            parser.printUsage(System.out);
            return;
        } else {
            parser.parseArgument(args);
        }
        TxtSongsReader reader = new TxtSongsReader();
        songsCatalog = reader.readSongs(path);
        switch (action) {
            case PUT:
                songsCatalog.put(key, value);
                TxtSongsWriter writer = new TxtSongsWriter();
                writer.writeSongs(songsCatalog, path);
                System.out.println("Song was added");
                break;
            case GET:
                if (songsCatalog.get(key) != null) {
                    System.out.println("The song " + key + " is performed by " + songsCatalog.get(key));
                } else {
                    System.out.println("Such song doesn't exist!");
                }
                break;
            case SIZE:
                System.out.println("Size of songs catalog = " + songsCatalog.size());
                break;
            default:
                throw new AssertionError("No way!");
        }
    }


}
