import { BuildingattendantService } from './../../service/buildingattendant.service';
import { Component, OnInit } from '@angular/core';
import { Tenant } from '../../model/tenant.model';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-building',
  templateUrl: './building.component.html',
  styleUrls: ['./building.component.css']
})
export class BuildingComponent implements OnInit {

  buildingId: number;
  tenants: [Tenant];
  resp: any;

  constructor(private service: BuildingattendantService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.buildingId = this.route.snapshot.queryParams["buildingId"];
    this.service.getOne(this.buildingId).subscribe(
      resp => {
        this.resp = resp;
        console.log(resp);
        this.tenants = this.resp["tenants"];
      }
    )
  }

}
