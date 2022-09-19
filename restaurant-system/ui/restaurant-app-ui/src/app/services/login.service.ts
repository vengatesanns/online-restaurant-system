import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { AppConstants } from 'src/app/constants/app-constants'
import { LoginModel } from "../model/login.model";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class LoginService {
    constructor(private httpClient: HttpClient) {

    }

    // Login - Validate User Login
    validateLUserDetails = (loginModel: LoginModel) => {
        const httpHeaders = new HttpHeaders({
            "Authorization": `Basic ${btoa(loginModel.username + ':' + loginModel.password)}`
        });
        const LOGIN_API_URL = `${environment.rootApiUrl}${AppConstants.LOGIN_API_URL}`
        return this.httpClient.get(LOGIN_API_URL, { headers: httpHeaders, responseType: 'text' });
    }


}