import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsClFrsComponent } from './details-cl-frs.component';

describe('DetailsClFrsComponent', () => {
  let component: DetailsClFrsComponent;
  let fixture: ComponentFixture<DetailsClFrsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsClFrsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsClFrsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
