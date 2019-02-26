import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyServiceComponent } from './property-service.component';
import {CommonModule} from '@angular/common';
import {DialogsModule} from 'eds-angular4';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {By} from '@angular/platform-browser';

describe('PropertyServiceComponent', () => {
  let component: PropertyServiceComponent;
  let fixture: ComponentFixture<PropertyServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        CommonModule,
        DialogsModule,
        NgbModule.forRoot()
      ],
      declarations: [ PropertyServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropertyServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('should have 4 users', () => {
    expect(component.tableData.length).toBe(4);
  });

  it('should have enabled "Show dialog" button', () => {
    const btn: any = fixture.debugElement.query(By.css('#showDialog')).nativeElement;
    expect(btn.disabled).toBe(false);
  });
});
