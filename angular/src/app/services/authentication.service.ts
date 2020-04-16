import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { CookieService } from 'ngx-cookie-service';

import { environment } from '../../environments/environment.dev';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

    private currentUserSubject: BehaviorSubject<Partial<User>>;
    public currentUser: Observable<Partial<User>>;

    constructor(
        private http: HttpClient,
        private cookieService: CookieService
    ) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): Partial<User> {
        return this.currentUserSubject.value;
    }

    login(username: string, password: string) {
        var headers = new HttpHeaders();
        headers.append('Content-Type', 'application/json');
        return this.http.post<any>(`${environment.apiUrl}/api/login`, { username: username, password: password }, {
            headers: headers,
            withCredentials: true,
            observe: "response"
        })
            .pipe(map(response => {
                console.log(response.headers.get('Authorization'));
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                if (response.headers.get('Authorization')) {
                    let user: any = JSON.parse(JSON.parse(this.cookieService.get("user")));
                    let user_obj: User = new User(user.id, user.username, user.token);
                    localStorage.setItem('currentUser', JSON.stringify(JSON.parse(this.cookieService.get("user"))));
                    this.currentUserSubject.next(user_obj);
                    return response;
                }
            }));
    }

    signup(username: string, password: string) {
        var headers = new HttpHeaders();
        headers.append('Content-Type', 'application/json');
        return this.http.post<any>(`${environment.apiUrl}/users/sign-up`, { username: username, password: password }, {
            headers: headers
        }).pipe(map(response => {
                this.currentUserSubject.next(null);
                return response;
            }));
    }

    logout() {
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}
