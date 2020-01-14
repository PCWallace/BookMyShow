import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistertheaterformComponent } from './registertheaterform.component';

describe('RegistertheaterformComponent', () => {
  let component: RegistertheaterformComponent;
  let fixture: ComponentFixture<RegistertheaterformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistertheaterformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistertheaterformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
