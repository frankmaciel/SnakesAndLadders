import { TestBed } from '@angular/core/testing';

import { StartgameService } from './startgame.service';

describe('StartgameService', () => {
  let service: StartgameService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StartgameService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
