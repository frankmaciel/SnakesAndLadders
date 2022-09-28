import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry} from 'rxjs/operators';

interface diceRoll {
  dieOne: number;
  dieTwo: number;
}

@Injectable({
  providedIn: 'root'
})
export class RolldiceService {

  constructor(private http: HttpClient) { }

  rollDice(){
    this.http.get("http://localhost:8080/api/advance").subscribe()
  }

  getDice(){
    let data = this.http.get<diceRoll>("http://localhost:8080/api/rollnumbers").pipe(retry(3))
    return data
  }


}
