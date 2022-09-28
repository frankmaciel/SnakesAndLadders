import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataServiceService } from '../data-service.service';

@Injectable({
  providedIn: 'root'
})
export class EndgameService {

  constructor(private http: HttpClient,private dataService: DataServiceService) { }
  async endGame(){
    await this.http.get(this.dataService.url + "endgame").subscribe()
  }

}
