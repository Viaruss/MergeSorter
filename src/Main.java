package Lab3;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int len = 50000;

        ProgBar bar = new ProgBar(n, len);
        bar.setVisible(true);

        Random rd = new Random();
        ArrayList<Integer> tab = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();

        final long startTime = System.currentTimeMillis();
        //List generation
        System.out.println("Generated random table:\n");
        for (int i = 0; i < len; i++) {
            tab.add(rd.nextInt(0, 2000));
            //write out the unsorted list
            System.out.print(tab.get(i) + " ");
        }
        System.out.println();
        final long generatingTime = System.currentTimeMillis() - startTime;
        for (int i = 0; i < n; i++) {
            threads.add(new Sorter(tab, i, n, len, bar));
            threads.get(i).start();
        }

        //wait for all threads to finish
        for (int i = 0; i < n; i++) {
            try {threads.get(i).join();} catch (InterruptedException ignored){}
            bar.iterate(n);
        }
        long sortedTime = System.currentTimeMillis()-startTime;
        threads.clear();

        //merging pre-sorted list ((x+n-1)/2 -> 'ceiling' function)
        for(int i = (n+2-1)/2; i > 0; i--) {
            for(int j = 0; j < i; j++){
                threads.add(new Sorter(tab, j, i, len, bar));
                threads.get(j).start();
            }
            for (int j = 0; j < i; j++) {
                try {threads.get(j).join();} catch (InterruptedException ignored){}
            }
            threads.clear();
            bar.iterate(n);
        }
        long mergedTime = System.currentTimeMillis() - startTime;
        long totalTime = generatingTime + sortedTime + mergedTime;
        System.out.println("done!\nSorted table:");
        for (int i : tab) {
            //write out the sorted list
            System.out.print(i + " ");
        }
        System.out.println("\nElapsed time of generating the table: " + generatingTime + "ms\n" +
                           "Elapsed time of sorting: " + sortedTime + "ms\n" +
                           "Elapsed time of merging: " + mergedTime + "ms\n" +
                           "Elapsed total time: " + totalTime + "ms");
    }
}
