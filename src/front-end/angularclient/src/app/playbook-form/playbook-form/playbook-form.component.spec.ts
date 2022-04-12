import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaybookFormComponent } from './playbook-form.component';

describe('PlaybookFormComponent', () => {
  let component: PlaybookFormComponent;
  let fixture: ComponentFixture<PlaybookFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlaybookFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaybookFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
