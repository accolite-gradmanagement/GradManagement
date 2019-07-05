import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandformComponent } from './demandform.component';

describe('DemandformComponent', () => {
  let component: DemandformComponent;
  let fixture: ComponentFixture<DemandformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
