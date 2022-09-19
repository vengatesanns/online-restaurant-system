import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { LoginModel } from "src/app/model/login.model";
import { LoginService } from "src/app/services/login.service";

@Component({
    selector: "login",
    templateUrl: "./login.component.html",
    styleUrls: ["./login.scss"]
})
export class LoginComponent implements OnInit {

    // Variable Declarations

    loginFormGroup: FormGroup = this.fb.group({
        email: [],
        password: []
    });


    constructor(private fb: FormBuilder,
        private loginService: LoginService,
        private router: Router) {
        console.log(this.fb);
    }


    // lifecycle hooks
    ngOnInit() {
    }


    // Methods
    validateLoginUser() {
        let self = this;
        let email = this.loginFormGroup.value.email;
        let password = this.loginFormGroup.value.password;
        let loginModel: LoginModel = new LoginModel(email, password);
        this.loginService.validateLUserDetails(loginModel).subscribe(response => {
            console.log(response);
            self.router.navigateByUrl("/dashboard");
        }, error => {
            console.error(error);
        });
    }

    formReset = () => {
        this.loginFormGroup.reset();
    }


}
