import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { City } from 'src/app/models/city';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  private readonly CITY_LIST_API_URL = 'http://localhost:8080/cities';

  constructor(private http: HttpClient) { }

  fetchAllInfo() : Observable<City[]> {
    return this.http.get<City[]>(this.CITY_LIST_API_URL);
  }
}
