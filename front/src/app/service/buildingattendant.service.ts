import { RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Building } from '../model/building.model';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BuildingattendantService {

  private url = 'http://localhost:9000';

  constructor(private httpClient: HttpClient) { }

  checkIn(building: Building) {  
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log(JSON.stringify(building));
    return this.httpClient.post(this.url, JSON.stringify(building), { headers: headers }); 
  }

  checkOut(buildingId: string, tenantId: string) {  
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.put(this.url, JSON.stringify({"buildingId": buildingId, "tenantId": tenantId}), { headers: headers }); 
  }

  getOne(buildingId: string) {  
    return this.httpClient.get(this.url+"/"+buildingId);
  }
}
