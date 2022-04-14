import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Playbook} from "../playbook";
import {PlaybookService} from "../_services/playbook.service";

@Component({
  selector: 'app-playbook-form',
  templateUrl: './playbook-form.component.html',
  styleUrls: ['./playbook-form.component.css']
})
export class PlaybookFormComponent {

  playbook: Playbook;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private playbookService: PlaybookService) {
    this.playbook = new Playbook();
  }

  onSubmit() {
    this.playbookService.save(this.playbook).subscribe(() => this.goToList())
  }

  goToList() {
    this.router.navigate(['/playbooks']);
  }

}
