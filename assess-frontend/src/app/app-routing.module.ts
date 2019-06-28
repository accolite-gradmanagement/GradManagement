import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SelectionComponent } from './selection.component';

const routes: Routes = [
 {path:"check", component:SelectionComponent},
 {path:"",  redirectTo: '/check', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
