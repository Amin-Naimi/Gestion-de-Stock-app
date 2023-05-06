import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCmdCltFrsComponent } from './new-cmd-clt-frs.component';

describe('NewCmdCltFrsComponent', () => {
  let component: NewCmdCltFrsComponent;
  let fixture: ComponentFixture<NewCmdCltFrsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCmdCltFrsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewCmdCltFrsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
