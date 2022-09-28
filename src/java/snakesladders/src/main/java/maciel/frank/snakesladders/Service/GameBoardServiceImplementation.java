package maciel.frank.snakesladders.Service;
import maciel.frank.snakesladders.Model.*;
import maciel.frank.snakesladders.Service.Abstract.GameBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class GameBoardServiceImplementation implements GameBoardService {

  private static GameBoardObject gameboard;

  @Override
  public GameBoardObject getGameboard() {
    return gameboard;
  }

  @Override
  public int diceRoll() { // Roll dice via gameboard
    int rollOne = gameboard.getDieOne().roll();
    int rollTwo = gameboard.getDieTwo().roll();
    return rollOne + rollTwo;
  }

  @Override
  public ArrayList<Integer> playerPositions() { // Retrieve player positions
    ArrayList<Integer> playerPosition = new ArrayList<>();
    for (PlayerObject p: gameboard.getPlayerList()) {
      playerPosition.add(p.getCurrentPosition());
    }
    return playerPosition;
  }


  @Override
  public void advanceInGame() {
    // condensed the iterative step into its own method
    iterateAdvance();

    if(gameboard.getDieOne().getRollNumber() != gameboard.getDieTwo().getRollNumber()){
      gameboard.setCurrentPlayer(gameboard.getCurrentPlayer() + 1);
      if(gameboard.getCurrentPlayer() == 4){
        gameboard.setCurrentPlayer(0);
      }
    }
  }

  @Override
  public void iterateAdvance() { // performs the iterative action each player performs
    gameboard.setDiceSum(diceRoll()); // Rolling dice

    //Incrementing current player position
    gameboard.getPlayerList().get(gameboard.getCurrentPlayer()).incrementCurrentPosition(gameboard.getDiceSum());

    int playerPosition = gameboard.getPlayerList().get(gameboard.getCurrentPlayer()).getCurrentPosition();
    if( playerPosition >= 100){
      int temp = (playerPosition - 100)*2;
      gameboard.getPlayerList().get(gameboard.getCurrentPlayer()).decrementCurrentPosition(temp);
    }

    // Check if a ladder bottom is hit, and if so move to the top of the ladder
    int ladderCheck = checkLadder();
    if(ladderCheck != -1){
      gameboard.getPlayerList().get(gameboard.getCurrentPlayer()).setCurrentPosition(ladderCheck);
    }

    //Similarily, check if the snake head is hit, if so move to the tail
    int snakeCheck = checkSnake();
    if(snakeCheck != -1){
      gameboard.getPlayerList().get(gameboard.getCurrentPlayer()).setCurrentPosition(snakeCheck);
    }

  }

  @Override
  public int checkLadder() { // determines if a player's position is at the bottom of a ladder
    for(LadderObject ladder: gameboard.getLadderList()){
      if(ladder.getBottomPosition() == gameboard.getPlayerList().get(gameboard.getCurrentPlayer()).getCurrentPosition()){ // If a ladder bottom is hit
        return ladder.getTopPosition();
      }
    }
    return -1;
  }

  @Override
  public int checkSnake() { // determines if a players position is at the head of a snake
    for (SnakeObject snake: gameboard.getSnakeList()) {
      if(snake.getHeadPosition() == gameboard.getPlayerList().get(gameboard.getCurrentPlayer()).getCurrentPosition()){
        return snake.getTailPosition();
      }
    }
    return -1;
  }

  @Override
  public void setGameBoard(GameBoardObject gameboard) {
    this.gameboard = gameboard;
  }


  @Override
  public void setUpGameBoard() { // Loads a new board
    ArrayList<SnakeObject> snakes = setSnakeList();
    ArrayList<LadderObject> ladders = setLadderList();
    gameboard = new GameBoardObject(6,6,snakes,ladders);
  }

  @Override
  public ArrayList<Integer> getRollNumbers() { // Returns the numbers rolled

    ArrayList<Integer> rolls = new ArrayList<>();
    rolls.add(gameboard.getDieOne().getRollNumber());
    rolls.add(gameboard.getDieTwo().getRollNumber());

    return rolls;
  }

  //Private class methods
  public ResponseEntity<?> checkIfGameOver() { // will determine if the game is over by setting a winner
    int count = 0;
    for (int i: playerPositions()) {
      count++;
      if(i == 100){
        gameboard.setWinner(count);
        System.out.println("Game has finished, the winner is: " + count);
        return ResponseEntity.ok("{}");
        }
      }
    System.out.println("Game Advanced");
    return ResponseEntity.ok("{}");
  }
  private ArrayList<SnakeObject> setSnakeList(){ // Look into turning this into a simple HashMap Lookup -> values will never overlap
    ArrayList<SnakeObject> retSnakes = new ArrayList<>();
    retSnakes.add(new SnakeObject(16,6));
    retSnakes.add(new SnakeObject(62,19));
    retSnakes.add(new SnakeObject(46,25));
    retSnakes.add(new SnakeObject(49,11));
    retSnakes.add(new SnakeObject(64,60));
    retSnakes.add(new SnakeObject(74,53));
    retSnakes.add(new SnakeObject(89,68));
    retSnakes.add(new SnakeObject(92,88));
    retSnakes.add(new SnakeObject(95,76));
    retSnakes.add(new SnakeObject(99,80));
    return retSnakes;
  }
  private ArrayList<LadderObject> setLadderList(){
    ArrayList<LadderObject> retLadders = new ArrayList<>();

    retLadders.add(new LadderObject(38,2));
    retLadders.add(new LadderObject(26,15));
    retLadders.add(new LadderObject(14,7));
    retLadders.add(new LadderObject(31,8));
    retLadders.add(new LadderObject(42,21));
    retLadders.add(new LadderObject(44,36));
    retLadders.add(new LadderObject(84,28));
    retLadders.add(new LadderObject(67,51));
    retLadders.add(new LadderObject(98,78));
    retLadders.add(new LadderObject(94,87));
    retLadders.add(new LadderObject(91,71));

    return retLadders;
  }

}
