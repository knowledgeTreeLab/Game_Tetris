package Control;

import View.ScoreTable;
import model.Database;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class system {
     Database d;
     public Shape listShape[]=new Shape[3];
    public Box t=new Box();
    public boolean isPause=false,isReload=false, isEnd=false;
    public int speed=500;
    public String mode;
    public system(String mode) {
        d = new Database();
        this.mode=mode;

    }
    public void dice3Shape(){
        Random rd=new Random();
        for(int i=0;i<3;i++){
            listShape[i]=new Shape();
        }
    }
    public void OverrideShape(){

        for(int i=1;i<3;i++){
            listShape[i-1]=  listShape[i];

        }
        listShape[2]=new Shape();

    }
    public int moveShape(String direct){

        if(listShape[0].checkCollisionWhenMove(direct,t)==true) return 0;
        else{

            int returnn=listShape[0].move(direct,t);
            t.setAgainLocation(listShape[0]);
            return returnn;
        }
    }
    public void gamePause(){
        this.isPause=true;
    }
    public void gameResume(){
        this.isPause=false;
    }
    public void saveListShape() {
        d.saveListShape(this.listShape);

    }
    public void SaveGame(){
        saveListShape();
        t.save();
    }
    public void LoadHistory(JPanel saperation[], JLabel content[][], int n) {
        d.LoadHistory(saperation, content, n);

    }
    public void loadShapeSaved(Shape listShape[]) throws FileNotFoundException {
        d.loadShapeSaved(listShape);

    }
    public void loadBoxSaved(Box t) throws FileNotFoundException {
        d.loadBoxSaved(t);
    }

    public void readRecord(Vector record) throws FileNotFoundException {
        d.readRecord(record);
    }
    public void saveScore(ScoreTable tb) {
        d.saveScore(tb);
    }
    public void loadScore(ScoreTable tb) {
        d.loadScore(tb);
    }
    public boolean checkHistoryEmpty() {
        return d.checkHistoryEmpty();
    }


}
