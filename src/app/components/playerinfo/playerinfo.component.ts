import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service';

@Component({
  selector: 'app-playerinfo',
  templateUrl: './playerinfo.component.html',
  styleUrls: ['./playerinfo.component.css']
})
export class PlayerinfoComponent implements OnInit {

  constructor(private dataService: DataServiceService) { }

  currentPlayer: any
  playerPositions: any
  winner: any
  colors: string[] = ["red","blue","green","black"]


  ngOnInit(): void {
    this.dataService.currentplayer.subscribe(player => {this.currentPlayer = player})
    this.dataService.playerpositions.subscribe(positions => this.playerPositions = positions)
    this.dataService.winnerexists.subscribe(winner => this.winner = winner)
  }

}
