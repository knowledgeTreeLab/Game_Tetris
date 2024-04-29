package Control;

public class Point {
    public int x;
    public int y;
    public int value;
    public String color;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public Point(int x,int y,String color,int value){
        this.x=x;
        this.y=y;
        this.color=color;
        this.value=value;
    }

}
