import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowgradsComponent } from './showgrads.component';

describe('ShowgradsComponent', () => {
  let component: ShowgradsComponent;
  let fixture: ComponentFixture<ShowgradsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowgradsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowgradsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
