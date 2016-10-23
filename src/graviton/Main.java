package graviton;


import graviton.bruteforce.Bruteforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Botan on 23/10/2016.
 */
public class Main {
    static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        String dictionary = "1234567";
        for(int i = 0; i < dictionary.length(); i++) {
            executorService.execute(new Bruteforce(dictionary, i) {
                @Override
                public void perform(String password) {
                    BruteForceTest.print(password);
                }
            });
        }


    }

}
