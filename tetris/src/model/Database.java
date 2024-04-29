package model;
import Control.*;
import Control.Box;
import Control.Shape;
import View.ScoreTable;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;


public class Database {

    public Database(){

    }
    public void saveBox2File(Box t){
        try {


            FileWriter myWriter = new FileWriter("..\\tetris\\boxDatabase.txt");
            for(int i=0;i<t.B.length;i++){
                for(int j=0;j<t.B[i].length;j++)
                    myWriter.write(String.valueOf(t.B[i][j].value)+","+t.B[i][j].color+" ");
                myWriter.write("\n");
            }



            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch(Exception E){
            System.out.println(E);
        }
    }

    public String saveShape2File(Shape t) {
        return "";
    }

    public void saveListShape(Shape listShape[]){

        try {


            FileWriter myWriter = new FileWriter("..\\tetris\\shapeDatabase.txt");
            for(int i=0;i<3;i++)
                myWriter.write(listShape[i].getStyleOfShapeToSave()+" ");
            myWriter.write("\n");

            for(int i=0;i<listShape[0].s.length;i++){
                for(int j=0;j<listShape[0].s[i].length;j++)
                    myWriter.write(String.valueOf(listShape[0].s[i][j].x)+","+String.valueOf(listShape[0].s[i][j].y)+","+String.valueOf(listShape[0].s[i][j].value)+","+String.valueOf(listShape[0].s[i][j].color+" "));
                myWriter.write("\n");
            }


            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void LoadHistory(JPanel saperation[], JLabel content[][], int n){
        try {
            FileWriter myWriter = new FileWriter("..\\tetris\\Record.txt");
            myWriter.write("");
            myWriter.close();
            // System.out.println("Successfully wrote to the file.");
            for(int i=0;i<3;i++){
                saperation[i].setBounds(260+180*i,250,10,50*1);
            }

            for(int i=1;i<n;i++){
                for(int j=0;j<4;j++){
                    content[i][j].setText(" ");

                }

            }

                       /* content[0][0].setText("Date");
                        content[0][1].setText("View.Score");
                        content[0][2].setText("level");
                        content[0][3].setText("Line");*/


            FileWriter myWriter2 = new FileWriter("..\\tetris\\boxDatabase.txt");
            myWriter2.write("");
            myWriter2.close();

            FileWriter myWriter3 = new FileWriter("..\\tetris\\scoreDatabase.txt");
            myWriter3.write("");
            myWriter3.close();

            FileWriter myWriter4 = new FileWriter("..\\tetris\\shapeDatabase.txt");
            myWriter4.write("");
            myWriter4.close();

            // System.out.println("Successfully wrote to the file.");
        } catch (IOException e1) {
            System.out.println("An error occurred.");
            e1.printStackTrace();
        }

    }
    public void readRecord(Vector record) throws FileNotFoundException {
        int n = 0;
        File myObj = new File("..\\tetris\\Record.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            // System.out.println(data);
            record.add(data);
            n++;
        }
    }
    public void saveScore(ScoreTable tb){
        try {
            FileWriter myWriter = new FileWriter("..\\tetris\\scoreDatabase.txt");

            myWriter.write( String.valueOf(tb.cs.score)+" "+String.valueOf(tb.cs.level)+" "+String.valueOf(tb.cs.line)+" "+String.valueOf(tb.cs.time));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadScore(ScoreTable tb){
        try{
            File myObj = new File("..\\tetris\\scoreDatabase.txt");
            String []temp;
            Scanner myReader = new Scanner(myObj);
            myReader.hasNextLine();
            String data = myReader.nextLine();
            temp=data.split(" ");

            tb.cs.score=Integer.valueOf(temp[0]);
            tb.cs.level=Integer.valueOf(temp[1]);
            tb.cs.line=Integer.valueOf(temp[2]);

            String []timedata=temp[3].split(":");
            tb.cs.time.hour=Integer.valueOf(timedata[0]);
            tb.cs.time.minute=Integer.valueOf(timedata[1]);
            tb.cs.time.seconds=Integer.valueOf(timedata[2]);
            tb.textValue[3].setText(String.valueOf( tb.cs.time.hour)+":"+String.valueOf( tb.cs.time.minute)+":"+String.valueOf( tb.cs.time.seconds));

        }catch (IOException e){

        }
    }


    public Vector<String> readShapeInSaveFile() throws FileNotFoundException {
        Control.Shape saveList[]=new Shape[3];
        Vector<String> allLine=new Vector<String>();
        File myObj = new File("..\\tetris\\shapeDatabase.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            allLine.add(data);

        }
        return allLine;
    }
    public void getTypeOfShape(String input,int i,Shape listShape[]){

        if(input.equals("I")) listShape[i]=new Shape("I");
        else if(input.equals("J")) listShape[i]=new Shape("J");
        else if(input.equals("L")) listShape[i]=new Shape("L");
        else if(input.equals("O")) listShape[i]=new Shape("O");
        else if(input.equals("S")) listShape[i]=new Shape("S");
        else if(input.equals("T")) listShape[i]=new Shape("T");
        else  listShape[i]=new Shape("Z");

        //  System.out.println(listShape[i].s[1][1].color);




    }

    public void loadShapeSaved(Shape listShape[]) throws FileNotFoundException {
        Vector<String> allLine=readShapeInSaveFile();
        String []tempData=allLine.get(0).split(" ");
        // System.out.println("----------------- "+tempData.length);
        // System.out.println(tempData[0]+" "+tempData[1]+" "+tempData[2]+ " ");
        for(int i=0;i<3;i++) {
            //  System.out.println("----------------- "+i);
            getTypeOfShape(tempData[i],i,listShape);

        }
        int n=allLine.size();
        for(int i=1;i<n;i++){
            tempData=allLine.get(i).split(" ");
            for(int j=0;j<tempData.length;j++){
                String temp[]=tempData[j].split(",");
                listShape[0].s[i-1][j].x=Integer.parseInt(temp[0]);
                listShape[0].s[i-1][j].y=Integer.parseInt(temp[1]);
                listShape[0].s[i-1][j].value=Integer.parseInt(temp[2]);
                listShape[0].s[i-1][j].color=temp[3];
                // System.out.print( listShape[0].s[i-1][j].x+","+ listShape[0].s[i-1][j].y+","+ listShape[0].s[i-1][j].value+","+ listShape[0].s[i-1][j].color+" ");


            }
            // System.out.println("");
        }


    }

    public Vector<String> readBoxInSaveFile() throws FileNotFoundException {

        Vector<String> allLine=new Vector<String>();
        File myObj = new File("..\\tetris\\boxDatabase.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            allLine.add(data);
        }
        return allLine;
    }
    public void loadBoxSaved(Box t) throws FileNotFoundException {

        Vector<String> allLine=readBoxInSaveFile();
        //System.out.println(allLine.size());
        for(int i=0;i<allLine.size();i++){
            String []tempData=allLine.get(i).split(" ");
            for(int j=0;j<15;j++){
                String temp[]=tempData[j].split(",");
                t.B[i][j].x=i;
                t.B[i][j].y=j;
                t.B[i][j].value=Integer.parseInt(temp[0]);
                t.B[i][j].color=temp[1];

            }

        }
    }

    public boolean checkHistoryEmpty(){
        try {
            File myObj = new File("..\\tetris\\boxDatabase.txt");
            Scanner myReader = new Scanner(myObj);
            //myReader.hasNextLine();
            if(!myReader.hasNextLine()){
                return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

}
