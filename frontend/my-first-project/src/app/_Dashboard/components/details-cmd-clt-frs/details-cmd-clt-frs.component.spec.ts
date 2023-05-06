import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsCmdCltFrsComponent } from './details-cmd-clt-frs.component';

describe('DetailsCmdCltFrsComponent', () => {
  let component: DetailsCmdCltFrsComponent;
  let fixture: ComponentFixture<DetailsCmdCltFrsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsCmdCltFrsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsCmdCltFrsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
