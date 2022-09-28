package maciel.frank.snakesladders;

import maciel.frank.snakesladders.Model.DieObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DieObjectTests {
    @Test
    void sixSidedRandom() {
        int sides = 6;
        DieObject die = new DieObject(sides);
        int roll = die.roll();
        if(roll <= sides || roll>= 1) {
            assert true;
        }else{
            assert false;
        }
    }
    @Test
    void eightSidedRandom(){
        int sides = 8;
        DieObject die = new DieObject(sides);
        int roll = die.roll();
        if(roll <= sides || roll>= 1) {
            assert true;
        }else{
            assert false;
        }
    }
    @Test
    void TwelveSidedRandom(){
        int sides = 12;
        DieObject die = new DieObject(sides);
        int roll = die.roll();
        if(roll <= sides || roll>= 1) {
            assert true;
        }else{
            assert false;
        }
    }
}
