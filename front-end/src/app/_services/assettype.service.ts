import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Assettype} from "../assettype/assettype";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AssettypeService {
  private assettypeUrl: string;

  constructor(private http: HttpClient) {
    this.assettypeUrl=environment.base_url + "assettypes";
  }

  public findAll(): Observable<Assettype[]>{
    return this.http.get<Assettype[]>(this.assettypeUrl)
  }

  public save(assettype : Assettype) {
    return this.http.post<Assettype>(this.assettypeUrl, assettype);
  }
}
