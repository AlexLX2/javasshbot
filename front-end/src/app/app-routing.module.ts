import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AssetListComponent} from "./asset/asset-list/asset-list.component";
import {AssetFormComponent} from "./asset/asset-form/asset-form.component";
import {UserListComponent} from "./user/user-list/user-list.component";
import {UserFormComponent} from "./user/user-form/user-form.component";
import {AssettypeListComponent} from "./assettype/assettype-list/assettype-list.component";
import {PlaybookListComponent} from "./playbook/playbook-list/playbook-list.component";
import {PlaybookFormComponent} from "./playbook/playbook-form/playbook-form.component";
import {AssettypeFormComponent} from "./assettype/assettype-form/assettype-form.component";
import {HomeComponent} from "./pages/home/home.component";
import {LoginComponent} from "./authorization/login/login.component";
import {RegisterComponent} from "./authorization/register/register.component";
import {ProfileComponent} from "./user/profile/profile.component";
import {BoardAdminComponent} from "./pages/board-admin/board-admin.component";
import {BoardUserComponent} from "./pages/board-user/board-user.component";

const routes: Routes = [
  {path: 'assets', component:AssetListComponent},
  {path: 'addAsset', component:AssetFormComponent},
  {path: 'users', component:UserListComponent},
  {path: 'editUser', component:UserFormComponent},
  {path: 'assettypes', component:AssettypeListComponent},
  {path: 'addAssettype', component:AssettypeFormComponent},
  {path: 'playbooks', component:PlaybookListComponent},
  {path: 'addPlaybook', component:PlaybookFormComponent},
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'admin', component: BoardAdminComponent }
  // ,
  // { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
