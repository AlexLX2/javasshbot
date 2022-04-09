import { Component, OnInit } from '@angular/core';
import {Asset} from "../asset";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {AssetService} from "../service/asset.service";

@Component({
  selector: 'app-asset-form',
  templateUrl: './asset-form.component.html',
  styleUrls: ['./asset-form.component.css']
})
export class AssetFormComponent {

  asset: Asset;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private assetService: AssetService) {
    this.asset = new Asset();
  }

  onSubmit(){
    this.assetService.save(this.asset).subscribe(result => this.gotoAssetList())
  }

  gotoAssetList(){
    this.router.navigate(['/assets']);
  }

}
