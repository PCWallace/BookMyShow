import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-city-movie-theatre-data',
  templateUrl: './city-movie-theatre-data.component.html',
  styleUrls: ['./city-movie-theatre-data.component.css']
})
export class CityMovieTheatreDataComponent implements OnInit {

  @Input() theaters: any;
  @Input() movies: any;

  constructor() { }

  ngOnInit() {
  }

}
