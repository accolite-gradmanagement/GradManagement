import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SelectionComponent } from './selection.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import { NewDetailComponent } from './new-detail/new-detail.component';


const routes: Routes = [
 {path:"", component:SelectionComponent},
 
 { path: 'detail/:id', component: StudentDetailComponent },
 { path: 'detail/name/:name', component: StudentDetailComponent },
 { path: 'newDetails', component: NewDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
