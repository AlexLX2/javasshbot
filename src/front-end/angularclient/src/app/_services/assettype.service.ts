import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Assettype} from "../assettype";

@Injectable({
  providedIn: 'root'
})
export class AssettypeService {
  private assettypeUrl: string;

  constructor(private http: HttpClient) {
    this.assettypeUrl="http://localhost:8080/assettypes";
  }

  public findAll(): Observable<Assettype[]>{
    return this.http.get<Assettype[]>(this.assettypeUrl)
  }

  public save(assettype : Assettype) {
    return this.http.post<Assettype>(this.assettypeUrl, assettype);
  }
}
