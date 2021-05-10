package persanal.dorn;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class MyReader {
    private final Reader reader;

    public MyReader(String inFile) throws FileNotFoundException {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
    }

    public ArrayList<String> readFile() throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> strings = new ArrayList<>();

        int symbol = 0;
        do {
            symbol = reader.read();
            if (Symbol(symbol))
                stringBuilder.appendCodePoint(symbol);
            else{
                if (!stringBuilder.toString().equals("")) {//finished string
                    strings.add(stringBuilder.toString().toLowerCase(Locale.ROOT));
                    stringBuilder = new StringBuilder();
                }

            }

        } while (symbol != -1);
        return strings;
    }

    private boolean Symbol (int a){//do smth with it
        return (a >= 48 && a <= 57) || (a >= 65 && a <= 90) || (a >= 97 && a <= 122) || (a >= 1040 && a <= 1103) || (a == 1105 || a == 1025);

    }



}



