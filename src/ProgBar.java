package Lab3;

import javax.swing.*;
import java.util.ArrayList;
public class ProgBar extends JFrame{
    int n;
    int len;
    ArrayList<JProgressBar> bars = new ArrayList<>();
    ProgBar(int num, int l){
        n = num;
        len = l;
        for(int i = 0; i < n; i++){
            bars.add(new JProgressBar(0, len/n));
        }
        for (int i = 0; i < bars.size(); i++) {
            bars.get(i).setBounds(40, 40+50*i, 160, 30);
            bars.get(i).setValue(0);
            bars.get(i).setStringPainted(true);
            add(bars.get(i));
        }

        bars.add(new JProgressBar(0, n+(n+2-1)/2));
        bars.get(n).setBounds(40, 50*n+100, 160, 30);
        bars.get(n).setValue(0);
        bars.get(n).setStringPainted(true);
        add(bars.get(n));


        setSize(250,40+50*n+160);
        setLayout(null);
    }
    public void iterate(int num){
            bars.get(num).setValue(bars.get(num).getValue()+1);
    }
}