import { NgModule, } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

import { AuthGuard } from './_helpers/auth.guard';

const routes: Routes = [
{ path: 'login', component: LoginComponent},
{ path: '', component: HomeComponent, canActivate: [AuthGuard] }, 
{ path: 'home', component: HomeComponent, canActivate: [AuthGuard]  },
{ path: '**', redirectTo: '' }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
