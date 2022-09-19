import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
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

    loginForm: FormGroup = new FormGroup({});


    constructor(private _formBuilder: FormBuilder,
        private loginService: LoginService,
        private router: Router) {
    }


    // lifecycle hooks
    ngOnInit() {
        this.loginForm = this._formBuilder.group({
            email: new FormControl(),
            password: new FormControl()
        });
    }


    // Methods
    validateLoginUser() {
        let self = this;
        let email = this.loginForm.value.email;
        let password = this.loginForm.value.password;
        let loginModel: LoginModel = new LoginModel(email, password);
        this.loginService.validateLUserDetails(loginModel).subscribe(response => {
            console.log(response);
            self.router.navigateByUrl("/dashboard");
        }, error => {
            console.error(error);
        });
    }

    formReset = () => {
        this.loginForm.reset();
    }


}
