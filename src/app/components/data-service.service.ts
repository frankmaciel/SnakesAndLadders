import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, retry} from 'rxjs/operators';
import { Observable, BehaviorSubject } from 'rxjs';

interface playerPositions{
  playerPositions:number
}

interface currentPlayer{
  currentPlayer: number;
}

interface playerPositions{
  playerPositions:number
}

interface winnerExists{
  winner: number
}

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  constructor(private http: HttpClient) { 
  }

  // The variables which need to be observed for playerinfo component
  private current_player = new BehaviorSubject<Observable<currentPlayer>>(this.getCurrentPlayer())
  currentplayer = this.current_player.asObservable()
  private player_positions = new BehaviorSubject<Observable<playerPositions>>(this.getPlayerPositions())
  playerpositions = this.player_positions.asObservable()
  private winner = new BehaviorSubject<Observable<winnerExists>>(this.getWinner())
  winnerexists = this.winner.asObservable()

  

  // The variables which need to be obserbed for the gameboard component
  private playerposition1 = new BehaviorSubject<Observable<playerPositions>>(this.getPlayerPosition1())
  player_position1 = this.playerposition1.asObservable()
  private playerposition2 = new BehaviorSubject<Observable<playerPositions>>(this.getPlayerPosition2())
  player_position2 = this.playerposition2.asObservable()
  private playerposition3 = new BehaviorSubject<Observable<playerPositions>>(this.getPlayerPosition3())
  player_position3 = this.playerposition3.asObservable()
  private playerposition4 = new BehaviorSubject<Observable<playerPositions>>(this.getPlayerPosition4())
  player_position4 = this.playerposition4.asObservable()

  // HTTP methods
  getCurrentPlayer(){
    let temp = this.http.get<currentPlayer>("http://localhost:8080/api/currentplayer").pipe(retry(3))
    return temp
  }

  getPlayerPositions(){
    let temp = this.http.get<playerPositions>("http://localhost:8080/api/playerpositions").pipe(retry(3))
    return temp
  }

  getWinner(){
    let temp = this.http.get<winnerExists>("http://localhost:8080/api/winnerexists").pipe(retry(3))
    return temp
  }

  getPlayerPosition1(){
    let playerPositions = this.http.get<playerPositions>("http://localhost:8080/api/playerposition1").pipe(retry(3))
    return playerPositions
  }
  getPlayerPosition2(){
    let playerPositions = this.http.get<playerPositions>("http://localhost:8080/api/playerposition2").pipe(retry(3))
    return playerPositions
  }
  getPlayerPosition3(){
    let playerPositions = this.http.get<playerPositions>("http://localhost:8080/api/playerposition3").pipe(retry(3))
    return playerPositions
  }
  getPlayerPosition4(){
    let playerPositions = this.http.get<playerPositions>("http://localhost:8080/api/playerposition4").pipe(retry(3))
    return playerPositions
  }

  refreshAllData(){
    this.current_player.next(this.getCurrentPlayer())
    this.player_positions.next(this.getPlayerPositions())
    this.winner.next(this.getWinner())
    this.playerposition1.next(this.getPlayerPosition1())
    this.playerposition2.next(this.getPlayerPosition2())
    this.playerposition3.next(this.getPlayerPosition3())
    this.playerposition4.next(this.getPlayerPosition4())

  }
  
}
