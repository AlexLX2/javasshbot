import { TestBed } from '@angular/core/testing';

import { WebUserService } from './web-user.service';

describe('WebUserService', () => {
  let service: WebUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WebUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
