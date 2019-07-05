import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DemanddetailsComponent } from './demand/demanddetails/demanddetails.component';
import { DemandformComponent } from './demand/demandform/demandform.component';

const routes: Routes = [
  { path : 'demanddetails', component: DemanddetailsComponent},
  { path: 'demandform', component: DemandformComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
