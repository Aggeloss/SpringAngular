import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment.dev';
import { map } from 'rxjs/operators';

import { AuthenticationService } from '../services/authentication.service';

@Injectable({
	providedIn: 'root'
})
export class ProductService {

    currentUser;

	constructor(
		private http: HttpClient,
		private authenticationService: AuthenticationService,
	) {
		this.currentUser = this.authenticationService.currentUser;
	}

	getProducts() {
		var headers = new HttpHeaders();
		headers.append('Authorization', this.currentUser.token);
		return this.http.get<any>(`${environment.apiUrl}/products`, {
            headers: {
                Authorization: JSON.parse(JSON.parse(localStorage.getItem("currentUser"))).token
            }
        });
	}
}
