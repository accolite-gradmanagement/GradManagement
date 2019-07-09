import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DemanddetailsComponent } from './demand/demanddetails/demanddetails.component';
import { DemandformComponent } from './demand/demandform/demandform.component';
import { EmpformComponent } from './demand/empform/empform.component';
import { MainModule } from './main/main.module';
import { CoursesModule } from './courses/courses.module';

const routes: Routes = [
    { path: 'demand', loadChildren: () => import('./demand/demand.module').then(mod => mod.DemandModule) },
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
