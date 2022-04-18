import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaybookListComponent } from './playbook-list.component';

describe('PlaybookListComponent', () => {
  let component: PlaybookListComponent;
  let fixture: ComponentFixture<PlaybookListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlaybookListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaybookListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
