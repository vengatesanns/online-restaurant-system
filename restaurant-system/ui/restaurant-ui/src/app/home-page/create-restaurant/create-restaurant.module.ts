import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { CreateRestaurantComponent } from "./create-restaurant.component";

@NgModule({
    declarations: [CreateRestaurantComponent],
    imports: [CommonModule],
    exports: [CreateRestaurantComponent]
})
export class CreateRestaurantModule {

}