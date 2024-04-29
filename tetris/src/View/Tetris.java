package View;

import Control.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

public class Tetris extends JFrame implements KeyListener,ActionListener {
    private final int blockSize = 35;
    private final int boardWidth = 11, boardHeight = 20;

    public Game p;
    public futureTable ft;
    public ScoreTable st;
    public JLabel pause;
    public Score hightRecord;
    String [][]showingContent;
    JButton toolButton[];
    public Tetris(String mode) throws IOException {
        decoration();
        CreateTool();
        pause=new JLabel("Mode:Playing");
        pause.setBounds(765,5,150,60);
        pause.setFont(new Font("Serif", Font.PLAIN, 20));
        pause.setVisible(false);
        add(pause);

        int n=readHighestRecord();


        setVisible(true);
        setResizable(false);
        ft = new futureTable();
        st = new ScoreTable(hightRecord,mode);
        Score record=new Score();
        if(st!=null)add(st);
        if(ft!=null) add(ft);
        p=new Game(mode);
        //this.t2=t2;

        if(p!=null)add(p);
        p.newGame();
        p.GamePlay(this);
        writeHighestRecord(n);
        p.EndGame();

            System.out.println("xong  game");
            dispose();
            p.sys.mode="new";
            new Tetris(p.sys.mode);




    }


    public void decoration(){
        setLayout(null);
        setLocation(300,30);
        setTitle("Tetris (11x20)");
        JLabel title=new JLabel("NextShape:");
        //title.setSize(40,50);
        title.setFont(new Font("Serif", Font.PLAIN, 30));
        title.setBounds(525,150,200,50);
        add(title);
        JPanel saperation=new JPanel();
        saperation.setBackground(Color.CYAN);
        saperation.setBounds(450,1,20,1000);
        add(saperation);


        getContentPane().setBackground(Color.GRAY);
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);



    }
    public void CreateTool(){
        toolButton=new JButton[4];
        toolButton[0]=new JButton(new ImageIcon("..\\tetris\\src\\picture\\home.png"));
        toolButton[0].setBounds(525,25,60,50);
        add(toolButton[0]);

        toolButton[1]=new JButton(new ImageIcon("..\\tetris\\src\\picture\\reload.png"));
        toolButton[1].setBounds(605,25,60,50);
        add(toolButton[1]);

        toolButton[2]=new JButton(new ImageIcon("..\\tetris\\src\\picture\\pause.png"));
        toolButton[2].setBounds(685,25,60,50);
        add(toolButton[2]);

        toolButton[3]=new JButton(new ImageIcon("..\\tetris\\src\\picture\\feedback.png"));
        toolButton[3].setBounds(765,25,60,50);
        add(toolButton[3]);

        for(int i=0;i<4;i++){
            toolButton[i].addActionListener(this);
            toolButton[i].setFocusable(false);
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==toolButton[0]){

            p.gamePause();

            this.dispose();
            try {
                new HomeGame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==toolButton[1]){
            if(p.sys.isPause!=false)
                new Thread2(this,"new").start();
            else{
                p.sys.isEnd=true;
                p.sys.isReload=true;

            }

        }else if(e.getSource()==toolButton[2]){
            if (pause.getText().equals("Mode:Playing")) {
                pause.setText("Model:Pause");
                toolButton[2].setIcon(new ImageIcon("..\\tetris\\src\\picture\\continue.png"));
                p.gamePause();
            } else {
                pause.setText("Mode:Playing");
                p.gameResume();
                toolButton[2].setIcon(new ImageIcon("..\\tetris\\src\\picture\\pause.png"));
            }
        }else if(e.getSource()==toolButton[3]){

            p.save();
            st.saveScore();
        }

    }
                    @Override
                    public void keyPressed(KeyEvent e) {




                        int checkMoveKey=0;
                        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                            if(p.sys.listShape[0]==null|| p.sys.t.checkLose()==true ||p.sys.isPause==true)return;
                            p.sys.moveShape("LEFT");
                            p.reloadMap();
                        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                            if(p.sys.listShape[0]==null|| p.sys.t.checkLose()==true ||p.sys.isPause==true)return;
                            p.sys.moveShape("RIGHT");
                            p.reloadMap();
                        } else if (e.getKeyCode() == KeyEvent.VK_W|| e.getKeyCode() == KeyEvent.VK_UP) {
                            if(p.sys.listShape[0]==null|| p.sys.t.checkLose()==true||p.sys.isPause==true)return;
                            p.sys.moveShape("TURN");
                            p.reloadMap();
                        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {

                            if(p.sys.listShape[0]==null|| p.sys.t.checkLose()==true||p.sys.isPause==true)return;


                            checkMoveKey = p.sys.moveShape("DOWN");
                            p.reloadMap();
                            if (checkMoveKey == 0) {

                            }
                        }else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                            do{
                            if(p.sys.listShape[0]==null|| p.sys.t.checkLose()==true ||p.sys.isPause==true)return;
                            checkMoveKey = p.sys.moveShape("DOWN");
                            p.reloadMap();
                            if (checkMoveKey == 0) {
                                break;
                            }
                            }while(checkMoveKey!=0);
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_P) {

                            if (pause.getText().equals("Mode:Playing")) {
                                pause.setText("Model:Pause");
                                toolButton[2].setIcon(new ImageIcon("..\\tetris\\src\\picture\\continue.png"));
                                p.gamePause();
                            } else {
                                pause.setText("Mode:Playing");
                                p.gameResume();
                                toolButton[2].setIcon(new ImageIcon("..\\tetris\\src\\picture\\pause.png"));
                            }
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_L){
                            if(p.sys.isPause!=false) {
                                this.dispose();
                                p.sys.mode = "new";
                                new Thread2(this, "new").start();
                            }

                            else{
                                p.sys.isEnd=true;
                                p.sys.isReload=true;

                            }


                        }
                        else if (e.getKeyCode() == KeyEvent.VK_O){

                            p.gameResume();

                            this.dispose();
                            try {
                                new HomeGame();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }


                        }
                    }

                    @Override
                    public void keyTyped(KeyEvent e) {
                        //System.out.println("an roi");
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        //System.out.println("an roi");
                    }

    public int readHighestRecord() throws FileNotFoundException {
        int n=0;

        Vector record=new Vector<String>();

        File myObj = new File("..\\tetris\\Record.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
         //   System.out.println(data);
            record.add(data);
            n++;
        }
        hightRecord=new Score();
        if(n==0){
            hightRecord.score=0;
            hightRecord.level= 1;
            hightRecord.line= 0;
            return 0;
        }


         showingContent=new String[n][4];
        String temp[];
        int max=0;
        int index=0;
        for(int i=0;i<n;i++){

            showingContent[i]=String.valueOf(record.get(i)).split(" ");
            if(Integer.valueOf(String.valueOf(showingContent[i][1])) >max){
                max=Integer.valueOf(String.valueOf(showingContent[i][1]));
                hightRecord.score=Integer.valueOf(String.valueOf(showingContent[i][1]));
                hightRecord.level= Integer.valueOf(String.valueOf(showingContent[i][2]));
                hightRecord.line= Integer.valueOf(String.valueOf(showingContent[i][3]));


            }

        }
       // System.out.println( hightRecord.score+" "+hightRecord.level+" "+ hightRecord.line);
        return n;
        /*JLabel highestScore=new JLabel(String.valueOf(hightRecord.score));
        highestScore.setFont(new Font("Serif", Font.BOLD, 20));
        highestScore.setBounds(525,350,100,50);
        add(highestScore);*/
    }
    public void writeHighestRecord(int n){
        LocalDate myObj = LocalDate.now();
        //System.out.println(n);
        if(n==0){
            try {

                FileWriter myWriter = new FileWriter("..\\tetris\\Record.txt");
                myWriter.write(String.valueOf(myObj)+" "+String.valueOf(st.cs.score)+" "+String.valueOf(st.cs.level)+" "+String.valueOf(st.cs.line));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }else if (n<5){
            try {

                FileWriter myWriter = new FileWriter("..\\tetris\\Record.txt");
                for(int i=0;i<n;i++) {
                    for(int j=0;j<4;j++) {
                        myWriter.write(showingContent[i][j] + " ");
                    }
                    myWriter.write("\n");

                }
                myWriter.write(String.valueOf(myObj)+" "+String.valueOf(st.cs.score)+" "+String.valueOf(st.cs.level+1)+" "+String.valueOf(st.cs.line));

                myWriter.close();
               // System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }else{
            int min=st.cs.score;
            int index=-1;
            for(int i=0;i<n;i++) {
                   if(min>Integer.valueOf(showingContent[i][1])) {
                       min=Integer.valueOf(showingContent[i][1]);
                       index=i;
                   }
            }
            if(min==st.cs.score &&index==-1) return;


            showingContent[index][0]=String.valueOf(myObj);
            showingContent[index][1]=String.valueOf(st.cs.score);
            showingContent[index][2]=String.valueOf( Math.round( st.cs.score / 100)+1);
            showingContent[index][3]=String.valueOf(st.cs.line);
            int temp=0;
            for(int i=0;i<4;i++){
                for(int j=i+1;j<5;j++){
                    if(Integer.valueOf(showingContent[i][1])<Integer.valueOf(showingContent[j][1])){
                        temp=Integer.valueOf(showingContent[i][1]);
                        showingContent[i][1]=showingContent[j][1];
                        showingContent[j][1]=String.valueOf(temp);
                    }
                }
            }
            try {

                FileWriter myWriter = new FileWriter("..\\tetris\\Record.txt");
                for(int i=0;i<5;i++) {
                    for(int j=0;j<4;j++) {
                        myWriter.write(showingContent[i][j] + " ");
                    }
                    myWriter.write("\n");

                }
                myWriter.close();
                // System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }




        }
    }
}










