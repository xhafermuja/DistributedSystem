import { Routes } from '@angular/router';
import { IndexPageComponent } from './components/main/index-page/index-page.component';
import { DepartmentPageComponent } from './components/main/department-page/department-page.component';
import { EventePageComponent } from './components/main/evente-page/evente-page.component';
import { LendetPageComponent } from './components/main/lendet-page/lendet-page.component';
import { NotFoundPageComponent } from './components/main/not-found-page/not-found-page.component';
import { KontaktPageComponent } from './components/main/kontakt-page/kontakt-page.component';
import { LoginPageComponent } from './components/main/login-page/login-page.component';
import { AdminPageComponent } from './components/main/admin-page/admin-page.component';

export const routes: Routes = [
    { path: '', redirectTo:'index-page', pathMatch: 'full'},
    { path: 'index-page', component: IndexPageComponent},
    { path: 'department-page', component: DepartmentPageComponent},
    { path: 'evente-page', component: EventePageComponent},
    { path: 'lendet-page', component: LendetPageComponent},
    { path: 'kontakt-page', component: KontaktPageComponent},
    { path: 'login-page', component: LoginPageComponent},
    { path: 'admin-page', component: AdminPageComponent},
    { path: '**', component: NotFoundPageComponent}
];
