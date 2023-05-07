import { TestBed } from '@angular/core/testing';

import { EnServiceService } from './en-service.service';

describe('EnServiceService', () => {
  let service: EnServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EnServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
