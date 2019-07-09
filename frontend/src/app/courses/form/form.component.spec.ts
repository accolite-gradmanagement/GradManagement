import { async, ComponentFixture, TestBed } from '@angular/core/testing';

<<<<<<< HEAD:frontend/src/app/courses/form/form.component.spec.ts
import { FormComponent } from './form.component';

describe('FormComponent', () => {
  let component: FormComponent;
  let fixture: ComponentFixture<FormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormComponent ]
=======
import { EmpformComponent } from './empform.component';

describe('EmpformComponent', () => {
  let component: EmpformComponent;
  let fixture: ComponentFixture<EmpformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpformComponent ]
>>>>>>> hiringDetailsCopy-merge-master:frontend/src/app/demand/empform/empform.component.spec.ts
    })
    .compileComponents();
  }));

  beforeEach(() => {
<<<<<<< HEAD:frontend/src/app/courses/form/form.component.spec.ts
    fixture = TestBed.createComponent(FormComponent);
=======
    fixture = TestBed.createComponent(EmpformComponent);
>>>>>>> hiringDetailsCopy-merge-master:frontend/src/app/demand/empform/empform.component.spec.ts
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
