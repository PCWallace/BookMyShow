import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TheaterslistComponent } from './theaterslist.component';

describe('TheaterslistComponent', () => {
  let component: TheaterslistComponent;
  let fixture: ComponentFixture<TheaterslistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TheaterslistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TheaterslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
