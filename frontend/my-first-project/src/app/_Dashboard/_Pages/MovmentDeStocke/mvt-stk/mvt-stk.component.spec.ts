import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MvtStkComponent } from './mvt-stk.component';

describe('MvtStkComponent', () => {
  let component: MvtStkComponent;
  let fixture: ComponentFixture<MvtStkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MvtStkComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MvtStkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
