import { Component } from "@angular/core";
import { SpinnerService } from "src/app/services/spinner.service";



@Component({
    selector: "spinner",
    templateUrl: "./spinner.component.html",
    styleUrls: ["spinner.scss"]
})
export class SpinnerComponent {

    show: Boolean = false;


    constructor(private spinnerService: SpinnerService) {

    }

    ngOnInit() {
        this.spinnerService.getSpinnerObservable().subscribe(status => {
            this.show = status;
        });
    }



}