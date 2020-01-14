import { Component, OnInit } from '@angular/core';
import { City } from 'src/model/City';
import { Router } from '@angular/router';
import { CityService } from '../services/city.service';

@Component({
    selector: 'app-citys-list',
    templateUrl: './citys-list.component.html',
    styleUrls: ['./citys-list.component.css']
})
export class CitysListComponent implements OnInit {
    title = 'BMSFRONTEND';
    cities: City[];
    showForm = false;
    cityId: string;
    constructor(private service: CityService, private router: Router) {}

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

    registerTheatreId(id: string) {
        // console.log(id);
        this.cityId = id;
    }
}
