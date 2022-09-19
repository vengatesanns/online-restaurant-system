import { NgModule } from "@angular/core";
import { DashboardComponent } from "./dashboard.component";
import { MatInputModule } from "@angular/material/input";
import { MatIconModule } from "@angular/material/icon";
import { MatCardModule } from "@angular/material/card";
import { MatButtonModule } from "@angular/material/button";
import { ReactiveFormsModule } from "@angular/forms";

@NgModule({
    imports: [MatInputModule,
        MatIconModule,
        MatCardModule,
        MatButtonModule,
        ReactiveFormsModule],
    declarations: [DashboardComponent],
    exports: [DashboardComponent]
})
export class DashboardModule {

}