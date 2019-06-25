import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { ViewdetailsComponent } from './component/viewdetails/viewdetails.component';
import { HiringComponent } from './model/hiring/hiring.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ViewdetailsComponent,
    HiringComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
