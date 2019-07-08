import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentDetailsComponent} from './student-details/student-details.component';
import {NewDetailsComponent} from './new-details/new-details.component';
import {FrontComponent} from './front/front.component';
import { FormsModule } from '@angular/forms';
import { ToastrModule, ToastContainerModule } from 'ngx-toastr';
const routes: Routes = [
 { path: '', component: FrontComponent },
 { path: 'detail/:id', component: StudentDetailsComponent },

 { path: 'detail/name/:name', component: StudentDetailsComponent },
 { path: 'newDetails', component: NewDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes),
    FormsModule,
    ToastrModule.forRoot({ positionClass: 'inline' }),
    ToastContainerModule
     ],
  exports: [RouterModule]
})
export class ReportRoutingModule { }
