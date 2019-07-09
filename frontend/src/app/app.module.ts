import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MainModule } from './main/main.module';
import { CoursesModule } from './courses/courses.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { MatSelectModule } from '@angular/material/select';
import * as moment from 'moment';
import { MultiSelectAllModule } from '@syncfusion/ej2-angular-dropdowns';
import {HeaderComponent} from '../app/courses/header/header.component';
import { GradService } from './grad.service';
import { ConfirmationDialogComponent } from './gradManagement/confirmation-dialog/confirmation-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { MatCardModule } from '@angular/material';
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
    AppComponent, ConfirmationDialogComponent,
  ],
  imports: [
    BrowserModule,
    MatCardModule,
    AppRoutingModule,
    MainModule,
    HttpClientModule,
    CoursesModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
   NgMultiSelectDropDownModule.forRoot(),
   MatSelectModule,
   MultiSelectAllModule,
   AngularDateTimePickerModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatDialogModule,
    MatButtonModule,
    AngularFontAwesomeModule,
    BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        CommonModule,
        BrowserAnimationsModule,
        ToastrModule.forRoot()
    
  ],

  exports: [ConfirmationDialogComponent],
  providers: [GradService],
  bootstrap: [AppComponent],
  entryComponents: [ConfirmationDialogComponent],
})
export class AppModule { }
