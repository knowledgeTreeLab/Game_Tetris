package View;

import View.BlockkDecorate;

public class Thread1 extends  Thread{
    BlockkDecorate b1;
    public Thread1(BlockkDecorate b1){
        this.b1=b1;

    }

    @Override
    public void run() {
        b1.work();
    }
}
