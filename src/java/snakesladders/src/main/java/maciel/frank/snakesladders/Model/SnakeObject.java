package maciel.frank.snakesladders.Model;

public class SnakeObject{

    private int head;
    private int tail;

    public SnakeObject(int head, int tail){
        this.head = head;
        this.tail = tail;
    }

    public int getHeadPosition(){
        return head;
    }

    public int getTailPosition(){
        return tail;
    }

}
