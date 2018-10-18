import { Router } from '@angular/router';
import { BuildingattendantService } from './../../service/buildingattendant.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  buildingId: string = "";
  tenantId: string = "";

  display = 'none';

  constructor(private buildingattendantService: BuildingattendantService, private router: Router) { }

  ngOnInit() {
  }

  validateData(buildingIdInput, tenantIdInput) {
    this.buildingId = buildingIdInput.toUpperCase();
    this.tenantId = tenantIdInput.toUpperCase();
    this.openModal();
  }

  checkOutClick() {
    this.buildingattendantService.checkOut(this.buildingId, this.tenantId).subscribe(
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
  
  onKeyTenantId(event: any) {
    this.buildingId = event.target.value;
  }

  openModal() {
    this.display = 'block';
  }

  closeModal() {
    this.display = 'none';
  }

}
