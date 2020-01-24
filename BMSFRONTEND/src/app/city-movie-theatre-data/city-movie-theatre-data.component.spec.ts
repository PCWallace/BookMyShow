import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CityMovieTheatreDataComponent } from './city-movie-theatre-data.component';

describe('CityMovieTheatreDataComponent', () => {
  let component: CityMovieTheatreDataComponent;
  let fixture: ComponentFixture<CityMovieTheatreDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CityMovieTheatreDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CityMovieTheatreDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
