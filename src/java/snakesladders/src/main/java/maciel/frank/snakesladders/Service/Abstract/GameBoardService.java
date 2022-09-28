package maciel.frank.snakesladders.Service.Abstract;

import maciel.frank.snakesladders.Model.DieObject;
import maciel.frank.snakesladders.Model.GameBoardObject;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface GameBoardService {

  abstract GameBoardObject getGameboard();

  abstract int diceRoll();

  abstract ArrayList<Integer> playerPositions();

  abstract void advanceInGame();

  abstract void iterateAdvance();

  abstract int checkLadder();

  abstract int checkSnake();

  abstract void setGameBoard(GameBoardObject gameBoard);

  abstract void setUpGameBoard();

  abstract ArrayList<Integer> getRollNumbers();




}
