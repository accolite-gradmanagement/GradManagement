import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SocialLoginModule,AuthServiceConfig,GoogleLoginProvider} from 'ng4-social-login'
import { LoginComponent } from './login/login.component';


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
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    SocialLoginModule
  ],
  exports:[LoginComponent],
  providers: [{provide: AuthServiceConfig, useFactory : provideConfig}],
})
export class MainModule { }
