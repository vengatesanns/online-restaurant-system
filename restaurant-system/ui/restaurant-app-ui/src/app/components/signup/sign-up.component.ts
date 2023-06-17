import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { SignUpModel } from "src/app/model/sign-up.model";
import { SignUpService } from "src/app/services/sign-up.service";

@Component({
    selector: "sign-up",
    templateUrl: "./sign-up.component.html",
    styleUrls: ["sign-up.scss"]
})
export class SignUpComponent {

    signUpForm: FormGroup = new FormGroup({});

    constructor(private _formBuilder: FormBuilder, private _signUpService: SignUpService) {
        this.signUpForm = this._formBuilder.group({
            firstName: ['', Validators.required], 
            lastName: [''],
            email: ['', [Validators.required, Validators.email]],
            phoneNumber: ['', Validators.required],
            password: ['', Validators.required],
            confirmPassword: ['', Validators.required]
        });
    }


    registerNewUser() {
        const signUpUserModel = this._setControlValuesToModel();
        this._signUpService.registerNewUser(signUpUserModel).subscribe(response => {
            alert(response);
        }, error => {

        });
    }


    _setControlValuesToModel(): SignUpModel {
        const signUpUserModel: SignUpModel = new SignUpModel();
        signUpUserModel.firstName = this.signUpForm.value.firstName;
        signUpUserModel.lastName = this.signUpForm.value.lastName;
        signUpUserModel.email = this.signUpForm.value.email;
        signUpUserModel.phoneNumber = this.signUpForm.value.phoneNumber;
        signUpUserModel.password = this.signUpForm.value.password;
        return signUpUserModel;
    }


    signUpFormReset() {
        this.signUpForm.reset();
    }

}