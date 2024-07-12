import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventePageComponent } from './evente-page.component';

describe('EventePageComponent', () => {
  let component: EventePageComponent;
  let fixture: ComponentFixture<EventePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EventePageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EventePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
