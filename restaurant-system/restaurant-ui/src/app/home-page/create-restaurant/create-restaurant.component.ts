import { Component } from "@angular/core";

@Component({
    selector: "create-restaurant",
    templateUrl: "./create-restaurant.component.html",
    styleUrls: ["./create-restaurant.css"]
})
export class CreateRestaurantComponent {

    statusColor = 'green';

    getStatus() {
        return this.statusColor;
    }


    status: Boolean = false;

    logOut() {
        this.status = true
        this.statusColor = 'red'
    }

    logIn() {
        this.status = false
        this.statusColor = 'green'
    }


}