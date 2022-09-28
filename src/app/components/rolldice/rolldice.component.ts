import { Component, OnInit, ViewChild, ViewChildren } from '@angular/core';
import { RolldiceService } from './rolldice.service';
import { PlayerinfoComponent } from '../playerinfo/playerinfo.component';
import { GameboardComponent } from '../gameboard/gameboard.component';
import { DataServiceService } from '../data-service.service';

@Component({
  providers: [],
  selector: 'app-rolldice',
  templateUrl: './rolldice.component.html',
  styleUrls: ['./rolldice.component.css'],
})
export class RolldiceComponent implements OnInit {

  public rolldata: any

  constructor(private rollDiceService: RolldiceService,
    private dataService: DataServiceService) {
    }

  roll(){
    this.rollDiceService.rollDice()
    this.rolldata = this.rollDiceService.getDice()
    this.dataService.refreshAllData() // Added
  }

  ngOnInit(): void {
    this.rolldata = this.rollDiceService.getDice()
  }

}
