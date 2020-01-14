import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlacedorderviewComponent } from './placedorderview.component';

describe('PlacedorderviewComponent', () => {
  let component: PlacedorderviewComponent;
  let fixture: ComponentFixture<PlacedorderviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlacedorderviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlacedorderviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
