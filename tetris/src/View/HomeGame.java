package View;

import Control.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

public class HomeGame extends JFrame implements ActionListener{
    JButton homeButton[],back[];
    JPanelForHome tutorial,history,gamePlay;
    BlockkDecorate p1;
    JPanelFunction panel;
    Image img = Toolkit.getDefaultToolkit().getImage("..\\tetris\\src\\picture\\background.jpg");
    public HomeGame() throws IOException {

        panel = new JPanelFunction(
                new ImageIcon(img).getImage());
        setLayout(null);
        setLocation(300,30);
        getContentPane().add(panel);
        pack();
        setVisible(true);
        CreateButton(panel);
        createPanelForHome();

        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        CreateTutorial();
        CreateHistory();
        CreateGamePlay();


    }
    public void CreateButton(JPanelFunction temp){
        JLabel welcome=new JLabel("Welcome to Tetris!");
        welcome.setFont(new Font("Serif", Font.BOLD, 50));
        welcome.setBounds(250,25,500,200);
        temp.add(welcome);
        homeButton=new JButton[4];
        for(int i=0;i<4;i++) {
            homeButton[i] = new JButton(String.valueOf(i));
            homeButton[i].setBackground(new Color(149, 121, 164));
            homeButton[i].addActionListener(this);
            homeButton[i].setFocusable(false);

        }
        homeButton[0].setText("Play");
        homeButton[1].setText("Tutorial");
        homeButton[2].setText("History");
        homeButton[3].setText("GanePlay");



        homeButton[0].setBounds(75,300,300,50);
        homeButton[1].setBounds(75,375,300,50);
        homeButton[2].setBounds(75,450,300,50);
        homeButton[3].setBounds(75,525,300,50);
        for(int i=0;i<4;i++)
            temp.add(homeButton[i]);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==homeButton[0]){

            try {
                //this.setVisible(false);
                system s=new system("new");
                if(!s.checkHistoryEmpty()) {
                    int t = JOptionPane.showConfirmDialog(this, "would you want to play save version ?");

                    if (t == JOptionPane.OK_OPTION) {
                        new Thread2(this, "continue").start();
                    } else {
                        new Thread2(this, "new").start();
                    }
                }else{
                    new Thread2(this, "new").start();
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==homeButton[1]){

                tutorial.setVisible(true);


                panel.setVisible(false);
                history.setVisible(false);
                gamePlay.setVisible(false);


        }else if(e.getSource()==homeButton[2]){


            tutorial.setVisible(false);
            panel.setVisible(false);
            history.setVisible(true);
            gamePlay.setVisible(false);
        }else if(e.getSource()==homeButton[3]){

            tutorial.setVisible(false);
            panel.setVisible(false);
            history.setVisible(false);
            gamePlay.setVisible(true);
            //p1.work();
            new Thread1(p1).start();





        }else if(e.getSource()==back[0]||e.getSource()==back[1]||e.getSource()==back[2]){
            tutorial.setVisible(false);
            panel.setVisible(true);
            history.setVisible(false);
            gamePlay.setVisible(false);
            //p1.checkend=true;

        }

    }
    public void createPanelForHome(){
        back=new JButton[3];
        tutorial=new JPanelForHome("Tutorial!");
        add(tutorial);
        history=new JPanelForHome("Playing History ");
        add(history);
        gamePlay=new JPanelForHome("How to play?");
        p1=new BlockkDecorate();
        gamePlay.add(p1);
        add(gamePlay);
        back[0]=new JButton(new ImageIcon("..\\tetris\\src\\picture\\home.png"));
        back[0].setBounds(250,100,60,50);
         back[1]=new JButton(new ImageIcon("..\\tetris\\src\\picture\\home.png"));
        back[1].setBounds(250,100,60,50);
         back[2]=new JButton(new ImageIcon("..\\tetris\\src\\picture\\home.png"));
        back[2].setBounds(250,100,60,50);
        tutorial.add(back[0]);
        history.add(back[1]);
        gamePlay.add(back[2]);
        back[0].addActionListener(this);
        back[1].addActionListener(this);
        back[2].addActionListener(this);


    }
    public void CreateTutorial(){
        JLabel Howtoplay=new JLabel("Control buttons:");
        Howtoplay.setBounds(100,200,500,50);
        Howtoplay.setFont(new Font("Tahoma", Font.BOLD, 25));
        tutorial.add(Howtoplay);
        JLabel moveUp=new JLabel("   w");
        JLabel moveDown=new JLabel("   s");
        JLabel moveLeft=new JLabel("   a");
        JLabel moveRight=new JLabel("   d");
        moveUp.setBounds(100,250,50,50);
        moveDown.setBounds(100,300,50,50);
        moveLeft.setBounds(100,350,50,50);
        moveRight.setBounds(100,400,50,50);

        JLabel moveUp1=new JLabel("   ^");
        JLabel moveDown1=new JLabel("   v");
        JLabel moveLeft1=new JLabel("   <");
        JLabel moveRight1=new JLabel("   >");
        moveUp1.setBounds(150,250,50,50);
        moveDown1.setBounds(150,300,50,50);
        moveLeft1.setBounds(150,350,50,50);
        moveRight1.setBounds(150,400,50,50);

        moveDown.setFont(new Font("Serif", Font.BOLD, 25));
        moveDown1.setFont(new Font("Serif", Font.PLAIN, 25));
        moveLeft.setFont(new Font("Serif", Font.BOLD, 25));
        moveLeft1.setFont(new Font("Serif", Font.BOLD, 25));
        moveRight.setFont(new Font("Serif", Font.BOLD, 25));
        moveRight1.setFont(new Font("Serif", Font.BOLD, 25));
        moveUp.setFont(new Font("Serif", Font.BOLD, 25));
        moveUp1.setFont(new Font("Serif", Font.BOLD, 25));

        moveDown.setBorder(BorderFactory.createLineBorder(Color.black));
        moveDown1.setBorder(BorderFactory.createLineBorder(Color.black));
        moveLeft.setBorder(BorderFactory.createLineBorder(Color.black));
        moveLeft1.setBorder(BorderFactory.createLineBorder(Color.black));
        moveRight.setBorder(BorderFactory.createLineBorder(Color.black));
        moveRight1.setBorder(BorderFactory.createLineBorder(Color.black));
        moveUp.setBorder(BorderFactory.createLineBorder(Color.black));
        moveUp1.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel moveUp2=new JLabel("  : Turn current Control.Shape from left to right");
        JLabel moveDown2=new JLabel("  :  Move 1 cube to bottom ");
        JLabel moveLeft2=new JLabel("  :  Move 1 cube to left");
        JLabel moveRight2=new JLabel("  :  Move 1 cube to Right");
        moveUp2.setBounds(200,250,500,50);
        moveDown2.setBounds(200,300,500,50);
        moveLeft2.setBounds(200,350,500,50);
        moveRight2.setBounds(200,400,500,50);

        moveDown2.setFont(new Font("Serif", Font.BOLD, 25));
        moveLeft2.setFont(new Font("Serif", Font.BOLD, 25));
        moveRight2.setFont(new Font("Serif", Font.BOLD, 25));
        moveUp2.setFont(new Font("Serif", Font.BOLD, 25));




        tutorial.add(moveUp);
        tutorial.add(moveDown);
        tutorial.add(moveLeft);
        tutorial.add(moveRight);

        tutorial.add(moveUp1);
        tutorial.add(moveDown1);
        tutorial.add(moveLeft1);
        tutorial.add(moveRight1);

        tutorial.add(moveUp2);
        tutorial.add(moveDown2);
        tutorial.add(moveLeft2);
        tutorial.add(moveRight2);

        JLabel space=new JLabel("  Space  ");
        space.setBounds(100,450,100,50);
        space.setFont(new Font("Serif", Font.BOLD, 25));
        space.setBorder(BorderFactory.createLineBorder(Color.black));
        tutorial.add(space);
        JLabel space1=new JLabel("  :  Move to bottom immediately");
        space1.setFont(new Font("Serif", Font.BOLD, 25));
        space1.setBounds(200,450,500,50);
        tutorial.add(space1);


        JLabel Howtoplay1=new JLabel("Setting buttons:");
        Howtoplay1.setBounds(100,525,500,50);
        Howtoplay1.setFont(new Font("Tahoma", Font.BOLD, 25));
        tutorial.add(Howtoplay1);

        JLabel pauseButton=new JLabel("  :  Pause game immediately");
        JLabel reGameButton=new JLabel("  :  Play a new game");


        pauseButton.setBounds(200,575,500,50);
        reGameButton.setBounds(200,625,500,50);


        pauseButton.setFont(new Font("Serif", Font.BOLD, 25));
        reGameButton.setFont(new Font("Serif", Font.BOLD, 25));
        tutorial.add(pauseButton);
        tutorial.add(reGameButton);

        JLabel pauseButton1=new JLabel("P");
        JLabel reGameButton1=new JLabel("L");
        pauseButton1.setBounds(125,575,50,50);
        reGameButton1.setBounds(125,625,50,50);
        pauseButton1.setFont(new Font("Serif", Font.BOLD, 25));
        reGameButton1.setFont(new Font("Serif", Font.BOLD, 25));

        pauseButton1.setBorder(BorderFactory.createLineBorder(Color.black));
        reGameButton1.setBorder(BorderFactory.createLineBorder(Color.black));

        tutorial.add(pauseButton1);
        tutorial.add(reGameButton1);

    }
    public void CreateHistory()throws FileNotFoundException{
        Vector record=new Vector<String>();
        readRecord(record);
        int n=1+record.size();


        //System.out.println(n);
        JLabel content[][]=new JLabel[n][4];
        for(int i=0;i<n;i++){
            content[i]=new JLabel[4];
            for(int j=0;j<4;j++){
                content[i][j]=new JLabel(String.valueOf(i)+"/"+String.valueOf(j));
                content[i][j].setBounds(135+j*175,250+50*i,500,50);
                content[i][j].setFont(new Font("Serif", Font.BOLD, 25));
                history.add(content[i][j]);
            }

        }

        content[0][0].setText("Date");
        content[0][1].setText("Score");
        content[0][2].setText("level");
        content[0][3].setText("Line");
        if(n==1) return;



        JPanel saperation[]=new JPanel[3];
        for(int i=0;i<3;i++) {
            saperation[i]=new JPanel();
            saperation[i].setBackground(Color.white);
            saperation[i].setBounds(260+180*i,250,10,50*n);
            history.add(saperation[i]);
        }

        String showingContent[][]=new String[n-1][4];
        String temp[];
        for(int i=0;i<n-1;i++){
            showingContent[i]=new String[4];
            showingContent[i]=String.valueOf(record.get(i)).split(" ");
            for(int j=0;j<4;j++){
                content[1+i][j].setText(showingContent[i][j]);
            }
        }

        JButton clear=new JButton("ClearHistory");
        //clear.setVisible(true);
        clear.setBounds(320,275+n*50,200,50);
        history.add(clear);
        System.out.println(n);
        if(n==1)clear.setVisible(true);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    system s=new system("new");
                    s.LoadHistory(saperation,content,n);


            }
        });



    }
    public void readRecord(Vector record) throws FileNotFoundException {
        system s=new system("new");
        s.readRecord(record);




    }
    public void CreateGamePlay(){
        JLabel text[]=new JLabel[5];
        text[0]=new JLabel("There Are 7 shapes Random Dropping top to bottom");
        text[0].setBounds(50,200,5000,100);
        text[0].setFont(new Font("Arial", Font.BOLD, 20));
        gamePlay.add(text[0]);
        text[1]=new JLabel("full a line will remove that line and you will earn score");
        text[1].setBounds(50,250,5000,100);
        text[1].setFont(new Font("Arial", Font.BOLD, 20));
        gamePlay.add(text[1]);
        text[2]=new JLabel("every 200 score you will up 1 level");
        text[2].setBounds(50,300,5000,100);
        text[2].setFont(new Font("Arial", Font.BOLD, 20));
        gamePlay.add(text[2]);
        text[3]=new JLabel("every 1 level will make dropping speed faster 0,02s ( min:0,5s max 0,1s)");
        text[3].setBounds(50,350,5000,100);
        text[3].setFont(new Font("Arial", Font.BOLD, 20));
        gamePlay.add(text[3]);
        text[4]=new JLabel("this game have no save function but if you pass record it will be save");
        text[4].setBounds(50,400,5000,100);
        text[4].setFont(new Font("Arial", Font.BOLD, 20));
        gamePlay.add(text[4]);

    }
}
