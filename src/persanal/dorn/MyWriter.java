package persanal.dorn;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class MyWriter {
    private final Writer writer;
    private final Counter counter;

    public MyWriter(String in, Counter counter) throws IOException {
        writer = new BufferedWriter(new FileWriter(in));
        this.counter = counter;
    }

    private Word[] sort() {
        var sorted = counter.getWords().toArray(new Word[0]);
        Arrays.sort(sorted, Collections.reverseOrder());
        return sorted;
    }

    public void write() throws IOException {
        Word[] arraySortedWord = sort();
        for (Word word : arraySortedWord) {
            writer.write(String.format("%s, %d, %.2f%%\n", word.getWord(), word.getCountOfWord(), counter.fraction(word)));
        }
    }

    public void close() throws IOException {
        writer.close();
    }
}
