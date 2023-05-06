import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewUtilisteurComponent } from './new-utilisteur.component';

describe('NewUtilisteurComponent', () => {
  let component: NewUtilisteurComponent;
  let fixture: ComponentFixture<NewUtilisteurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewUtilisteurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewUtilisteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
