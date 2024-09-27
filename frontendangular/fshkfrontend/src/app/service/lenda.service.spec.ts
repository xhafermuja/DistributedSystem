import { TestBed } from '@angular/core/testing';

import { LendaService } from './lenda.service';

describe('LendaService', () => {
  let service: LendaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LendaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
