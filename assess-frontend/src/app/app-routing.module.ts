import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SelectionComponent } from './selection.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';


const routes: Routes = [
 {path:"check", component:SelectionComponent},
 {path:"",  redirectTo: '/check', pathMatch: 'full'},
 { path: 'detail/:id', component: StudentDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
