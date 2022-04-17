import { Component, OnInit } from '@angular/core';
import {Playbook} from "../playbook";
import {PlaybookService} from "../_services/playbook.service";

@Component({
  selector: 'app-playbook-list',
  templateUrl: './playbook-list.component.html',
  styleUrls: ['./playbook-list.component.css']
})
export class PlaybookListComponent implements OnInit {

  playbooks: Playbook[] | undefined;

  constructor(private playbookService: PlaybookService) { }

  ngOnInit() {
    this.playbookService.findAll().subscribe(data => {
      this.playbooks =data;
    });
  }

}
