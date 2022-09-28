import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry} from 'rxjs/operators';
import { DataServiceService } from '../data-service.service';

interface diceRoll {
  dieOne: number;
  dieTwo: number;
}

@Injectable({
  providedIn: 'root'
})
export class RolldiceService {

  constructor(private http: HttpClient,private dataService: DataServiceService) { }

  rollDice(){
    this.http.get(this.dataService.url + "advance").subscribe()
  }

  getDice(){
    let data = this.http.get<diceRoll>(this.dataService.url + "rollnumbers").pipe(retry(3))
    return data
  }


}
