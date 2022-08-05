import { Component } from '@angular/core';
import { RestaurantService } from './services/restaurant.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

    constructor(private restaurantService: RestaurantService) {
      this.getRestaurantDetails()

    }


    getRestaurantDetails = () => {
          this.restaurantService.fetchRestaurantDetails().subscribe(response => {
            console.log(response)
          })
    }


}
