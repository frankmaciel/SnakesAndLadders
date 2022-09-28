import { TestBed } from '@angular/core/testing';

import { RolldiceService } from './rolldice.service';

describe('RolldiceService', () => {
  let service: RolldiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RolldiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
