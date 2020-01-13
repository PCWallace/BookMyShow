import { Component, OnInit } from '@angular/core';
import { Router, Route } from '@angular/router';
import { Service } from '../service';

@Component({
  selector: 'app-theaterslist',
  templateUrl: './theaterslist.component.html',
  styleUrls: ['./theaterslist.component.css']
})
export class TheaterslistComponent implements OnInit {
  id:any
  constructor(private router:Router, private service:Service) { 
    this.id = router.getCurrentNavigation().extras.state.data;
    console.log(this.id)
  }

  ngOnInit() {
    this.service.getAllTheatersForCity(this.id).subscribe((obj)=>{console.log(obj)})
  }
  
}
