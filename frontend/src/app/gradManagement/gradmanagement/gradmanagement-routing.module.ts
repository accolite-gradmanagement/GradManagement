import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEditComponent } from './add-edit/add-edit.component';
import { GradDetailsComponent } from './grad-details/grad-details.component';


const routes: Routes = [
  {
    path:'fill',
    component: AddEditComponent
  },
  {
    path:'fill/:id',
    component: AddEditComponent
  },
  {
    path:':id',
    component: GradDetailsComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GradmanagementRoutingModule { }
