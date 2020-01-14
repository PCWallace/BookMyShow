import { Component } from '@angular/core';
import { Service } from 'src/app/service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(public service: Service){
  }
  
}
