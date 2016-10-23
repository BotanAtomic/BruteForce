package graviton.bruteforce;

import java.util.stream.IntStream;

/**
 * Created by Botan on 23/10/2016.
 */
public abstract class Bruteforce extends Thread {
    private final char[] dictionary;
    private final int maxLength;

    public Bruteforce(String dictionary, int max) {
        this.dictionary = dictionary.toCharArray();
        this.maxLength = max;
        setDaemon(true);
        setPriority(MAX_PRIORITY);
    }

    @Override
    public void run() {
        possibleStrings("");
    }

    public void possibleStrings(String current) {
        String[] copy = {current};
        if (current.length() == maxLength) {
            perform(current);
        } else {
            IntStream.range(0,dictionary.length).forEach(value -> {
                String oldCurr = copy[0];
                oldCurr += dictionary[value];
                possibleStrings(oldCurr);
            });
        }
    }

    public abstract void perform(String password);


}
