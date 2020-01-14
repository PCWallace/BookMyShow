import { HttpClient, HttpHeaders } from '@angular/common/http';
import { City } from 'src/model/City';
import { Theater } from 'src/model/Theater';
import { Injectable } from '@angular/core';

@Injectable()
export class Service {
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
        return this.http.get<Theater[]>(`http://localhost:8083/theaters/${id}`);
    }
}
