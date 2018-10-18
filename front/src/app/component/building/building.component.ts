import { BuildingattendantService } from './../../service/buildingattendant.service';
import { Component, OnInit } from '@angular/core';
import { Tenant } from '../../model/tenant.model';

@Component({
  selector: 'app-building',
  templateUrl: './building.component.html',
  styleUrls: ['./building.component.css']
})
export class BuildingComponent implements OnInit {

  tenants: [Tenant];
  resp: any;

  constructor(private service: BuildingattendantService) { }

  ngOnInit() {
    this.service.getOne('123').subscribe(
      resp => {
        this.resp = resp;
        this.tenants = this.resp["tenants"];
      }
    )
  }

}
