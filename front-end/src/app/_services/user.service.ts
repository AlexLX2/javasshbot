import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../user/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userUrl: string;

  constructor(private http: HttpClient) {
    this.userUrl="http://172.30.30.13:8080/api/users";
  }

  public findAll(): Observable<User[]>{
    return this.http.get<User[]>(this.userUrl)
  }

  public save(user : User) {
    return this.http.post<User>(this.userUrl, user);
  }
}
