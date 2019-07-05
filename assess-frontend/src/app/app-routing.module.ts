import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ReportModule} from './report/report.module';

const routes: Routes = [
 {path:"", loadChildren: ()=> ReportModule , pathMatch : 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
