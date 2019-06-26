import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GradComponent } from './login/grad/grad.component';
import { AdminComponent } from './login/admin/admin.component';
import { LogincompComponent } from './login/logincomp/logincomp.component';

const routes: Routes = [

{path:'grad',component:GradComponent},
{path:'admin',component:AdminComponent},
{path:'',component:LogincompComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
