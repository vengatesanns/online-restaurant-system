import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs/internal/BehaviorSubject";

@Injectable({
    providedIn: "root"
})
export class SpinnerService {

    private spinnerObservable$ = new BehaviorSubject<Boolean>(false);

    constructor() {

    }

    getSpinnerObservable(): BehaviorSubject<Boolean> {
        return this.spinnerObservable$;
    }


    show() {
        this.spinnerObservable$.next(true);
    }

    hide() {
        this.spinnerObservable$.next(false);
    }


}