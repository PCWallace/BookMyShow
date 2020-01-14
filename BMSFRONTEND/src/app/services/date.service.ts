import { Injectable } from '@angular/core';
import { DateviewComponent } from '../dateview/dateview.component';

@Injectable({
  providedIn: 'root'
})
export class DateService {

  constructor(private dateview:DateviewComponent) { }
}
