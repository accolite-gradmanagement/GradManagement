import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HomeComponent } from './component/home/home.component';
import { ViewdetailsComponent } from './component/viewdetails/viewdetails.component';
import { DemanddetailsComponent } from './demand/demanddetails/demanddetails.component';
import { DemandformComponent } from './demand/demandform/demandform.component';
import { DemandService } from './provider/demand.service';
import { AppComponent } from './app.component';
import { MainModule } from './main/main.module';
import { AppRoutingModule } from './app-routing.module';
import { CoursesModule } from './courses/courses.module';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { MatSelectModule } from '@angular/material/select';
import * as moment from 'moment';
import { MultiSelectAllModule } from '@syncfusion/ej2-angular-dropdowns';
import { AngularDateTimePickerModule} from 'angular2-datetimepicker';
import {HeaderComponent} from '../app/courses/header/header.component';
import { GradService } from './grad.service';
import { ConfirmationDialogComponent } from './gradManagement/confirmation-dialog/confirmation-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { AngularFontAwesomeModule } from 'angular-font-awesome';


@NgModule({
  declarations: [
    AppComponent, ConfirmationDialogComponent,
   
    HomeComponent,
    ViewdetailsComponent,
    DemanddetailsComponent,
    DemandformComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MainModule,
    HttpClientModule,
    CoursesModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
   NgMultiSelectDropDownModule.forRoot(),
   MatSelectModule,
   MultiSelectAllModule,
   AngularDateTimePickerModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatButtonModule,
    AngularFontAwesomeModule
  ],
  providers: [DemandService, GradService],
  bootstrap: [AppComponent],
  exports: [ConfirmationDialogComponent],

  entryComponents: [ConfirmationDialogComponent],
})
export class AppModule { }
