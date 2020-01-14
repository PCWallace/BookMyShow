import { TestBed } from '@angular/core/testing';

import { RegistertheaterformService } from './registertheaterform.service';

describe('RegistertheaterformService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegistertheaterformService = TestBed.get(RegistertheaterformService);
    expect(service).toBeTruthy();
  });
});
