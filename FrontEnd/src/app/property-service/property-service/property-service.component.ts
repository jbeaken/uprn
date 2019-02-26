import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {LoggerService, MessageBoxDialog} from 'eds-angular4';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {PropertyServiceService} from './property-service.service';
import {ToastsManager} from 'ng2-toastr';
import {ModuleStateService} from 'eds-angular4/dist/common';
import {Router} from '@angular/router';
import {Address} from "./models/Address";

@Component({
  selector: 'app-property-service',
  templateUrl: './property-service.component.html',
  styleUrls: ['./property-service.component.css']
})
export class PropertyServiceComponent implements OnInit {

  address: Address;

  constructor(private modal: NgbModal,
              private log: LoggerService,
              private service: PropertyServiceService,
              private state: ModuleStateService,
              private router: Router,
              public toastr: ToastsManager, vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr);
  }

  ngOnInit() {
    // this.service.getList()
    //   .subscribe(
    //     result => {
    //       this.datasets = result;
    //       let val: any;
    //       for (let i = 0; i < this.datasets.length; i++) {
    //         val = this.datasets[i].definition;
    //         this.datasets[i].definition = JSON.parse(val);
    //         if (this.service.getSelectedDataset()) {
    //           this.selection = this.service.getSelectedDataset();
    //         } else {
    //           this.selection = this.datasets[0];
    //         }
    //         this.filteredDatasets = this.datasets;
    //         // console.log(this.selection);
    //       }
    //     },
    //   );
  }
}
