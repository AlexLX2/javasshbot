import { Component, OnInit } from '@angular/core';
import {Asset} from "../asset";
import {AssetService} from "../_services/asset.service";

@Component({
  selector: 'app-asset-list',
  templateUrl: './asset-list.component.html',
  styleUrls: ['./asset-list.component.css']
})
export class AssetListComponent implements OnInit {

  assets: Asset[] | undefined;

  constructor(private assetService: AssetService) { }

  ngOnInit() {
    this.assetService.findAll().subscribe(data => {
      this.assets =data;
    });
  }

}
