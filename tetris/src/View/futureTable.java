package View;

import Control.Point;

import javax.swing.*;
import java.awt.*;

public class futureTable extends JPanel {
    public JLabel STable[][];
    public Control.Point map[][];
    public futureTable(){



        setBackground(Color.BLACK);
        setBounds(525,200,300,200);
        createMap();
        setLayout(new GridLayout(5,9,2,2));



    }
    public void createMap(){
        this.map=new Control.Point[5][9];
        STable=new JLabel[5][9];
        for(int i=0;i<5;i++) {
            STable[i]=new JLabel[9];
            this.map[i] = new Control.Point[9];
            for (int j = 0; j < 9; j++) {
                this.map[i][j] = new Point(i, j,"pray",0);
                map[i][j].color="pray";
                STable[i][j]=new JLabel(" ");
                STable[i][j].setSize(50,50);

                initFutureTableBackBround(i,j);
                add(STable[i][j]);
                if(map[i][j]==null)
                    System.out.println("what ");
            }
        }


    }
    public void reloadFutureShapeTable(Control.Shape list1, Control.Shape list2){

        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                map[i][j].color="pray";
                initFutureTableBackBround(i,j);
            }
        }






            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (list1.s[i][j].value == 1) {


                        //  map[1 + i][1 + j].value = list[1].s[i][j].value;
                        map[1 + i][1 + j].color = list1.s[i][j].color;
                        // map[1 + i][1 + j].x = list[1].s[i][j].x;
                        //map[1 + i][1 + j].y = list[1].s[i][j].y;
                    } else {
                        map[i + 1][1 + j].color = "pray";
                    }
                }
            }

        if(list1.styleOfShape.equals("I")) map[4][2].color = list1.s[1][1].color;
        else  map[4][2].color="pray";
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(list2.s[i][j].value==1) {
                 //   map[1 + i][5 + j].value = list[2].s[i][j].value;
                    map[1 + i][5 + j].color = list2.s[i][j].color;
                //    map[1 + i][5 + j].x = list[2].s[i][j].x;
                  //  map[1 + i][5 + j].y = list[2].s[i][j].y;
                }else{
                    map[1 + i][5 + j].color ="pray";
                }
            }
        }
        if(list2.styleOfShape.equals("I")) map[4][6].color = list2.s[1][1].color;
        else map[4][6].color ="pray";
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                initFutureTableBackBround(i,j);
            }
        }
    }
    public void initFutureTableBackBround( int i,int j){

        STable[i][j].setOpaque(true);

        if (map[i][j].color.equals("pray"))//new Color(131, 131, 131)
            STable[i][j].setBackground(Color.black);
        else if(map[i][j].color.equals("red"))
            STable[i][j].setBackground(new Color(240, 15, 54));
        else if(map[i][j].color.equals("yellow"))
            STable[i][j].setBackground(new Color(255, 255, 0));
        else if(map[i][j].color.equals("green"))
            STable[i][j].setBackground(new Color(9, 247, 26));
        else if(map[i][j].color.equals("blue"))
            STable[i][j].setBackground(new Color(9, 205, 247));
        else if(map[i][j].color.equals("purple"))
            STable[i][j].setBackground(new Color(121, 7, 248));
        else if(map[i][j].color.equals("pink"))
            STable[i][j].setBackground(new Color(255, 70, 255));
        else if(map[i][j].color.equals("orange"))
            STable[i][j].setBackground(new Color(255, 128, 0));


    }
    public void reloadMap(){
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                STable[i][j].setOpaque(true);
                STable[i][j].setBackground(Color.black);
            }
        }
    }



}
