package pl.jtimersk;

public class Meetings {

    private String pointTitle;
    private int pointTime;

    public Meetings(String pointTitle, int pointTime){
        this.pointTitle = pointTitle;
        this.pointTime = pointTime;
    }

    public String getPointTitle() {
        return pointTitle;
    }

    public void setPointTitle(String pointTitle) {
        this.pointTitle = pointTitle;
    }

    public int getPointTime() {
        return pointTime;
    }

    public void setPointTime(int pointTime) {
        this.pointTime = pointTime;
    }
}
