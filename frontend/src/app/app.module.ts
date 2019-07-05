import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule }    from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { ViewdetailsComponent } from './component/viewdetails/viewdetails.component';
import { DemanddetailsComponent } from './demand/demanddetails/demanddetails.component';
import { DemandformComponent } from './demand/demandform/demandform.component';
import { FormsModule} from "@angular/forms"
import { DemandService } from './provider/demand.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ViewdetailsComponent,
    DemanddetailsComponent,
    DemandformComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule 
  ],
  providers: [DemandService],
  bootstrap: [AppComponent]
})
export class AppModule { }
