import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AssetListComponent } from './asset/asset-list/asset-list.component';
import { AssetFormComponent } from './asset/asset-form/asset-form.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { UserFormComponent } from './user/user-form/user-form.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { PlaybookFormComponent } from './playbook/playbook-form/playbook-form.component';
import { PlaybookListComponent } from './playbook/playbook-list/playbook-list.component';
import { AssettypeFormComponent } from './assettype/assettype-form/assettype-form.component';
import { AssettypeListComponent } from './assettype/assettype-list/assettype-list.component';
import { LoginComponent } from './authorization/login/login.component';
import { RegisterComponent } from './authorization/register/register.component';
import { HomeComponent } from './pages/home/home.component';
import { ProfileComponent } from './user/profile/profile.component';
import { BoardAdminComponent } from './pages/board-admin/board-admin.component';
import { BoardUserComponent } from './pages/board-user/board-user.component';
import {authInterceptorProviders } from './_helpers/auth.interceptor';

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
    AssettypeListComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
