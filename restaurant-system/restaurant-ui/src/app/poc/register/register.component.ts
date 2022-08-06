import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UserModel } from '../display/display.model';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userInfo: UserModel = new UserModel();
  @Output('updateUserDetails') userDetailsEmitter: EventEmitter<UserModel> = new EventEmitter<UserModel>();

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.userDetailsEmitter.next(this.userInfo);
  }

}
