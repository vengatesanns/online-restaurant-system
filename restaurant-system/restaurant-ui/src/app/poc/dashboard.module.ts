import { NgModule } from "@angular/core";
import { RegisterComponent } from "./register/register.component";
import { DashboardComponent } from "./dashboard.component";
import { DisplayComponent } from './display/display.component';
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";

@NgModule({
    declarations: [DashboardComponent, RegisterComponent, DisplayComponent],
    exports: [DashboardComponent, DisplayComponent],
    imports: [CommonModule, FormsModule]
})
export class DashboardModule { }