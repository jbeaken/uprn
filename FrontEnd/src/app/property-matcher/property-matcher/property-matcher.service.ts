import {Injectable} from '@angular/core';
import {URLSearchParams, Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Address} from "./models/Address";

@Injectable()
export class PropertyMatcherService {

  Address: Address;

  constructor(private http: Http) { }

  getList(): Observable<Address[]> {
    return this.http.get('/api/matcher/address?line1=l1&line2=l2&line3=l3')
      .map((response) => response.json());
  }

  getSelectedAddress(): Address {
    return this.Address;
  }

  setSelectedAddress(Address: Address) {
    this.Address = Address;
  }

  deleteAddress(id: any): Observable<any> {
    const params = new URLSearchParams();
    params.set('id', id);
    return this.http.delete('api/PropertyService', { search : params })
      .map((response) => response.text());
  }

  saveAddress(Address: Address, editMode: boolean): Observable<Address> {
    this.setSelectedAddress(Address);
    let params = new URLSearchParams();
    params.set('editMode', editMode ? '1' : '0');
    return this.http.post('api/PropertyService/Address/save', Address, {search: params})
      .map((response) => response.json());
  }

}
