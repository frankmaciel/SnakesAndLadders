package maciel.frank.snakesladders;

import maciel.frank.snakesladders.Model.SnakeObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SnakeObjectTests {
    private SnakeObject snake = new SnakeObject(10,4);

    @Test
    void getTopValue(){
        if(snake.getHeadPosition() == 10){
            assert true;
        }else{
            assert false;
        }
    }

    @Test
    void getBottomValue(){
        if(snake.getTailPosition() == 4){
            assert true;
        }else{
            assert false;
        }
    }
}
