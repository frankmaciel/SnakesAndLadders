package maciel.frank.snakesladders.Controller;

import lombok.extern.slf4j.Slf4j;
import maciel.frank.snakesladders.Links.SnakesLaddersLinks;
import maciel.frank.snakesladders.Model.GameBoardObject;
import maciel.frank.snakesladders.Model.LadderObject;
import maciel.frank.snakesladders.Model.SnakeObject;
import maciel.frank.snakesladders.Service.GameBoardServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class GameBoardController {

  @Autowired
  GameBoardServiceImplementation gameboardService = new GameBoardServiceImplementation();


  @GetMapping(path= SnakesLaddersLinks.START)
  public ResponseEntity<?> loadGameData(){ // Initialize Variables
    gameboardService.setUpGameBoard();
    log.info("Game Loaded");
    System.out.println("Game Loaded");
    return ResponseEntity.ok("{}");
  }


  @GetMapping(path= SnakesLaddersLinks.ADVANCE)
  public ResponseEntity<?> advanceGame(){ // Update Variables

    if(gameboardService.getGameboard() == null){
      return ResponseEntity.ok("");
    }

    log.info("Advancing");
    //Here we advance in the game
    gameboardService.advanceInGame();

    //Must check players positions to determine if the game has been won
    return gameboardService.checkIfGameOver();
  }


  @GetMapping(path= SnakesLaddersLinks.PLAYER_POSITIONS)
  public ResponseEntity<?> playerPositions(){ // Will return player positions on the board
    if(gameboardService.getGameboard() == null){
      return ResponseEntity.ok("");
    }
    log.info("Positions Retrieved");
    System.out.println("Positions Retrieved");
    return ResponseEntity.ok(gameboardService.playerPositions().toString());
  }

  @GetMapping(path= SnakesLaddersLinks.PLAYER_POSITION1)
  public ResponseEntity<?> playerPosition1(){
    if(gameboardService.getGameboard() == null){
      return ResponseEntity.ok("");
    }
    log.info("Position Retrieved");
    System.out.println("Position Retrieved");
    return ResponseEntity.ok(gameboardService.playerPositions().get(0));
  }

  @GetMapping(path= SnakesLaddersLinks.PLAYER_POSITION2)
  public ResponseEntity<?> playerPosition2(){
    if(gameboardService.getGameboard() == null){
      return ResponseEntity.ok("");
    }
    log.info("Position Retrieved");
    System.out.println("Position Retrieved");
    return ResponseEntity.ok(gameboardService.playerPositions().get(1));
  }

  @GetMapping(path= SnakesLaddersLinks.PLAYER_POSITION3)
  public ResponseEntity<?> playerPosition3(){
    if(gameboardService.getGameboard() == null){
      return ResponseEntity.ok("");
    }
    log.info("Position Retrieved");
    System.out.println("Position Retrieved");
    return ResponseEntity.ok(gameboardService.playerPositions().get(2));
  }

  @GetMapping(path= SnakesLaddersLinks.PLAYER_POSITION4)
  public ResponseEntity<?> playerPosition4(){
    if(gameboardService.getGameboard() == null){
      return ResponseEntity.ok("");
    }
    log.info("Position Retrieved");
    System.out.println("Position Retrieved");
    return ResponseEntity.ok(gameboardService.playerPositions().get(3));
  }

  @GetMapping(path= SnakesLaddersLinks.ROLL_NUMBERS)
  public ResponseEntity<?> rollNumbers(){ // returns the roll numbers
    if(gameboardService.getGameboard() == null){
      return ResponseEntity.ok("[0,0]");
    }
    ArrayList<Integer> rolls = gameboardService.getRollNumbers();
    log.info("Retrieved Rolls");
    System.out.println("Retrieved Rolls");
    return ResponseEntity.ok(rolls.toString());
  }

  @GetMapping(path= SnakesLaddersLinks.WINNER_EXISTS)
  public ResponseEntity<?> winnerExists(){ // check if there is a winner
    if(gameboardService.getGameboard() == null){
      return ResponseEntity.ok("");
    }
    log.info("Fetching Winner");
    System.out.println("Fetching Winner");
    return ResponseEntity.ok(gameboardService.getGameboard().getWinner());
  }

  @GetMapping(path= SnakesLaddersLinks.CURRENT_PLAYER)
  public ResponseEntity<?> currentPlayer(){ // fetches the current player
    if(gameboardService.getGameboard() == null){
      return ResponseEntity.ok("");
    }
    log.info("Fetching Current Player");
    System.out.println("Fetching Current Player");
    return ResponseEntity.ok(gameboardService.getGameboard().getCurrentPlayer() + 1);
  }

  @GetMapping(path= SnakesLaddersLinks.END_GAME)
  public ResponseEntity<?> endGame() { // sets the board to null
    log.info("Ending Game");
    System.out.println("Ending Game");
    gameboardService.setGameBoard(null);
    return ResponseEntity.ok("{}");
  }

  @GetMapping(path= SnakesLaddersLinks.ERROR)
  public ResponseEntity<?> error(){
    log.info("Game Error");
    System.out.println("Game Error");
    return ResponseEntity.ok("Error");
  }





}
