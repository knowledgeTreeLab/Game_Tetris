package View;

import Control.*;
import Control.Shape;
import View.Tetris;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Game extends JPanel {
    private final int blockSize = 35;
    private final int boardWidth = 11, boardHeight = 20;
    public JLabel block[][];
    public system sys;

    public Game(String mode) {



        this.setBackground(Color.black);
        this.setBounds(40,30,blockSize*boardWidth,blockSize*boardHeight);
        this.setLayout(new GridLayout(20,11,1,1));

        //newGame();

        setVisible(true);
        sys=new system(mode);

        if(sys.mode.equals("continue")) {
            try {
                loadShapeSaved();
                // System.exit(0);
            } catch (Exception e) {

            }
        }


        }

    public void initGameBackBround(int i, int j, Control.Point t){
        block[i][j].setOpaque(true);
        if (t.color.equals("pray"))//new Color(131, 131, 131)
            block[i][j].setBackground(Color.black);
        else if(t.color.equals("red"))
            block[i][j].setBackground(new Color(240, 15, 54));
        else if(t.color.equals("yellow"))
            block[i][j].setBackground(new Color(255, 255, 0));
        else if(t.color.equals("green"))
            block[i][j].setBackground(new Color(9, 247, 26));
        else if(t.color.equals("blue"))
            block[i][j].setBackground(new Color(9, 205, 247));
        else if(t.color.equals("purple"))
            block[i][j].setBackground(new Color(121, 7, 248));
        else if(t.color.equals("pink"))
            block[i][j].setBackground(new Color(255, 70, 255));
        else if(t.color.equals("orange"))
            block[i][j].setBackground(new Color(255, 128, 0));


    }
    public void reloadMap(){



        for(int i=4;i<24;i++){
            for(int j=2;j<13;j++) {
                block[i-4][j-2].setText(" ");
                // System.out.print(t.B[i][j].color+"  ");

                initGameBackBround(i - 4, j - 2, sys.t.B[i][j]);
            }
            // System.out.println();
        }
        //System.out.println();


        /*public void connectLocalandBox(){*/

    }
    public void newGame() {

        sys.t=new Control.Box();
        if(sys.mode.equals("continue")) {
            try {
                loadBoxSaved();
            }catch(Exception e){
            }

        }
        block = new JLabel[20][11];
        for (int i = 0; i < 20; i++) {
            block[i] = new JLabel[11];
            for (int j = 0; j < 11; j++) {
                block[i][j] = new JLabel(/*String.valueOf(i)+","+String.valueOf(j)*/);
                block[i][j].setSize(50, 50);
                //System.out.println()

                initGameBackBround(i, j, sys.t.B[i][j]);
                add(block[i][j]);
                //block[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }






    }
    public void EndGame() {
        try {
            for (int k = 0; ; k++) {
                if (k % 2 == 0) {
                    for (int i = 4; i < 24; i++) {
                        for (int j = 2; j < 13; j++) {
                            if(sys.isEnd==true)return;
                            if (sys.t.B[i][j].value == 6) block[i-4][j-2].setBackground(new Color(255, 255, 0));
                        }
                    }
                    TimeUnit.MILLISECONDS.sleep(200);} else {
                    for (int i = 4; i < 24; i++) {
                        for (int j = 2; j < 13; j++) {
                            if(sys.isEnd==true)return;
                            if (sys.t.B[i][j].value == 6) block[i-4][j-2].setBackground(new Color(9, 247, 26));
                        }
                    }

                    TimeUnit.MILLISECONDS.sleep(200);
                    for (int i = 4; i < 24; i++) {
                        for (int j = 2; j < 13; j++) {
                            if(sys.isEnd==true)return;
                            if (sys.t.B[i][j].value == 6) block[i-4][j-2].setBackground(new Color(255, 50, 50));
                        }
                    }

                    TimeUnit.MILLISECONDS.sleep(200);}

            }

        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public boolean GamePlay(Tetris tris) {
        try{
            Shape temp;


            boolean check = false;
            boolean continuee = true;
            if(sys.mode.equals("continue")){
               /* try{
                    loadShapeSaved();
                   // System.exit(0);
                }catch (Exception e){

                }
                mode="null";*/
                sys.t.setAgainLocation(sys.listShape[0]);
                reloadMap();
            }else {

                sys.dice3Shape();
                temp = sys.listShape[0];
            }
            /*for(int i=0;i<3;i++){
                System.out.println(listShape[i].s[1][1].color+" ");
            }*/
            checkPauseGame();

            label: while (continuee == true) {


                temp = sys.listShape[0];
                final int checkMoveKey[] ={10};
                if(!sys.mode.equals("continue")) {
                    sys.t.setLocationForNewShape(temp);

                }
                sys.t.setAgainLocation(temp);
                reloadMap();
                Control.Shape k1=sys.listShape[1];
                Control.Shape k2=sys.listShape[2];
                tris.ft.reloadFutureShapeTable(k1,k2);



                //System.out.println(check);
                while (check != true) {


                    for(int i=sys.speed/100;i<=sys.speed;i+=(sys.speed/100)) {
                        if(sys.isReload==true)return true;

                        checkPauseGame();
                        TimeUnit.MILLISECONDS.sleep(sys.speed/100);
                    }

                    checkMoveKey[0] = temp.move("DOWN",sys.t);
                    //System.out.println("dropping:"+speed);

                    if (checkMoveKey[0] == 0) {
                        sys.t.setAgainLocation(temp);
                        reloadMap();
                        check=sys.t.checkLose();

                        if(check==true){
                          //  System.out.println("what");
                            continuee=false;
                            break label;
                        }
                        sys.t.overrideAllLineAbove(tris.st.cs);
                        tris.st.reloadScoreTable(tris.hightRecord);
                        break;
                    }
                    sys.t.setAgainLocation(temp);
                    reloadMap();



                }
                if(check==true){
                    System.out.println("what");
                    continuee=false;
                    checkPauseGame();
                    break label;
                }
                sys.OverrideShape();
                tris.st.reloadScoreTable(tris.hightRecord);
                if(sys.speed>100)
                    sys.speed=500-20*tris.st.cs.level;
                checkPauseGame();
                sys.mode="new";
            };

            //checkPauseGame();

            return true;
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return true;
    }
    public void checkPauseGame() throws InterruptedException {
        while(sys.isPause==true){
            Thread.sleep(1);
            if(sys.isPause==false)break;
        }

    }
    public void gamePause(){
        sys.gamePause();
    }
    public void gameResume(){
        sys.gameResume();
    }



    //function for saveGAme(Control.Shape)
    public void save(){

        sys.SaveGame();

    }





    public void loadShapeSaved() throws FileNotFoundException {
        (new system(sys.mode)).loadShapeSaved(sys.listShape);


    }


    public void loadBoxSaved() throws FileNotFoundException {

        (new system(sys.mode)).loadBoxSaved(sys.t);
    }
}
