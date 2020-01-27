import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TheaterviewComponent } from './theaterview.component';

describe('TheaterviewComponent', () => {
  let component: TheaterviewComponent;
  let fixture: ComponentFixture<TheaterviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TheaterviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TheaterviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
