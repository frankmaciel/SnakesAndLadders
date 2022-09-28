import { Component, OnInit } from '@angular/core';
import { StartgameService } from './startgame.service';

@Component({
  selector: 'app-startgame',
  templateUrl: './startgame.component.html',
  styleUrls: ['./startgame.component.css']
})
export class StartgameComponent implements OnInit {


  constructor(private startGameService: StartgameService) { }

  loadGame():void {
    this.startGameService.loadGameData();
  }

  ngOnInit(): void {
  }

}
