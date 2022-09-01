import { Component } from "@angular/core";
import { UserModel } from "./display/display.model";

@Component({
    selector: "dashboard",
    templateUrl: "./dashboard.component.html",
    styleUrls: ["./dashboard.css"]
})
export class DashboardComponent {

    userDetailsList: Array<UserModel> = []

    constructor() {

    }

    updateUserInfo(event) {
        console.log(event);
        this.userDetailsList.push(event);
    }

}