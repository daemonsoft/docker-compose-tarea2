import { TestBed, inject } from '@angular/core/testing';

import { BuildingattendantService } from './buildingattendant.service';

describe('BuildingattendantService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BuildingattendantService]
    });
  });

  it('should be created', inject([BuildingattendantService], (service: BuildingattendantService) => {
    expect(service).toBeTruthy();
  }));
});
