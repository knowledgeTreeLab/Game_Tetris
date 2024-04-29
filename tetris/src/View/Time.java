package View;

public class Time {
    public int hour;
    public int minute;
    public int seconds;
    public Time(){
        hour=0;
        minute=0;
        seconds=0;
    }
    /*public void checkUpToHour(){
        if(minute==59){
            minute=0;
            hour++;
        }
    }*/
    public void checkUpYoMinute(){
        if(seconds==59&&minute==59){
            seconds=0;
            minute=0;
            hour++;
        }else if(seconds==59 && minute!=59){
            seconds=0;
            minute++;
        }else{
            seconds++;
        }
    }

    public void countTime() throws InterruptedException {
        Thread.sleep(1000);
        checkUpYoMinute();
    }
    public String toString(){
        return hour+":"+minute+":"+seconds;
    }
}

