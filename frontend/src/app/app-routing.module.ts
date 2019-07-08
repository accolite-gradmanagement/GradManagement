import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ReportModule} from './report/report.module';
import { MainModule } from './main/main.module';
import { CoursesModule } from './courses/courses.module';

const routes: Routes = [

{path:'', loadChildren: () => MainModule,pathMatch:'full'},
{path:'', loadChildren: () => CoursesModule,pathMatch:'full'},
{
path : 'score',
loadChildren: () => import('./report/report.module').then(mod => mod.ReportModule),
},
{
  path : 'grads',
  loadChildren: () => import('./gradManagement/gradmanagement/gradmanagement.module').then(mod => mod.GradmanagementModule),
},
{
  path : 'admin',
  loadChildren: () => import('./gradManagement/Admin/Admin.module').then(mod => mod.AdminModule),
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
