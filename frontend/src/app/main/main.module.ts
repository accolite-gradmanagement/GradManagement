import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SocialLoginModule,AuthServiceConfig,GoogleLoginProvider} from 'ng4-social-login'
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import {ReactiveFormsModule} from '@angular/forms';
import {FormsModule} from '@angular/forms';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { FrontpageComponent } from './frontpage/frontpage.component'
import { RouterModule } from '@angular/router';
import {MainRoutingModule} from './main-routing.module'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';

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
  declarations: [LoginComponent, SignupComponent, HomeComponent, AdminComponent, UserComponent, ResetpasswordComponent, FrontpageComponent],
  imports: [
    CommonModule,
/*     BrowserAnimationsModule,
 */    SocialLoginModule,
    ReactiveFormsModule,
    FormsModule,
    MainRoutingModule,
    ToastrModule.forRoot({
      timeOut: 1000,
      positionClass: "toast-top-right",
      preventDuplicates: true
    })
  ],
  providers: [{provide: AuthServiceConfig, useFactory : provideConfig}],
})
export class MainModule { }
