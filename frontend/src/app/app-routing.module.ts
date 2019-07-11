import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DemanddetailsComponent } from './demand/demanddetails/demanddetails.component';
import { DemandformComponent } from './demand/demandform/demandform.component';
import { EmpformComponent } from './demand/empform/empform.component';
import { MainModule } from './main/main.module';
import { CoursesModule } from './courses/courses.module';
import { AdminguardGuard } from './adminguard.guard';

const routes: Routes = [
    { path: 'demand', loadChildren: () => import('./demand/demand.module').then(mod => mod.DemandModule) ,
    canActivate: [AdminguardGuard]
    },
    {path:'', loadChildren: () => import('./demand/demand.module').then(mod => mod.DemandModule),
    
  },
{path:'course', loadChildren: () => import('./courses/courses.module').then(mod =>mod.CoursesModule),canActivate: [AdminguardGuard]},
{
path : 'score',
loadChildren: () => import('./report/report.module').then(mod => mod.ReportModule),canActivate: [AdminguardGuard],

},
{
  path : 'grads',
  loadChildren: () => import('./gradManagement/gradmanagement/gradmanagement.module').then(mod => mod.GradmanagementModule),
  canActivate: [AdminguardGuard]
},
{
  path : 'admin',
  loadChildren: () => import('./gradManagement/Admin/Admin.module').then(mod => mod.AdminModule),
  canActivate: [AdminguardGuard]
},
// {
//   path:'',redirectTo:'main',pathMatch:'full'
// }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
