import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { ReportRoutingModule } from './report-routing.module';
import { FrontComponent } from './front/front.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { NewDetailsComponent } from './new-details/new-details.component';
import { AgGridModule } from 'ag-grid-angular';
//import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [FrontComponent, StudentDetailsComponent, NewDetailsComponent],
  imports: [
    CommonModule,
    ReportRoutingModule,
    FormsModule  ,
    ReactiveFormsModule,  
    AgGridModule.withComponents([StudentDetailsComponent]),
    //BrowserAnimationsModule,
	  
  ]
})
export class ReportModule { }
