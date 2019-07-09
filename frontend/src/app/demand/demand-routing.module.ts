import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DemanddetailsComponent } from './demanddetails/demanddetails.component';
import { DemandformComponent } from './demandform/demandform.component';
import { EmpformComponent } from './empform/empform.component';

const routes: Routes = [
    
            { path: 'demanddetails', component: DemanddetailsComponent },
            { path: 'demandform', component: DemandformComponent },
            { path: 'empform', component: EmpformComponent },
        
    
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DemandRoutingModule { }
