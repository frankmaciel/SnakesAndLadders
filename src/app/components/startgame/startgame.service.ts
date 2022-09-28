import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry} from 'rxjs/operators';
import { DataServiceService } from '../data-service.service';


@Injectable({
  providedIn: 'root'
})
export class StartgameService {

  constructor(private http: HttpClient,
    private dataService: DataServiceService) { }

  loadGameData(){
    this.http.get(this.dataService.url + "start").subscribe()
    this.dataService.refreshAllData()
  }


}
