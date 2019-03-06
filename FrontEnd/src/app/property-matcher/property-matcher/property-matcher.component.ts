import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {LoggerService, MessageBoxDialog} from 'eds-angular4';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {PropertyMatcherService} from './property-matcher.service';
import {ToastsManager} from 'ng2-toastr';
import {ModuleStateService} from 'eds-angular4/dist/common';
import {Router} from '@angular/router';
import {Address} from "./models/Address";


@Component({
  selector: 'app-property-matcher',
  templateUrl: './property-matcher.component.html',
  styleUrls: ['./property-matcher.component.css']
})
export class PropertyMatcherComponent implements OnInit {

  address: Address  = new Address("", "", "", "", "");

  response: any;

  addresses: any[]

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
              private service: PropertyMatcherService,
              private state: ModuleStateService,
              private router: Router,
              public toastr: ToastsManager, vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr);
  }

  ngOnInit() {

  }

  onSubmit() {
      this.submitted = true;
      console.log("Matching address")
      console.log(this.address.line1)
    this.service.match( this.address )
      .subscribe(
        result => {
            console.log( result )
            this.response = result
            this.addresses = result.response.addresses
        },
      );
  }

}
