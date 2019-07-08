import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MainModule } from './main/main.module';
import { CoursesModule } from './courses/courses.module';
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
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReportModule } from './report/report.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent, ConfirmationDialogComponent,
  ],
  imports: [
    BrowserModule,
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
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ReportModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
    
  ],

  exports: [ConfirmationDialogComponent],
  providers: [GradService],
  bootstrap: [AppComponent],
  entryComponents: [ConfirmationDialogComponent],
})
export class AppModule { }
