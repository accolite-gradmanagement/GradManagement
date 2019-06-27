import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from'@angular/forms';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { AppRoutingModule } from './app-routing.module';
import { CommonModule } from '@angular/common';
import {HttpClientModule} from '@angular/common/http'
import { LogincompComponent } from './login/logincomp/logincomp.component';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    LoginModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  // providers: [{provide: LoginGuard, useClass: LoginGuard}],
  bootstrap: [AppComponent]
})
export class AppModule { }
