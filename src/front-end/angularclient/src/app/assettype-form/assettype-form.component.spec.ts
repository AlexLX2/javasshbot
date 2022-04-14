import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssettypeFormComponent } from './assettype-form.component';

describe('AssettypeFormComponent', () => {
  let component: AssettypeFormComponent;
  let fixture: ComponentFixture<AssettypeFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssettypeFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssettypeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
