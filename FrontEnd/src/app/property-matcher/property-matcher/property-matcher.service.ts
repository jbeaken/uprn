import {Injectable} from '@angular/core';
import {URLSearchParams, Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Address} from "./models/Address";

@Injectable()
export class PropertyMatcherService {

  Address: Address;

  constructor(private http: Http) { }

  match(address : Address): Observable<any> {
    return this.http.get('/api/matcher/match?line1=' + address.line1 + '&line2=l2&line3=l3')
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
    return this.http.delete('/api/matcher', { search : params })
      .map((response) => response.text());
  }

  saveAddress(Address: Address, editMode: boolean): Observable<Address> {
    this.setSelectedAddress(Address);
    let params = new URLSearchParams();
    params.set('editMode', editMode ? '1' : '0');
    return this.http.post('/api/matcher/Address/save', Address, {search: params})
      .map((response) => response.json());
  }

}
