import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Playbook} from "../playbook";

@Injectable({
  providedIn: 'root'
})
export class PlaybookService {

  private playbookUrl: string;

  constructor(private http: HttpClient) {
    this.playbookUrl="http://172.30.30.13:8080/api/playbooks";
  }

  public findAll(): Observable<Playbook[]>{
    return this.http.get<Playbook[]>(this.playbookUrl)
  }

  public save(playbook : Playbook) {
    return this.http.post<Playbook>(this.playbookUrl, playbook);
  }
}
