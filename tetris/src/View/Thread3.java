package View;

import View.ScoreTable;

public class Thread3 extends Thread{
    ScoreTable t;
    public Thread3(ScoreTable t){

        this.t=t;

    }

    @Override
    public void run() {
        try {
            while(true) {
                t.cs.time.countTime();
                t.textValue[3].setText(String.valueOf(t.cs.time.toString()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
