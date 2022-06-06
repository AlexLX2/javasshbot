import { Component} from '@angular/core';
import {Asset} from "../asset";
import {ActivatedRoute, Router} from "@angular/router";
import {AssetService} from "../../_services/asset.service";

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
    this.assetService.save(this.asset).subscribe(() => this.gotoAssetList())
  }

  gotoAssetList(){
    this.router.navigate(['/assets']);
  }

}
