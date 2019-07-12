import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GradmanagementRoutingModule } from './gradmanagement-routing.module';
import { AddEditComponent } from './add-edit/add-edit.component';
import { FormsModule } from '@angular/forms';
import { GradDetailsComponent } from './grad-details/grad-details.component';
import { AngularDateTimePickerModule } from 'angular2-datetimepicker';

@NgModule({
  declarations: [AddEditComponent, GradDetailsComponent],
  imports: [
    CommonModule,
    GradmanagementRoutingModule,
    FormsModule,
    AngularDateTimePickerModule
  ]
})
export class GradmanagementModule { }
