import { Component } from "@angular/core";
import { FormControl, FormGroup } from "@angular/forms";
import { LoginModel } from "src/app/model/login.model";

@Component({
    selector: "login",
    templateUrl: "./login.component.html",
    styleUrls: ["./login.scss"]
})
export class LoginComponent {

    // Variable Declarations
    hide: Boolean = true;

    loginFormGroup: FormGroup = new FormGroup({
        email: new FormControl(),
        password: new FormControl()
    });


    // Methods
    validateLoginUser = () => {
        console.log(this.loginFormGroup);
    }

    formReset = () => {
        this.loginFormGroup.reset();
    }


}