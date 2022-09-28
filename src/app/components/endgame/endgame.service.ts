import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EndgameService {

  constructor(private http: HttpClient) { }
  async endGame(){
    await this.http.get("http://localhost:8080/api/endgame").subscribe()
  }

}
