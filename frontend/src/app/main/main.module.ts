import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SocialLoginModule,AuthServiceConfig,GoogleLoginProvider} from 'ng4-social-login'
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { BrowserModule } from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {FormsModule} from '@angular/forms';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component'



const config = new AuthServiceConfig([
  {
    id : GoogleLoginProvider.PROVIDER_ID,
    provider : new GoogleLoginProvider('327715398123-v2lffecvo5a6tqum73snrje9854gs4qb.apps.googleusercontent.com')
  }
  ],false)
  
  export function provideConfig()
  {
    // console.log(config);
    return config;
  }

@NgModule({
  declarations: [LoginComponent, SignupComponent, HomeComponent, AdminComponent, UserComponent, ResetpasswordComponent],
  imports: [
    CommonModule,
    SocialLoginModule,
    CommonModule,
    BrowserModule,
    ReactiveFormsModule,
    FormsModule
  ],
  exports:[LoginComponent, SignupComponent, AdminComponent],
  providers: [{provide: AuthServiceConfig, useFactory : provideConfig}],
})
export class MainModule { }
