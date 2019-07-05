import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DemanddetailsComponent } from './demand/demanddetails/demanddetails.component';
import { DemandformComponent } from './demand/demandform/demandform.component';
import { FormsModule } from '@angular/forms';
import { DemandService } from './demand/provider/demand.service';
import { HomeComponent } from './demand/home/home.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EmpformComponent } from './demand/empform/empform.component';
import { CommonModule } from '@angular/common';
import { AngularDateTimePickerModule } from 'angular2-datetimepicker';

@NgModule({
    declarations: [
        AppComponent

    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        CommonModule,
        BrowserAnimationsModule,
        ToastrModule.forRoot()
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
