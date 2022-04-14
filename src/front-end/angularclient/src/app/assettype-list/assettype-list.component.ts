import { Component, OnInit } from '@angular/core';
import {Assettype} from "../assettype";
import {AssettypeService} from "../_services/assettype.service";

@Component({
  selector: 'app-assettype-list',
  templateUrl: './assettype-list.component.html',
  styleUrls: ['./assettype-list.component.css']
})
export class AssettypeListComponent implements OnInit {

  assettypes: Assettype[] | undefined;

  constructor(private assettypeService: AssettypeService) { }

  ngOnInit() {
    this.assettypeService.findAll().subscribe(data => {
      this.assettypes =data;
    });
  }
}
