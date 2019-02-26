import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ToastModule} from 'ng2-toastr/ng2-toastr';
import {ControlsModule} from "eds-angular4/dist/controls";
import {ModuleStateService} from "eds-angular4/dist/common";
import {DialogsModule, LoggerService} from 'eds-angular4';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {PropertyServiceComponent} from './property-service/property-service.component';
import {PropertyServiceService} from './property-service/property-service.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    DialogsModule,
    NgbModule,
    ToastModule.forRoot(),
    ControlsModule
  ],
  declarations: [PropertyServiceComponent],
  entryComponents: [PropertyServiceComponent],
  providers: [PropertyServiceService, LoggerService, ModuleStateService]
})
export class PropertyServiceModule { }
