package View;

public class Score {
    public int score;
    public int level;
    public int line;
    public Time time;
    public Score(){
        score=0;
        level=0;
        line=0;
        time=new Time();
    }
    public Score( int score, int level, int line){
        this.score=score;
        this.level=level;
        this.line=line;
    }

}
