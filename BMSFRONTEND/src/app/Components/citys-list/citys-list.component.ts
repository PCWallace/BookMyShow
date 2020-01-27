import { Component, OnInit } from '@angular/core';
import { City } from 'src/app/model/City';
import { Router } from '@angular/router';
import { CityService } from '../../services/city.service';

@Component({
    selector: 'app-citys-list',
    templateUrl: './citys-list.component.html',
    styleUrls: ['./citys-list.component.css']
})
export class CitysListComponent implements OnInit {
    title = 'BMSFRONTEND';
    cities: City[];
    showForm = false;
    theaters:[any] ;
    movies:[any];
    show=false;
    cityId: string;
    constructor(private service: CityService, private router: Router) {}

    ngOnInit() {
        this.getAllCities();
    }

    getAllCities() {
        this.service.getAllCities().subscribe(res => {
            console.log(res.body.details);
            this.cities = res.body.details;
        });
    }

    
    getMovie_Theatre(id:string){
        this.service.getMovie_Theatre(id).subscribe(res=>{
            console.log(res.body.details);
            this.theaters = res.body.details.theaters;
            this.movies = res.body.details.movies;
            this.show =true;
        })
    }

}
