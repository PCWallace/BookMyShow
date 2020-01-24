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
        return this.http.get<ServerResponse>('api/cities/All', { headers: header , observe: 'response'});
    }

    getMovie_Theatre(id:string){
        const header = new HttpHeaders({
            Authorization: localStorage.getItem('tokken')
        });
        return this.http.get<ServerResponse>(`api/tmbc/${id}`, { headers: header , observe: 'response'});
    }
    // getAllTheatersForCity(id: string) {
    //     return this.http.get<ServerResponse>(`api/theaters/${id}`);
    // }
}
