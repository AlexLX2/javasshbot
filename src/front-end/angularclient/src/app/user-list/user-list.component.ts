import { Component, OnInit } from '@angular/core';
import {User} from "../user";
import {UserService} from "../_services/user.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[] | undefined;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

  updateUser(user: User):Observable<User> {
    return this.userService.save(user);
  }

}
