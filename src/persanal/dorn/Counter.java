package persanal.dorn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Counter {
    private int summWords;
    private final Map <String, Word> dictionary;


    public Counter(){
        dictionary = new HashMap<>();
        summWords = 0;
    }

    public void count (String word){
        Word chekWord = dictionary.get(word);
        if (chekWord != null)//word was in dictionary
            chekWord.upcount();
        else {
            dictionary.put(word, new Word(word, 1));
        }
        summWords++;
    }

    public int getSummWords (){
        return summWords;
    }

    public double fraction (Word word){
        return (double) word.getCountOfWord() / summWords * 100;
    }

    public Collection<Word> getWords(){
        return dictionary.values();
    }
}
