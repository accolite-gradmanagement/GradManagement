import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { GradComponent } from './grad/grad.component';
import { AdminComponent } from './admin/admin.component';
import { LogincompComponent } from './logincomp/logincomp.component';
import { SignUpComponent } from './sign-up/sign-up.component';

@NgModule({
  declarations: [ GradComponent,SignUpComponent, AdminComponent, LogincompComponent, SignUpComponent],
  imports: [
    CommonModule,
    FormsModule,
    LoginRoutingModule,
    ReactiveFormsModule,
  ],
  exports:[]
})
export class LoginModule { }
