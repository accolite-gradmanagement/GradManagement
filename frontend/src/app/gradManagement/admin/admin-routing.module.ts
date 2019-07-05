import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowgradsComponent } from './showgrads/showgrads.component';

const routes: Routes = [
  {
    path:'',
    component: ShowgradsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
