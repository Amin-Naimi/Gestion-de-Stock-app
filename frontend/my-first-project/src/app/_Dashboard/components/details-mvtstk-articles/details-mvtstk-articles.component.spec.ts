import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsMvtstkArticlesComponent } from './details-mvtstk-articles.component';

describe('DetailsMvtstkArticlesComponent', () => {
  let component: DetailsMvtstkArticlesComponent;
  let fixture: ComponentFixture<DetailsMvtstkArticlesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsMvtstkArticlesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsMvtstkArticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
