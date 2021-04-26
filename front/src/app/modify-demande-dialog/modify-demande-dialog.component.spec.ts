import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyDemandeDialogComponent } from './modify-demande-dialog.component';

describe('ModifyDemandeDialogComponent', () => {
  let component: ModifyDemandeDialogComponent;
  let fixture: ComponentFixture<ModifyDemandeDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyDemandeDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyDemandeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
