package maciel.frank.snakesladders.Model;

import java.util.Random;

public class DieObject {

    private static int sides;
    private int rollNumber;

    public DieObject(int sides){
        this.sides = sides;
    }

    public int roll(){
        Random r = new Random();
        rollNumber = r.nextInt(sides) + 1;
        return rollNumber;
    }

    public int getRollNumber(){
      return rollNumber;
    }

}
