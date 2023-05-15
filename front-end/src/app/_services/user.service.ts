import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../user/user";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userUrl: string;

  constructor(private http: HttpClient) {
    this.userUrl=environment.base_url + "users";
  }

  public findAll(): Observable<User[]>{
    return this.http.get<User[]>(this.userUrl)
  }

  public save(user : User) {
    return this.http.post<User>(this.userUrl, user);
  }
}
