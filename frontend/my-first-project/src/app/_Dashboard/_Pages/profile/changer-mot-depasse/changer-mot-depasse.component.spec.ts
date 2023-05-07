import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangerMotDepasseComponent } from './changer-mot-depasse.component';

describe('ChangerMotDepasseComponent', () => {
  let component: ChangerMotDepasseComponent;
  let fixture: ComponentFixture<ChangerMotDepasseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangerMotDepasseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChangerMotDepasseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
