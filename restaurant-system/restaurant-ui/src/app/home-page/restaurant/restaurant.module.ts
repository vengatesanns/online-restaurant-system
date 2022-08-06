import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantComponent } from './restaurant.component';
import { MatListModule } from '@angular/material/list'
import { MatButtonModule } from '@angular/material/button'
import { MatCardModule } from '@angular/material/card'



@NgModule({
  declarations: [RestaurantComponent],
  imports: [
    CommonModule,
    MatListModule,
    MatButtonModule,
    MatCardModule
  ],
  exports: [RestaurantComponent]
})
export class RestaurantModule { }
