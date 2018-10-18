import { TestBed, inject } from '@angular/core/testing';

import { BuildingmanagerService } from './buildingmanager.service';

describe('BuildingmanagerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BuildingmanagerService]
    });
  });

  it('should be created', inject([BuildingmanagerService], (service: BuildingmanagerService) => {
    expect(service).toBeTruthy();
  }));
});
