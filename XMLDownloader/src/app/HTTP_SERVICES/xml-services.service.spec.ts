import { TestBed } from '@angular/core/testing';

import { XMLServicesService } from './xml-services.service';

describe('XMLServicesService', () => {
  let service: XMLServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(XMLServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
