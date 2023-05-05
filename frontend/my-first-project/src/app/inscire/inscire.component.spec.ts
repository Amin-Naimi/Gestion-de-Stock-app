import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscireComponent } from './inscire.component';

describe('InscireComponent', () => {
  let component: InscireComponent;
  let fixture: ComponentFixture<InscireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscireComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InscireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
