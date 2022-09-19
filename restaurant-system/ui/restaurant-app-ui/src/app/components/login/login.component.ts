import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { LoginModel } from "src/app/model/login.model";
import { LoginService } from "src/app/services/login.service";

@Component({
    selector: "login",
    templateUrl: "./login.component.html",
    styleUrls: ["./login.scss"]
})
export class LoginComponent implements OnInit {

    // Variable Declarations
    hide: Boolean = true;
    loginFormGroup: FormGroup;


    constructor(private formBuilder: FormBuilder, private loginService: LoginService) {
        this.loginFormGroup = this.formBuilder.group({
            email: [],
            password: []
        });
    }


    // lifecycle hooks
    ngOnInit() {

    }


    // Methods
    validateLoginUser() {
        console.log(this.loginFormGroup);
        let email = this.loginFormGroup.value.email;
        let password = this.loginFormGroup.value.password;
        let loginModel: LoginModel = new LoginModel(email, password);
        this.loginService.validateLUserDetails(loginModel).subscribe(response => {
            console.log(response);
        }, error => {
            console.error(error);
        });
    }

    formReset = () => {
        this.loginFormGroup.reset();
    }


}