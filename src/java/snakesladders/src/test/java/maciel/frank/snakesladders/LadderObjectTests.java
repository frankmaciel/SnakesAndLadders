package maciel.frank.snakesladders;

import maciel.frank.snakesladders.Model.LadderObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LadderObjectTests {

    private LadderObject ladder = new LadderObject(5,2);

    @Test
    void getTopValue(){
        if(ladder.getTopPosition() == 5){
            assert true;
        }else{
            assert false;
        }
    }

    @Test
    void getBottomValue(){
        if(ladder.getBottomPosition() == 2){
            assert true;
        }else{
            assert false;
        }
    }
}
