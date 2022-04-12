import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AssetListComponent } from './asset-list/asset-list/asset-list.component';
import { AssetFormComponent } from './asset-form/asset-form.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { UserFormComponent } from './user-form/user-form.component';
import { UserListComponent } from './user-list/user-list.component';
import { PlaybookFormComponent } from './playbook-form/playbook-form/playbook-form.component';
import { PlaybookListComponent } from './playbook-list/playbook-list/playbook-list.component';
import { AssettypeFormComponent } from './assettype-form/assettype-form/assettype-form.component';
import { AssettypeListComponent } from './assettype-list/assettype-list/assettype-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AssetListComponent,
    AssetFormComponent,
    UserFormComponent,
    UserListComponent,
    PlaybookFormComponent,
    PlaybookListComponent,
    AssettypeFormComponent,
    AssettypeListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
