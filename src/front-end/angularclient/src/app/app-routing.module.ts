import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AssetListComponent} from "./asset-list/asset-list/asset-list.component";
import {AssetFormComponent} from "./asset-form/asset-form.component";
import {UserListComponent} from "./user-list/user-list.component";
import {UserFormComponent} from "./user-form/user-form.component";

const routes: Routes = [
  {path: 'assets', component:AssetListComponent},
  {path: 'addAsset', component:AssetFormComponent},
  {path: 'users', component:UserListComponent},
  {path: 'editUser', component:UserFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
