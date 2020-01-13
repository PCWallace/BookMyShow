import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dateview',
  templateUrl: './dateview.component.html',
  styleUrls: ['./dateview.component.css']
})
export class DateviewComponent implements OnInit {
  dates: any;

  constructor() { }

  ngOnInit() {
  }

  getAllDates(){
    console.log('hi')
  //  this.service.getAllDates().subscribe(data=> {this.dates=data;console.log(data);})
  }

  dateCall(id:string){
    console.log(id)
    //this.router.navigate([`datedata`],{state:{data:id}})
  }

}
