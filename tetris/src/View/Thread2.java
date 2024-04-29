package View;

import View.HomeGame;
import View.Tetris;

import java.io.IOException;

public class Thread2 extends  Thread{
    HomeGame b1;
    Tetris b2;
    String mode;
    public Thread2(HomeGame b1,String mode){
        this.b1=b1;
        this.mode=mode;

    }
    public Thread2(Tetris b2, String mode){
        this.b2=b2;this.mode=mode;
    }

    @Override
    public void run() {
        try {
            System.out.println("mode:"+mode);
            if(b1!=null) {

                b1.dispose();

                new Tetris(mode);
            }else{
                b2.dispose();
                b2.p.sys.isPause=true;
                b2.p.sys.isReload=true;
                new Tetris("new");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
