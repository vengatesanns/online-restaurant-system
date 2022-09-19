import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { AppConstants } from "../constants/app-constants";
import { SignUpModel } from "../model/sign-up.model";

@Injectable({
    providedIn: "root"
})
export class SignUpService {

    constructor(private httpClient: HttpClient) {
    }


    registerNewUser(signUpModel: SignUpModel) {
        const LOGIN_API_URL = `${environment.rootApiUrl}${AppConstants.SIGN_UP_URL}`
        return this.httpClient.post(LOGIN_API_URL, signUpModel, { responseType: 'text' });
    }


}