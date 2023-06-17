import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { DashboardModule } from './components/dashboard/dashboard.module';
import { AppRoutingModule } from './routers/app-routing.module';
import { MatInputModule } from "@angular/material/input";
import { MatIconModule } from "@angular/material/icon";
import { MatCardModule } from "@angular/material/card";
import { MatButtonModule } from "@angular/material/button";
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";
import { ReactiveFormsModule } from "@angular/forms";
import { LoginComponent } from './components/login/login.component';
import { SignUpComponent } from './components/signup/sign-up.component';
import { SpinnerComponent } from './components/utils/spinner/spinner.component';
import { AppRequestInterceptor } from './interceptors/app-request.interceptor';
import { PopoverModule } from 'ngx-bootstrap/popover';

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    DashboardModule,
    AppRoutingModule,
    MatInputModule,
    MatIconModule,
    MatCardModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatProgressSpinnerModule,
    PopoverModule.forRoot()
  ],

  declarations: [
    AppComponent,
    LoginComponent,
    SignUpComponent,
    SpinnerComponent
  ],

  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AppRequestInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
