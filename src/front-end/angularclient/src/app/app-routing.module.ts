import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AssetListComponent} from "./asset-list/asset-list/asset-list.component";
import {AssetFormComponent} from "./asset-form/asset-form.component";
import {UserListComponent} from "./user-list/user-list.component";
import {UserFormComponent} from "./user-form/user-form.component";
import {AssettypeListComponent} from "./assettype-list/assettype-list/assettype-list.component";
import {PlaybookListComponent} from "./playbook-list/playbook-list/playbook-list.component";
import {PlaybookFormComponent} from "./playbook-form/playbook-form/playbook-form.component";
import {AssettypeFormComponent} from "./assettype-form/assettype-form/assettype-form.component";

const routes: Routes = [
  {path: 'assets', component:AssetListComponent},
  {path: 'addAsset', component:AssetFormComponent},
  {path: 'users', component:UserListComponent},
  {path: 'editUser', component:UserFormComponent},
  {path: 'assettypes', component:AssettypeListComponent},
  {path: 'addAssettype', component:AssettypeFormComponent},
  {path: 'playbooks', component:PlaybookListComponent},
  {path: 'addPlaybook', component:PlaybookFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
