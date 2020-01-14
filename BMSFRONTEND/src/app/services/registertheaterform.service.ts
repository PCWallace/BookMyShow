import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class RegistertheaterformService {
    constructor(private http: HttpClient) {}

    submit(formValues, city) {
        formValues.cityId = city;
        console.log(formValues);
        const header = new HttpHeaders({
            Authorization: localStorage.getItem('tokken')
        });

        return this.http.post('api/theaters/theater', formValues, {
            observe: 'response',
            headers: header
        });
    }
}
