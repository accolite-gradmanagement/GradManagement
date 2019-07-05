import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DemandRoutingModule } from './demand-routing.module';
import { DemanddetailsComponent } from './demanddetails/demanddetails.component';
import { DemandformComponent } from './demandform/demandform.component';
import { HomeComponent } from './home/home.component';
import { EmpformComponent } from './empform/empform.component';
import { FormsModule } from '@angular/forms';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { DemandService } from './provider/demand.service';
import { AngularDateTimePickerModule } from 'angular2-datetimepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
    declarations: [
        DemanddetailsComponent,
        DemandformComponent,
        HomeComponent,
        EmpformComponent
    ],
    imports: [
        DemandRoutingModule,
        FormsModule,
        CommonModule,
        AngularDateTimePickerModule
    ],
    providers: [DemandService]

})
export class DemandModule { }
