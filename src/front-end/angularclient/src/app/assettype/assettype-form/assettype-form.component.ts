import { Component } from '@angular/core';
import {Assettype} from "../assettype";
import {ActivatedRoute, Router} from "@angular/router";
import {AssettypeService} from "../../_services/assettype.service";

@Component({
  selector: 'app-assettype-form',
  templateUrl: './assettype-form.component.html',
  styleUrls: ['./assettype-form.component.css']
})
export class AssettypeFormComponent {
  assettype: Assettype;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private assettypeService: AssettypeService) {
    this.assettype = new Assettype();
  }

  onSubmit() {
    this.assettypeService.save(this.assettype).subscribe(() => this.goToList())
  }

  goToList() {
    this.router.navigate(['/assettypes']);
  }

}
