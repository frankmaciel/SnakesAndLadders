import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { EndgameService } from './endgame.service';

@Component({
  selector: 'app-endgame',
  templateUrl: './endgame.component.html',
  styleUrls: ['./endgame.component.css']
})
export class EndgameComponent implements OnInit {

  constructor(private endGameService: EndgameService,
    private dataService: DataServiceService) { }

  async endGame() {
   await this.endGameService.endGame();
   this.dataService.refreshAllData();
  }

  ngOnInit(): void {
  }

}
