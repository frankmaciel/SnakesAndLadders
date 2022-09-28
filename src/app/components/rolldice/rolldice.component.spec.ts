import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RolldiceComponent } from './rolldice.component';

describe('RolldiceComponent', () => {
  let component: RolldiceComponent;
  let fixture: ComponentFixture<RolldiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RolldiceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RolldiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
