import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GradComponent } from './login/grad/grad.component';
import { AdminComponent } from './login/admin/admin.component';
import { LogincompComponent } from './login/logincomp/logincomp.component';
import { SignUpComponent } from './login/sign-up/sign-up.component';

const routes: Routes = [

{path:'login/grad',component:GradComponent},
{path:'login/signup',component:SignUpComponent},
{path:'login/admin',component:AdminComponent},
{path:'login',component:LogincompComponent},
{path:'',redirectTo:'login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
