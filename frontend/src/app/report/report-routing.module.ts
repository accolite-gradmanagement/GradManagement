import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentDetailsComponent} from './student-details/student-details.component';
import {NewDetailsComponent} from './new-details/new-details.component';
import {FrontComponent} from './front/front.component';
import { FormsModule } from '@angular/forms';
const routes: Routes = [
 { path: '', component: FrontComponent,pathMatch:'full'},
 { path: 'detail/:id', component: StudentDetailsComponent,pathMatch:'full' },
 { path: 'detail/name/:name', component: StudentDetailsComponent,pathMatch:'full' },
 { path: 'newDetails', component: NewDetailsComponent,pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)
     ],
  exports: [RouterModule]
})
export class ReportRoutingModule { }
