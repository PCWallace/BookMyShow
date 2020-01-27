import { Injectable } from '@angular/core';
import { DateviewComponent } from '../Components/dateview/dateview.component';

@Injectable({
  providedIn: 'root'
})
export class DateService {
  constructor(private dateview:DateviewComponent) { }
}
