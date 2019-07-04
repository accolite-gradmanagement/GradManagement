import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CoursesModule } from './courses/courses.module';
import { MainModule } from './main/main.module';

const routes: Routes = [
{path:'', loadChildren: () => MainModule,pathMatch:'full'},
{path:'', loadChildren: () => CoursesModule,pathMatch:'full'},

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
