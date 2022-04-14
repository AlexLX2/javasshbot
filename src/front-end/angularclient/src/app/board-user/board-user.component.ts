import { Component, OnInit } from '@angular/core';
import { WebUserService } from '../_services/web-user.service';
@Component({
  selector: 'app-board-admin',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  content?: string;
  constructor(private userService: WebUserService) { }
  ngOnInit(): void {
    this.userService.getUserBoard().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }
}
