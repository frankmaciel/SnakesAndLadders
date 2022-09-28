package maciel.frank.snakesladders.Model;

public class LadderObject{

    private int top;
    private int bottom;

    public LadderObject(){

    }

    public LadderObject(int top, int bottom){
        this.top = top;
        this.bottom = bottom;
    }

    public int getTopPosition(){
        return top;
    }

    public int getBottomPosition(){
        return bottom;
    }

}
