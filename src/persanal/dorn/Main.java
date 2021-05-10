package persanal.dorn;

import java.io.*;
import java.util.ArrayList;

public class Main {

    private static void Parcer (String inFile, String outFile){
        MyReader reader = null;
        MyWriter writer = null;

        try {
            reader = new MyReader(inFile);
            ArrayList<String> strings = new ArrayList<>();
            strings = reader.readFile();
            Counter AllWords = new Counter();
            //System.out.println(strings.isEmpty());
            for (var i : strings)
                AllWords.count(i);
            writer = new MyWriter(outFile, AllWords);
            writer.write();
            //System.out.println(AllWords.getSummWords());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        String inFile = "C:/Users/Sasha/IdeaProjects/CsvParcer/test1.txt";
        String outFile = inFile.replace("txt", "csv");
        File out = null;

        if (args.length == 0) {
            out = new File(outFile);
            Parcer(inFile, outFile);
        }else
            for (String arg : args) {
                inFile = arg;
                outFile = inFile.replace("txt", "csv");
                out = new File(outFile);
                Parcer(inFile, outFile);
            }
    }


}