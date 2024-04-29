package Control;

import View.Score;
import model.Database;

import java.util.Random;


//Realwidth=2+11+2=15;
//RealHeight=3+20+2=25;
public class Box {
    public Point B[][];

    public Box() {
        B = new Point[27][15];
        for (int i = 0; i < 27; i++) {
            B[i] = new Point[15];
            for (int j = 0; j < 15; j++) {
                B[i][j] = new Point(i, j);
                B[i][j].color="pray";
                B[i][j].value = 8;

            }
        }
    }
    public void setLocationForNewShape(Shape t) {
        if(t.styleOfShape.equals("I")){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    t.s[i][j].x = B[0 + i][6 + j].x;
                    t.s[i][j].y = B[0 + i][6 + j].y;
                    if (t.s[i][j].value == 1) {
                        B[0 + i][6 + j].x = t.s[i][j].x;
                        B[0 + i][6 + j].y = t.s[i][j].y;
                        B[0 + i][6 + j].value = t.s[i][j].value;
                        B[0 + i][6 + j].color = t.s[i][j].color;


                    } else
                        t.s[i][j].value = B[0 + i][6 + j].value;
                    t.s[i][j].color = B[0 + i][6 + j].color;
                }
            }

        }else {


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    t.s[i][j].x = B[1 + i][6 + j].x;
                    t.s[i][j].y = B[1 + i][6 + j].y;
                    if (t.s[i][j].value == 1) {
                        B[1 + i][6 + j].x = t.s[i][j].x;
                        B[1 + i][6 + j].y = t.s[i][j].y;
                        B[1 + i][6 + j].value = t.s[i][j].value;
                        B[1 + i][6 + j].color = t.s[i][j].color;


                    } else
                        t.s[i][j].value = B[1 + i][6 + j].value;
                    t.s[i][j].color = B[1 + i][6 + j].color;
                }
            }
        }

    }
    public void setAgainLocation(Shape t) {
        if(t.styleOfShape.equals("I")){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (t.s[i][j].value == 1) {
                        B[t.s[i][j].x][t.s[i][j].y].x = t.s[i][j].x;
                        B[t.s[i][j].x][t.s[i][j].y].y = t.s[i][j].y;
                        B[t.s[i][j].x][t.s[i][j].y].value = t.s[i][j].value;
                        B[t.s[i][j].x][t.s[i][j].y].color = t.s[i][j].color;

                    }else{
                        if(B[t.s[i][j].x][t.s[i][j].y].value==8)
                            B[t.s[i][j].x][t.s[i][j].y].color="pray";
                    }
                }
            }
        }
        else{
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (t.s[i][j].value == 1) {
                        B[t.s[i][j].x][t.s[i][j].y].x = t.s[i][j].x;
                        B[t.s[i][j].x][t.s[i][j].y].y = t.s[i][j].y;
                        B[t.s[i][j].x][t.s[i][j].y].value = t.s[i][j].value;
                        B[t.s[i][j].x][t.s[i][j].y].color = t.s[i][j].color;

                    } else {
                        if (B[t.s[i][j].x][t.s[i][j].y].value == 8)
                            B[t.s[i][j].x][t.s[i][j].y].color = "pray";
                    }
                }
            }
        }
    }
    public void overrideAllLineAbove(Score cs) {
        int temp=0;int sum=0;

        //if(checkFullALine(22)==false)return;
        for(int i=23;i>=4;i--){

                if(checkFullALine(i)==true){
                    collasp(i);
                    i++;
                    //System.exit(0);
                    temp++;

                }

        }

        cs.line+=temp;
        for(int i=1;i<=temp;i++){
            sum+=i*20;
        }
        cs.score+=sum;
    }
    public void collasp(int index){
        for(int i=index;i>2;i--){
            for(int j=2;j<13;j++) {
                B[i][j].value=B[i-1][j].value;
                B[i][j].color=B[i-1][j].color;
            }
        }
    }
    public boolean checkLose(){

        for(int i=2;i<13;i++) {
            if (B[3][i].value == 6) {
                //System.exit(0);
                return true;
            }
        }
        return false;
    }
    public void save(){
        Database d=new Database();
        d.saveBox2File(this);
    }

    private boolean checkFullALine(int index){

        for(int j=2;j<13;j++){
            if(B[index][j].value!=6)return false;
        }
        for(int j=2;j<13;j++){

        }
        return true;

    }
}
