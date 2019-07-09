import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DemanddetailsComponent } from './demand/demanddetails/demanddetails.component';
import { DemandformComponent } from './demand/demandform/demandform.component';
import { EmpformComponent } from './demand/empform/empform.component';

const routes: Routes = [
    { path: 'demand', loadChildren: () => import('./demand/demand.module').then(mod => mod.DemandModule) }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
