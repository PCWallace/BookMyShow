import { Component, OnInit } from '@angular/core';
import { CityService } from '../../services/city.service';
import { Dates } from 'src/app/model/Dates';

@Component({
  selector: 'app-dateview',
  templateUrl: './dateview.component.html',
  styleUrls: ['./dateview.component.css']
})
export class DateviewComponent implements OnInit {
  dates: Dates;

  constructor(private service: CityService) { }

  ngOnInit() {
    this.service.getAllDates().subscribe(res=>{
        console.log(res.body.details);
        this.dates = res.body.details;
    })
  }

}
