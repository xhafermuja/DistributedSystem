import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LendetPageComponent } from './lendet-page.component';

describe('LendetPageComponent', () => {
  let component: LendetPageComponent;
  let fixture: ComponentFixture<LendetPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LendetPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LendetPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
