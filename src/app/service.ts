 import { HttpClient } from '@angular/common/http';
import { City } from 'src/model/City';
import { Theater } from 'src/model/Theater';
import { Injectable } from '@angular/core';

@Injectable()
export class Service{
    
    cities: City[]

    constructor(public http: HttpClient) {
        this.cities = []
       
      }

      getAllCities(){
          return this.http.get<City[]>('http://localhost:8082/cities/All');
      }

      getAllTheatersForCity(id:string){
            return this.http.get<Theater[]>(`http://localhost:8083/theaters/${id}`);
      }
      
}