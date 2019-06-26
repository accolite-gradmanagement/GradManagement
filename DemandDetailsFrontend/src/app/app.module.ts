import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule }    from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { ViewdetailsComponent } from './component/viewdetails/viewdetails.component';
import { DemanddetailsComponent } from './demand/demanddetails/demanddetails.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ViewdetailsComponent,
    DemanddetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
