import { NgModule } from "@angular/core";
import { HomePageComponent } from "./home-page.component";
import { RestaurantModule } from "./restaurant/restaurant.module";
import { MatToolbarModule } from '@angular/material/toolbar';
import { CommonModule } from "@angular/common";
import { CreateRestaurantModule } from "./create-restaurant/create-restaurant.module";

@NgModule({
    declarations: [
        HomePageComponent
    ],
    exports: [
        HomePageComponent
    ],
    imports: [
        CommonModule,
        RestaurantModule,
        MatToolbarModule,
        CreateRestaurantModule
    ]
})
export class HomePageModule {

}