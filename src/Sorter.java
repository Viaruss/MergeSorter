package Lab3;

import java.util.ArrayList;
public class Sorter extends Thread {
    public ArrayList<Integer> tab;
    int nrWatku;
    int iloscWatkow;
    int len;
    ProgBar bar;
    Sorter(ArrayList<Integer> a, int nr, int n, int lTab, ProgBar b) {
        tab = a;
        nrWatku = nr;
        iloscWatkow = n;
        len = lTab;
        bar = b;
    }

    public void run() {

        bar.bars.get(nrWatku).setValue(0);
        bar.bars.get(nrWatku).setMaximum(len/iloscWatkow);

        int startIndex = nrWatku * (len / iloscWatkow);
        int lastIndex = (nrWatku + 1) * (len / iloscWatkow);
        //if the table can't be split equally - last part gets the remaining elements
        if(nrWatku == iloscWatkow - 1) lastIndex += len % iloscWatkow;
        for (int i = startIndex; i < lastIndex; i++) {
            for (int j = startIndex+1; j < lastIndex; j++) {
                if (tab.get(j-1) > tab.get(j)) {
                    swapValues(tab, j);
                }
            }
            bar.iterate(nrWatku);
        }
    }
    void swapValues(ArrayList<Integer> arr, int j) {
        int temp = arr.get(j-1);
        arr.set(j-1, arr.get(j));
        arr.set(j, temp);
    }
}