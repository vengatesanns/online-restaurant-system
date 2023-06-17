import { HttpClient } from "@angular/common/http";
import { Component, Inject, OnInit } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { LoginModel } from "src/app/model/login.model";
import { LoginService } from "src/app/services/login.service";

@Component({
    selector: "login",
    templateUrl: "./login.component.html",
    styleUrls: ["./login.scss"],
    providers: [{ provide: 'Window', useValue: window }]
})
export class LoginComponent implements OnInit {

    // Variable Declarations

    loginForm: FormGroup = new FormGroup({});
    apiCall: Observable<any> = new Observable();


    constructor(private _formBuilder: FormBuilder,
        private loginService: LoginService,
        private router: Router,
        @Inject('Window') private window: Window,
        private http: HttpClient) {
    }


    // lifecycle hooks
    ngOnInit() {
        this.apiCall = this.http.get("https://jsonplaceholder.typicode.com/comments");
        this.loginForm = this._formBuilder.group({
            email: new FormControl(),
            password: new FormControl()
        });
    }

    test() {
        console.log("Before")
        this.apiCall.subscribe( res => {
            console.log("Subscribed");
        });
        console.log("After")
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


    testFocus() {
        console.log("hello")
    }

    status: boolean = false;
    focusOn() {
       let input: HTMLElement | null =  this.window.document.getElementById("emailID");
       input?.removeAttribute("disabled");
        // input?.blur();

       input?.focus();
    //    input?.setAttribute("readonly", "readonly")
       input?.setAttribute("disabled", "disabled");
       this.loginForm.setValue({'email': 'vvvvv', 'password': 123});
       this.status = true;
    }
}
