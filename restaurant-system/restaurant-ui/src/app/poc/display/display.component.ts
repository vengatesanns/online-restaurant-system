import { Component, Input, OnInit } from '@angular/core';
import { UserModel } from './display.model';

@Component({
  selector: 'display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {

  @Input('userDetails') userDetails: Array<UserModel> = [];

  constructor() { }

  ngOnInit(): void {
  }

}
