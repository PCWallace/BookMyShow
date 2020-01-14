import { Component, OnInit } from '@angular/core';
import { Service } from '../service';
import { City } from 'src/model/City';
import { Router } from '@angular/router';

@Component({
    selector: 'app-citys-list',
    templateUrl: './citys-list.component.html',
    styleUrls: ['./citys-list.component.css']
})
export class CitysListComponent implements OnInit {
    title = 'BMSFRONTEND';
    cities: City[];
    constructor(private service: Service, private router: Router) {}

    ngOnInit() {
        this.getAllCities();
    }

    getAllCities() {
        console.log('hi');
        this.service.getAllCities().subscribe(data => {
            this.cities = data;
            console.log(data);
        });
    }

    cityCall(id: string) {
        console.log(id);
        this.router.navigate([`citydata`], { state: { data: id } });
    }
}
