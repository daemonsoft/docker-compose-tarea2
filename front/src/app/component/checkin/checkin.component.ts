import { BuildingattendantService } from './../../service/buildingattendant.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Building, BuildingClass } from '../../model/building.model';

@Component({
  selector: 'app-checkin',
  templateUrl: './checkin.component.html',
  styleUrls: ['./checkin.component.css']
})
export class CheckinComponent implements OnInit {

  buildingId: string = "";
  buildingName: string = "";
  tenantId: string = "";
  tenantName: string = "";
  tenantAge: number = 0;

  building: Building;

  display = 'none';

  constructor(private buildingattendantService: BuildingattendantService, private router: Router) { }

  ngOnInit() {
  }

  validateData(buildingIdInput, buildingNameInput, tenantIdInput, tenantNameInput, tenantAgeInput) {
    this.buildingId = buildingIdInput.toUpperCase();
    this.buildingName = buildingNameInput.toUpperCase();
    this.tenantId = tenantIdInput.toUpperCase();
    this.tenantName = tenantNameInput.toUpperCase();
    this.tenantAge = tenantAgeInput;
    this.openModal();
  }

  checkInClick() {
    this.building = new BuildingClass(this.buildingId, this.buildingName, this.tenantId, this.tenantName, this.tenantAge);
    this.buildingattendantService.checkIn(this.building).subscribe(
      checkInResponse => {
        this.router.navigate(['current']);
        this.closeModal();
      },
      (error) => {
        if (error.status !== 201) {          
          console.log("ERROR......");
          this.closeModal();
        }
        
        this.router.navigate(['current']);
        this.closeModal();
      });
  }

  onKeyBuildingId(event: any) {
    this.buildingId = event.target.value;
  }

  onKeyBuildingName(event: any) {
    this.buildingId = event.target.value;
  }
  
  onKeyTenantId(event: any) {
    this.buildingId = event.target.value;
  }

  onKeyTenantName(event: any) {
    this.buildingId = event.target.value;
  }

  onKeyTenantAge(event: any) {
    this.buildingId = event.target.value;
  }

  openModal() {
    this.display = 'block';
  }

  closeModal() {
    this.display = 'none';
  }
}
