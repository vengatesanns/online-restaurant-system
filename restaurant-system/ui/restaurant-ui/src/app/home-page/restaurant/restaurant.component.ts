import { Component } from "@angular/core";
import { RestaurantService } from "src/app/services/restaurant.service";

@Component({
    selector: "restaurant",
    templateUrl: "./restaurant.component.html",
    styleUrls: ["./restaurant.css"]

})
export class RestaurantComponent {

    restaurantDetails;
    imageFlag: Boolean = true;
    foodItems = []


    constructor(private restaurantService: RestaurantService) {
        this.getRestaurantDetails()

    }


    getRestaurantDetails = () => {
        const self = this;
        this.restaurantService.fetchRestaurantDetails().subscribe(response => {
            self.restaurantDetails = response;
        })
    }

    // Selecting the restaurant
    selectRestaurant = (restaurantId, foodItems) => {
        this.imageFlag = false;
        this.foodItems = foodItems;
    }

}