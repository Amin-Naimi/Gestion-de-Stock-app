import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCltFrsComponent } from './new-clt-frs.component';

describe('NewCltFrsComponent', () => {
  let component: NewCltFrsComponent;
  let fixture: ComponentFixture<NewCltFrsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCltFrsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewCltFrsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
