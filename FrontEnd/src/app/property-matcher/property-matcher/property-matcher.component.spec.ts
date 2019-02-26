import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyMatcherComponent } from './property-matcher.component';
import {CommonModule} from '@angular/common';
import {DialogsModule} from 'eds-angular4';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {By} from '@angular/platform-browser';

describe('PropertyMatcherComponent', () => {
  let component: PropertyMatcherComponent;
  let fixture: ComponentFixture<PropertyMatcherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        CommonModule,
        DialogsModule,
        NgbModule.forRoot()
      ],
      declarations: [ PropertyMatcherComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropertyMatcherComponent);
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
