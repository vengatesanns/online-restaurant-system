import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { finalize, Observable, tap } from "rxjs";
import { SpinnerService } from "../services/spinner.service";

@Injectable({
    providedIn: "root"
})
export class AppRequestInterceptor implements HttpInterceptor {

    constructor(private spinnerService: SpinnerService) {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        this.spinnerService.show();
        return next.handle(req).pipe(tap(
            (event: HttpEvent<any>) => {
                if (event instanceof HttpResponse) {
                    console.log("hello");
                }
            },
            (err: HttpErrorResponse) => {
                console.log("error");
            }
        ), finalize(() => {
            this.spinnerService.hide();
        }));
    }

}
