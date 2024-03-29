import { Injectable } from '@angular/core';
import {Asset} from "../asset/asset";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AssetService {

  private assetUrl: string;

  constructor(private http: HttpClient) {
    this.assetUrl = environment.base_url + "assets";
  }

  public findAll(): Observable<Asset[]> {
    return this.http.get<Asset[]>(this.assetUrl);
  }

  public save(asset: Asset) {
    return this.http.post<Asset>(this.assetUrl, asset);
  }
}
