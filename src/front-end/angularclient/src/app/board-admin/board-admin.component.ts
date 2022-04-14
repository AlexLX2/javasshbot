import { Component, OnInit } from '@angular/core';
import { WebUserService } from '../_services/web-user.service';
@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  content?: string;
  title: string;
  constructor(private userService: WebUserService) {
    this.title = "Admin interface"
  }

  ngOnInit(): void {

    this.userService.getAdminBoard().subscribe({
      next: data => {
        this.content = data;
      }
      ,
      error: err => {
        this.content = JSON.parse(err.error).message;
      }
    });
  }
}
