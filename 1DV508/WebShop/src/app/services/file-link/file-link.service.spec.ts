import { TestBed } from '@angular/core/testing';

import { FileLinkService } from './file-link.service';

describe('FileLinkService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FileLinkService = TestBed.get(FileLinkService);
    expect(service).toBeTruthy();
  });
});
