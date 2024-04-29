package View;

import Control.*;
import Control.Shape;


import javax.swing.*;
import java.awt.*;

public class BlockkDecorate extends JPanel {

    public JLabel block[][];

    public BlockkDecorate() {


        setBounds(600, 225, 3 * 50, 3 * 50);
        setVisible(true);
        setLayout(new GridLayout(3, 4, 1, 1));
        init();
        setBackground(Color.BLACK);
        //work();

    }
    public void init(){
        block = new JLabel[3][4];
        for (int i = 0; i < 3; i++) {
            block[i] = new JLabel[4];
            for (int j = 0; j < 4; j++) {

                block[i][j] = new JLabel(" ");

                block[i][j].setSize(51, 51);

                add(block[i][j]);
            }
        }
     /*   JLabel temp=new JLabel(" ");
        temp.setSize(40,40);
        temp.setBackground(Color.red);
        add(temp);*/
    }
    public void work() {

        int load = 0;
        Control.Shape s[] = new Control.Shape[7];
        s[1] = new Shape("T");
        s[0] = new Shape("L");
        s[2] = new Shape("O");
        s[3] = new Shape("J");
        s[4] = new Shape("I");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                s[4].s[i][j].color="pray";
                s[4].s[i][j].value=0;
            }
        }
        for(int i=0;i<4;i++){
            s[4].s[1][i].color="red";
            s[4].s[1][i].value=1;
        }
        s[6] = new Shape("S");
        s[5] = new Shape("Z");
        try {
            for (int o = 0;; o++) {
                if(load==4){
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 4; j++) {
                            initBlockBackBround(i, j, s, load);
                        }
                    }
                }
               else{
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            initBlockBackBround(i, j, s, load);
                        }
                    }
                }
               Thread.sleep(500);
                for(int i1=0;i1<3;i1++)
                    for(int j1=0;j1<4;j1++) {
                        block[i1][j1].setOpaque(true);
                        block[i1][j1].setBackground(Color.black);
                    }

                load++;
                if(load==6)load=0;

            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }

    public void initBlockBackBround(int i, int j, Control.Shape s[], int load){
        block[i][j].setOpaque(true);


        if (s[load].s[i][j].value == 1) {


             if (s[load].s[1][1].color.equals("red"))
                block[i][j].setBackground(Color.red);
            else if (s[load].s[1][1].color.equals("yellow"))
                block[i][j].setBackground(new Color(255, 255, 0));
            else if (s[load].s[1][1].color.equals("green"))
                block[i][j].setBackground(new Color(9, 247, 26));
            else if (s[load].s[1][1].color.equals("blue"))
                block[i][j].setBackground(new Color(9, 205, 247));
            else if (s[load].s[1][1].color.equals("purple"))
                block[i][j].setBackground(new Color(121, 7, 248));
            else if (s[load].s[1][1].color.equals("pink"))
                block[i][j].setBackground(new Color(255, 70, 255));
            else if (s[load].s[1][1].color.equals("orange"))
                block[i][j].setBackground(new Color(255, 128, 0));
            else //new Color(131, 131, 131)
             { System.out.println(i+"/"+j+":"+s[load].s[i][j].color);
                 block[i][i].setBackground(Color.cyan);
             }


        } else {

            block[i][j].setBackground(Color.BLACK);
        }


    }
}

