import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ToastModule} from 'ng2-toastr/ng2-toastr';
import {ControlsModule} from "eds-angular4/dist/controls";
import {ModuleStateService} from "eds-angular4/dist/common";
import {DialogsModule, LoggerService} from 'eds-angular4';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {PropertyMatcherComponent} from './property-matcher/property-matcher.component';
import {PropertyMatcherService} from './property-matcher/property-matcher.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    DialogsModule,
    NgbModule,
    ToastModule.forRoot(),
    ControlsModule
  ],
  declarations: [PropertyMatcherComponent],
  entryComponents: [PropertyMatcherComponent],
  providers: [PropertyMatcherService, LoggerService, ModuleStateService]
})
export class PropertyMatcherModule { }
