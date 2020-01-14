import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { City } from 'src/model/City';
import { Theater } from 'src/model/Theater';

@Injectable({
    providedIn: 'root'
})
export class CityService {
    cities: City[];

    constructor(public http: HttpClient) {
        this.cities = [];
    }

    getAllCities() {
        const header = new HttpHeaders({
            Authorization: localStorage.getItem('tokken')
        });
        return this.http.get<City[]>('api/cities/All', { headers: header });
    }

    getAllTheatersForCity(id: string) {
        return this.http.get<Theater[]>(`api/theaters/${id}`);
    }
}
