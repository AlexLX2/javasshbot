import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Playbook} from "../playbook/playbook";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PlaybookService {

  private playbookUrl: string;

  constructor(private http: HttpClient) {
    this.playbookUrl=environment.base_url + "playbooks";
  }

  public findAll(): Observable<Playbook[]>{
    return this.http.get<Playbook[]>(this.playbookUrl)
  }

  public save(playbook : Playbook) {
    return this.http.post<Playbook>(this.playbookUrl, playbook);
  }
}
