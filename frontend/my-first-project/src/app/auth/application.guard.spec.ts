import { TestBed } from '@angular/core/testing';

import { ApplicationGuard } from './application.guard';

describe('ApplicationGuard', () => {
  let guard: ApplicationGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ApplicationGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
