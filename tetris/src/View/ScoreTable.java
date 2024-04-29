package View;

import Control.system;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreTable extends JPanel {
    public Score cs;
    public JLabel textName[];
    public JTextField textValue[];
    public ScoreTable(Score temp,String mode){
        System.out.println("hello");
        setBackground(Color.pink);
        setBounds(525,525,300,200);

        initAllValue(temp,mode);
        setVisible(true);
        setLayout(new GridLayout(8,1));


    }


    public void initAllValue(Score temp, String mode){

            cs = new Score();

        textName=new JLabel[4];
        textName[0]=new JLabel("View.Score:", SwingConstants.CENTER);
        //textName[0].setVerticalAlignment(SwingConstants.CENTER);

        textName[1]=new JLabel("level:", SwingConstants.CENTER);
        textName[2]=new JLabel("line:", SwingConstants.CENTER);
        textName[3]=new JLabel("Time:", SwingConstants.CENTER);
        textValue=new JTextField[4];
        for(int i=0;i<4;i++){
            textValue[i]=new JTextField(200);
            textValue[i].setEditable(false);
            textValue[i].setHorizontalAlignment(JTextField.CENTER);
        }
        add(textName[0]);
        add(textValue[0]);
        add(textName[1]);
        add(textValue[1]);
        add(textName[2]);
        add(textValue[2]);
        add(textName[3]);
        add(textValue[3]);
        reloadScoreTable(temp);
        textValue[3].setText("0:0:0");
        if(mode.equals("continue")) loadScore();
        new Thread3(this).start();

    }
    public void reloadScoreTable(Score temp){

            textValue[0].setText(String.valueOf(cs.score) + " (record:" + temp.score + ")");
            textValue[1].setText(String.valueOf(cs.level) + " (record:" + temp.level + ")");
            textValue[2].setText(String.valueOf(cs.line) + " (record:" + temp.line + ")");

            double dive = cs.score / 100;
            dive = Math.round(dive);
            cs.level=(int)dive+1;
            textValue[1].setText(String.valueOf((int) dive + 1) + " (record:" + temp.level + ")");


            if(cs.score>temp.score){
                textValue[0].setText(String.valueOf(cs.score) + " (new record)");
            }
            if(dive+1>temp.level){

                textValue[1].setText(String.valueOf((int) dive + 1) + " (new record)");
            }
            if(cs.line>temp.line) {
                textValue[2].setText(String.valueOf(cs.line) + " (new record)");

            }





    }
    public void saveScore(){
        system s = new system("new");
        s.saveScore(this);
    }
    public void loadScore(){
        system s = new system("new");
        s.loadScore(this);
    }

}
