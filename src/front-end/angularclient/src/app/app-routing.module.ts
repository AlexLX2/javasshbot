import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AssetListComponent} from "./asset-list/asset-list.component";
import {AssetFormComponent} from "./asset-form/asset-form.component";
import {UserListComponent} from "./user-list/user-list.component";
import {UserFormComponent} from "./user-form/user-form.component";
import {AssettypeListComponent} from "./assettype-list/assettype-list.component";
import {PlaybookListComponent} from "./playbook-list/playbook-list.component";
import {PlaybookFormComponent} from "./playbook-form/playbook-form.component";
import {AssettypeFormComponent} from "./assettype-form/assettype-form.component";
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {ProfileComponent} from "./profile/profile.component";
import {BoardAdminComponent} from "./board-admin/board-admin.component";
import {BoardModeratorComponent} from "./board-moderator/board-moderator.component";
import {BoardUserComponent} from "./board-user/board-user.component";

const routes: Routes = [
  {path: 'assets', component:AssetListComponent},
  {path: 'addAsset', component:AssetFormComponent},
  {path: 'users', component:UserListComponent},
  {path: 'editUser', component:UserFormComponent},
  {path: 'assettypes', component:AssettypeListComponent},
  {path: 'addAssettype', component:AssettypeFormComponent},
  {path: 'playbooks', component:PlaybookListComponent},
  {path: 'addPlaybook', component:PlaybookFormComponent},
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
