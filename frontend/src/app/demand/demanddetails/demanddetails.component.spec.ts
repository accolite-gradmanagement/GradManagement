import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemanddetailsComponent } from './demanddetails.component';

describe('DemanddetailsComponent', () => {
  let component: DemanddetailsComponent;
  let fixture: ComponentFixture<DemanddetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemanddetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemanddetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
