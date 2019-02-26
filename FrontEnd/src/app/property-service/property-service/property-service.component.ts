import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {LoggerService, MessageBoxDialog} from 'eds-angular4';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {PropertyServiceService} from './property-service.service';
import {ToastsManager} from 'ng2-toastr';
import {ModuleStateService} from 'eds-angular4/dist/common';
import {Router} from '@angular/router';
import {Address} from "./models/Address";
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-property-service',
  templateUrl: './property-service.component.html',
  styleUrls: ['./property-service.component.css']
})
export class PropertyServiceComponent implements OnInit {

  address: Address  = new Address("", "", "", "", "");

  tableData: any[] = [
    {id: 1, name: 'John Smith', description: 'Senior consultant'},
    {id: 2, name: 'Jane Doe', description: 'General practitioner'},
    {id: 3, name: 'Dave Jones', description: 'Hospital porter'},
    {id: 4, name: 'Doris Jackson', description: 'Surgery receptionist'}
  ];

  selection: any = this.tableData[2];

  submitted = false;

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

  onSubmit() {
      this.submitted = true;
      console.log("Matching address")
      console.log(this.address)
      console.log(this.address.line1)
      console.log(this.address.line2)
    }
}
