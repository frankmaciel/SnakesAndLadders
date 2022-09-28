package maciel.frank.snakesladders;

import maciel.frank.snakesladders.Model.PlayerObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerObjectTests {
    private PlayerObject player;

    @Test
    void constructorPosition(){
        player = new PlayerObject(1);
        if(player.getCurrentPosition() == 1){
            assert true;
        }else {
            assert false;
        }
    }

    @Test
    void changePosition(){
        player = new PlayerObject(1);
        player.setCurrentPosition(60);
        if(player.getCurrentPosition() == 60){
            assert true;
        }else {
            assert false;
        }
    }

    @Test
    void playerIDCorrect(){
        player = new PlayerObject(405);
        if(player.getPlayerID() == 405){
            assert true;
        }else {
            assert false;
        }
    }



}
