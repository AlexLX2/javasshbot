import { Injectable } from '@angular/core';
import {Asset} from "../asset";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AssetService {

  private assetUrl: string;

  constructor(private http: HttpClient) {
    this.assetUrl = "http://172.30.30.13:8080/api/assets";
  }

  public findAll(): Observable<Asset[]> {
    return this.http.get<Asset[]>(this.assetUrl);
  }

  public save(asset: Asset) {
    return this.http.post<Asset>(this.assetUrl, asset);
  }
}
