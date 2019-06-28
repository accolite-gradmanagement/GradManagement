import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HomepageComponent } from './homepage/homepage.component';
import { LogincompComponent } from './logincomp/logincomp.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { BrowserModule } from '@angular/platform-browser';
import { UserDataComponent } from './user-data/user-data.component';
import { CurrentUserComponent } from './current-user/current-user.component';

@NgModule({
  declarations: [ SignUpComponent, HomepageComponent, LogincompComponent, SignUpComponent, UserDataComponent, CurrentUserComponent],
  imports: [
    CommonModule,
    FormsModule,
    LoginRoutingModule,
    ReactiveFormsModule,
    BrowserModule
  ],
  exports:[]
  // providers: [{provide: LoginGuard, useClass: LoginGuard}],
})
export class LoginModule { }
