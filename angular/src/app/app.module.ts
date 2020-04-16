import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { JwtInterceptor, ErrorIntercept } from './helpers';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

import { CookieService } from 'ngx-cookie-service';
import { SignUpComponent } from './sign-up/sign-up.component';

@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        AppRoutingModule
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        LoginComponent,
        SignUpComponent
    ],
    providers: [
        CookieService,
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorIntercept, multi: true },
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
