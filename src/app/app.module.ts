import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatGridListModule } from '@angular/material/grid-list';
import { AppComponent } from './app.component';
import { GameboardComponent } from './components/gameboard/gameboard.component';
import { StartgameComponent } from './components/startgame/startgame.component';
import { RolldiceComponent } from './components/rolldice/rolldice.component';
import { EndgameComponent } from './components/endgame/endgame.component';
import { HttpClientModule } from '@angular/common/http';
import { PlayerinfoComponent } from './components/playerinfo/playerinfo.component';

@NgModule({
  declarations: [
    AppComponent,
    GameboardComponent,
    StartgameComponent,
    RolldiceComponent,
    EndgameComponent,
    PlayerinfoComponent
  ],
  imports: [
    MatGridListModule,
    BrowserModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
