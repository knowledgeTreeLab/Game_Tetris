package Control;

import java.util.Random;

public class Shape {
    public Point s[][];
    public String styleOfShape;

    public Shape() {
        Random rd = new Random();
        for (int i = 0; i < 3; i++) {
            int n = rd.nextInt(7);
            if (n == 0) shapeIsI();
            else if (n == 1) shapeIsJ();
            else if (n == 2) shapeIsL();
            else if (n == 3) shapeIsO();
            else if (n == 4) shapeIsS();
            else if (n == 5) shapeIsT();
            else shapeIsZ();

        }
    }
    public Shape(String styleOfShape){
        this.styleOfShape=styleOfShape;
        if(styleOfShape.equals("I")){
            shapeIsI();
        } else if(styleOfShape.equals("L")){
            shapeIsL();
        }else if(styleOfShape.equals("J")){
            shapeIsJ();
        }else if(styleOfShape.equals("O")){
            shapeIsO();
        }else if(styleOfShape.equals("T")){
            shapeIsT();
        }else if(styleOfShape.equals("Z")){
            shapeIsZ();
        }else{
            shapeIsS();
        }
    }
    private void shapeIsI(){
       s=new Point [4][4];
       for(int i=0;i<4;i++){
           s[i]=new Point[4];
           for(int j=0;j<4;j++){
               s[i][j]=new Point(i,j);
               s[i][j].value=0;
           }
       }
       s[0][1].value=s[1][1].value=s[2][1].value=s[3][1].value=1;
       s[0][1].color=s[1][1].color=s[2][1].color=s[3][1].color="red";
       styleOfShape="I";
   }
    private void shapeIsJ(){
       s=new Point [3][3];
       for(int i=0;i<3;i++){
           s[i]=new Point[3];
           for(int j=0;j<3;j++){
               s[i][j]=new Point(i,j);
               s[i][j].value=0;
           }
       }
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){

               s[i][j].value=0;
           }
       }
       s[0][1].value=s[1][1].value=s[2][1].value=1;
       s[2][0].value=1;

       s[0][1].color=s[1][1].color=s[2][1].color="orange";
       s[2][0].color="orange";
       styleOfShape="J";
   }
    private void shapeIsL(){

           s=new Point [3][3];
           for(int i=0;i<3;i++){
               s[i]=new Point[3];
               for(int j=0;j<3;j++){
                   s[i][j]=new Point(i,j);
                   s[i][j].value=0;
               }
           }
           for(int i=0;i<3;i++){
               for(int j=0;j<3;j++){

                   s[i][j].value=0;
               }
           }
           s[0][1].value=s[1][1].value=s[2][1].value=1;
           s[2][2].value=1;
           s[0][1].color=s[1][1].color=s[2][1].color="yellow";
           s[2][2].color="yellow";
       styleOfShape="L";
   }
    private void shapeIsO(){
       styleOfShape="O";
       s=new Point [3][3];
       for(int i=0;i<3;i++){
           s[i]=new Point[3];
           for(int j=0;j<3;j++){
               s[i][j]=new Point(i,j);
               s[i][j].value=0;
           }
       }
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){

               s[i][j].value=0;
           }
       }
       s[2][1].value=s[1][1].value=s[2][2].value=1;
       s[1][2].value=1;

       s[2][1].color=s[1][1].color=s[2][2].color="green";
       s[1][2].color="green";
   }
    private void shapeIsS(){
       styleOfShape="S";
       s=new Point [3][3];
       for(int i=0;i<3;i++){
           s[i]=new Point[3];
           for(int j=0;j<3;j++){
               s[i][j]=new Point(i,j);
               s[i][j].value=0;
           }
       }
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){

               s[i][j].value=0;
           }
       }
       s[0][1].value=s[1][0].value=s[1][1].value=1;
       s[2][0].value=1;

       s[0][1].color=s[1][0].color=s[1][1].color="blue";
       s[2][0].color="blue";
   }
    private void shapeIsT(){
       styleOfShape="T";
       s=new Point [3][3];
       for(int i=0;i<3;i++){
           s[i]=new Point[3];
           for(int j=0;j<3;j++){
               s[i][j]=new Point(i,j);
               s[i][j].value=0;
           }
       }
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){

               s[i][j].value=0;
           }
       }
       s[0][0].value=s[0][1].value=s[0][2].value=1;
       s[1][1].value=1;

       s[0][0].color=s[0][1].color=s[0][2].color="purple";
       s[1][1].color="purple";
   }
    private void shapeIsZ(){
       styleOfShape="Z";
        s = new Point[3][3];
       for (int i = 0; i < 3; i++) {
           s[i] = new Point[3];
           for (int j = 0; j < 3; j++) {
               s[i][j] = new Point(i, j);
               s[i][j].value = 0;
           }
       }
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {

               s[i][j].value = 0;
           }
       }
       s[0][0].value = s[1][0].value = s[1][1].value = 1;
       s[2][1].value = 1;

       s[0][0].color = s[1][0].color = s[1][1].color = "pink";
       s[2][1].color = "pink";}
    public boolean checkCollisionWhenMove(String direct,Box t){
        if(direct.equals("LEFT"))return checkCollisionWhenMovingLeft(t);
        else if (direct.equals("RIGHT"))return checkCollisionWhenMovingRight(t);
        else if(direct.equals("DOWN"))return checkCollisionWhenDrop(t);
        else return false;

    }
    public int move(String direct,Box t) {
        if(checkIndeepest())return 0;
        if(direct.equals("LEFT"))return moveLeft(t);
        else if(direct.equals("RIGHT"))return moveRight(t);
        else if(direct.equals("DOWN"))return moveDown(t);
        else if(direct.equals("TURN"))return TurnLR(t);
        return 1;

    }
    public boolean checkIndeepest(){
        if(styleOfShape.equals("I")) {
            if (s[1][1].value == 6 || s[2][1].value == 6 || s[1][2].value == 6 || s[2][2].value == 6) return true;
            return false;
        }
        else{
            if (s[1][1].value == 6) return true;
            return false;
        }
    }

    private int moveRight(Box t){
        if(styleOfShape.equals("I")){
            //if(s[1][1].value==6 ||s[2][1].value==6||s[1][2].value==6 || s[2][2].value==6)return 0;

            boolean check=checkOutOfBox("right");
            if(check==true)return 0;
            check=checkCollisionWhenMovingRight(t);
            if(check==true)return 0;
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){

                    if(t.B[s[i][j].x][s[i][j].y].value==1) {

                        t.B[s[i][j].x][s[i][j].y].value = 8;
                        t.B[s[i][j].x][s[i][j].y].color="pray";

                    }

                }
                //System.out.println();
            }

            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    s[i][j].y++;


                }
                //System.out.println();
            }
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++) {
                    if(s[i][j].value==1){
                        t.B[s[i][j].x][s[i][j].y].value=1;
                        t.B[s[i][j].x][s[i][j].y].color=s[i][j].color;
                    }
                }
            }
            return 1;
        }
        else {
           // if (s[1][1].value == 6) return 0;


            boolean check = checkOutOfBox("right");
            if (check == true) return 0;
            check = checkCollisionWhenMovingRight(t);
            if (check == true) return 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (t.B[s[i][j].x][s[i][j].y].value == 1) {

                        t.B[s[i][j].x][s[i][j].y].value = 8;
                        t.B[s[i][j].x][s[i][j].y].color = "pray";

                    }

                }
                //System.out.println();
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    s[i][j].y++;


                }
                //System.out.println();
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[i][j].value == 1) {
                        t.B[s[i][j].x][s[i][j].y].value = 1;
                        t.B[s[i][j].x][s[i][j].y].color = s[i][j].color;
                    }
                }
            }
            return 1;
        }
    }
    private int moveLeft(Box t){
        if(styleOfShape.equals("I")){
            //if(s[1][1].value==6 ||s[2][1].value==6||s[1][2].value==6 || s[2][2].value==6)return 0;

            boolean check=checkOutOfBox("left");
            if(check==true)return 0;
            check=checkCollisionWhenMovingLeft(t);
            if(check==true)return 0;

            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){

                    if(t.B[s[i][j].x][s[i][j].y].value==1) {

                        t.B[s[i][j].x][s[i][j].y].value = 8;
                        t.B[s[i][j].x][s[i][j].y].color = "pray";

                    }

                }

            }


            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    s[i][j].y--;



                }
                // System.out.println();
            }


            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++) {
                    if(s[i][j].value==1){
                        t.B[s[i][j].x][s[i][j].y].value=1;
                        t.B[s[i][j].x][s[i][j].y].color=s[i][j].color;
                    }
                }
            }

            return 1;
        }
        else {
            //if (s[1][1].value == 6) return 0;

            boolean check = checkOutOfBox("left");
            if (check == true) return 0;
            check = checkCollisionWhenMovingLeft(t);
            if (check == true) return 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (t.B[s[i][j].x][s[i][j].y].value == 1) {

                        t.B[s[i][j].x][s[i][j].y].value = 8;
                        t.B[s[i][j].x][s[i][j].y].color = "pray";

                    }

                }

            }


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    s[i][j].y--;


                }
                // System.out.println();
            }


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[i][j].value == 1) {
                        t.B[s[i][j].x][s[i][j].y].value = 1;
                        t.B[s[i][j].x][s[i][j].y].color = s[i][j].color;
                    }
                }
            }

            return 1;
        }
    }
    private int moveDown(Box t){
        // check ra ngoai cai box cho Control.T Control.I
        if(styleOfShape.equals("I")){
           // if(s[1][1].value==6 ||s[2][1].value==6||s[1][2].value==6 || s[2][2].value==6)return 0;
            // kiem tra ra ngoai chua
            boolean check=checkOutOfBox("down");
            if(check==true) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        if(t.B[s[i][j].x][s[i][j].y].value==1) {
                            t.B[s[i][j].x][s[i][j].y].value = 6;
                            s[i][j].value=6;
                        }

                    }
                }
                return 0;
            }
            check=checkCollisionWhenDrop(t);
            if(check==true){
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){

                        if(t.B[s[i][j].x][s[i][j].y].value==1) {

                            t.B[s[i][j].x][s[i][j].y].value = 6;
                            s[i][j].value=6;
                        }
                    }
                }
                return 0;
            }
            // xet vi tri hien tai cua shape la rong(=8)
            String TempColor="pray";
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if(s[i][j].value==1) {
                        t.B[s[i][j].x][s[i][j].y].value = 8;
                        t.B[s[i][j].x][s[i][j].y].color="pray";
                        TempColor=s[i][j].color;
                        s[i][j].color="pray";
                    }
                }

            }
            //set lai toa do sau khi duy chuyen
            for(int i=0;i<4;i++) {
                for (int j = 0; j < 4; j++) {
                    s[i][j].x++;
                }
            }
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if(s[i][j].value==1){
                        s[i][j].color=TempColor;
                        t.B[s[i][j].x][s[i][j].y].value=s[i][j].value;
                        t.B[s[i][j].x][s[i][j].y].color=TempColor;
                    }

                }
            }
            return 1;
        }
        else {
          //  if (s[1][1].value == 6) return 0;

            // kiem tra ra ngoai chua
            boolean check = checkOutOfBox("down");
            if (check == true) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (t.B[s[i][j].x][s[i][j].y].value == 1) {
                            t.B[s[i][j].x][s[i][j].y].value = 6;
                            s[i][j].value = 6;
                        }
                    }
                }
                return 0;
            }
            check = checkCollisionWhenDrop(t);
            if (check == true) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (t.B[s[i][j].x][s[i][j].y].value == 1) {

                            t.B[s[i][j].x][s[i][j].y].value = 6;
                            s[i][j].value = 6;
                        }
                    }
                }
                return 0;
            }
            // xet vi tri hien tai cua shape la rong(=8)
            String TempColor = "pray";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[i][j].value == 1) {
                        t.B[s[i][j].x][s[i][j].y].value = 8;
                        t.B[s[i][j].x][s[i][j].y].color = "pray";
                        TempColor = s[i][j].color;
                        s[i][j].color = "pray";
                    }
                }
            }

            //set lai toa do sau khi duy chuyen
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    s[i][j].x++;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[i][j].value == 1) {
                        s[i][j].color = TempColor;
                        t.B[s[i][j].x][s[i][j].y].value = s[i][j].value;
                        t.B[s[i][j].x][s[i][j].y].color = TempColor;
                    }

                }
            }
            return 1;
        }
    }
    private int TurnLR(Box b){
        //tao 1 cai shape phu.
        if(styleOfShape.equals("O"))return 0;
        else if(styleOfShape.equals("I")){
            //tao 1 cai shape phu.
          //  if(s[1][1].value==6 ||s[2][1].value==6||s[1][2].value==6 || s[2][2].value==6)return 0;
            Point temp[][] = new Point[4][4];
            int count=0;
            for (int i = 0; i < 4; i++) {
                temp[i] = new Point[4];
                for (int j = 0; j < 4; j++) {
                    temp[i][j] = new Point(s[i][j].x, s[i][j].y);
                    temp[i][j].color=s[i][j].color;
                }
            }
            //thuc hien phep quay
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    temp[j][3-i].value=s[i][j].value;
                    temp[j][3-i].color=s[i][j].color;
                }
            }
            // neu co vat can thi ko cho quay
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if(temp[i][j].y<2 || temp[i][j].y>12)return 0;
                    if( temp[i][j].x>22)return 0;
                    if(temp[i][j].value==1 && b.B[temp[i][j].x][temp[i][j].y].value==6 ){
                        return 0;
                    }
                }
            }
            String color="";
            // neu quay dc thi cho vi tri cu = rong ( =8)
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if( s[i][j].value==1) {
                        b.B[s[i][j].x][s[i][j].y].value = 8;
                        color=s[i][j].color;
                        s[i][j].color="pray";
                        b.B[s[i][j].x][s[i][j].y].color="pray";
                    }

                }
            }
            // set vi tri moi cho shape
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++) {

                    s[i][j].value=temp[i][j].value;
                    s[i][j].color=temp[i][j].color;
                    if(s[i][j].value==1)
                        b.B[s[i][j].x][s[i][j].y].color=color;
                }

            }
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++) {
                    if(s[i][j].value==1){
                        b.B[s[i][j].x][s[i][j].y].value=1;
                        b.B[s[i][j].x][s[i][j].y].color=s[i][j].color;
                    }
                }
            }
            return 1;
        }
        else {
           // if (s[1][1].value == 6) return 0;

            Point temp[][] = new Point[3][3];
            int count = 0;
            for (int i = 0; i < 3; i++) {
                temp[i] = new Point[3];
                for (int j = 0; j < 3; j++) {
                    temp[i][j] = new Point(s[i][j].x, s[i][j].y);
                    temp[i][j].color = s[i][j].color;

                }
            }

            //thuc hien phep quay
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    temp[j][2 - i].value = s[i][j].value;
                    temp[j][2 - i].color = s[i][j].color;
                }
            }

            // neu co vat can thi ko cho quay
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (temp[i][j].y < 2 || temp[i][j].y > 12) return 0;
                    if (temp[i][j].x > 21) return 0;
                    if (temp[i][j].value == 1 && b.B[temp[i][j].x][temp[i][j].y].value == 6) {
                        return 0;
                    }
                }
            }
            String color = "";
            // neu quay dc thi cho vi tri cu = rong ( =8)
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[i][j].value == 1) {
                        b.B[s[i][j].x][s[i][j].y].value = 8;
                        color = s[i][j].color;
                        s[i][j].color = "pray";
                        b.B[s[i][j].x][s[i][j].y].color = "pray";
                    }

                }
            }
            // set vi tri moi cho shape
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    s[i][j].value = temp[i][j].value;
                    s[i][j].color = temp[i][j].color;
                    if (s[i][j].value == 1)
                        b.B[s[i][j].x][s[i][j].y].color = color;
                }

            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[i][j].value == 1) {
                        b.B[s[i][j].x][s[i][j].y].value = 1;
                        b.B[s[i][j].x][s[i][j].y].color = s[i][j].color;
                    }
                }
            }
            return 1;
        }
    };

    private boolean checkOutOfBox(String move){
         if(styleOfShape.equals("I")){
             if(move.equals("left")) {



                 for(int i=0;i<4;i++){
                     for(int j=0;j<4;j++){
                         if(s[j][i].value==1 && s[j][i].y==2)return true;
                     }
                 }

             }else if(move.equals("right")) {
                 for(int i=3;i>=0;i--){
                     for(int j=0;j<4;j++){
                         if(s[j][i].value==1 && s[j][i].y==12)return true;
                     }
                 }
             }else if(move.equals("down")) {
                 for (int i = 3; i >= 0; i--) {
                     for (int j = 0; j < 4; j++) {
                         if (s[i][j].value == 1 && s[i][j].x == 23) return true;
                     }
                 }
             }
             return false;
         }
         else {
             if (move.equals("left")) {


                 for (int i = 0; i < 3; i++) {
                     for (int j = 0; j < 3; j++) {
                         if (s[j][i].value == 1 && s[j][i].y == 2) return true;
                     }
                 }

             } else if (move.equals("right")) {
                 for (int i = 2; i >= 0; i--) {
                     for (int j = 0; j < 3; j++) {
                         if (s[j][i].value == 1 && s[j][i].y == 12) return true;
                     }
                 }
             } else if (move.equals("down")) {
                 for (int i = 2; i >= 0; i--) {
                     for (int j = 0; j < 3; j++) {
                         if (s[i][j].value == 1 && s[i][j].x == 23) return true;
                     }
                 }
             }
             return false;
         }
    }
    private boolean checkCollisionWhenDrop(Box t){
        if(styleOfShape.equals("I")){
            for(int i=3;i>=0;i--){
                for (int j=0;j<4;j++){
                    if(s[i][j].value==1 && t.B[s[i][j].x+1][s[i][j].y].value==6)return true;
                }
            }

            return false;
        }
        else {
            for (int i = 2; i >= 0; i--) {
                for (int j = 0; j < 3; j++) {
                    if (s[i][j].value == 1 && t.B[s[i][j].x + 1][s[i][j].y].value == 6) return true;
                }
            }

            return false;
        }
    }
    private boolean checkCollisionWhenMovingLeft(Box t) {

        if(styleOfShape.equals("I")){
            for(int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    if(s[i][j].value==1 && t.B[s[i][j].x][s[i][j].y-1].value==6)return true;
                }
            }
            return false;
        }
        else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[i][j].value == 1 && t.B[s[i][j].x][s[i][j].y - 1].value == 6) return true;
                }
            }
            return false;
        }
    }
    private boolean checkCollisionWhenMovingRight(Box t) {
        if(styleOfShape.equals("I")){
            for(int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    if(s[i][j].value==1 && t.B[s[i][j].x][s[i][j].y+1].value==6)return true;
                }
            }
            return false;
        }
        else {


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[i][j].value == 1 && t.B[s[i][j].x][s[i][j].y + 1].value == 6) return true;
                }
            }
            return false;
        }
    }

    public String getStyleOfShapeToSave(){
       return styleOfShape;
    }


}
