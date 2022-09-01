import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private httpClient: HttpClient) { }


  fetchRestaurantDetails = () => {
    return this.httpClient.get("http://localhost:9000/restaurant/fetch-all")
    // .pipe(map(response => {
    //   return response;
    // }))
  }


}
