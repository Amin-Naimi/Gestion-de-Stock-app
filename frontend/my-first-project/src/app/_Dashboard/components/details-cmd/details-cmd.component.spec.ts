import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsCmdComponent } from './details-cmd.component';

describe('DetailsCmdComponent', () => {
  let component: DetailsCmdComponent;
  let fixture: ComponentFixture<DetailsCmdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsCmdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsCmdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
