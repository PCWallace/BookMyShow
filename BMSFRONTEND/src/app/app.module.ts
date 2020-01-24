import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { CitysListComponent } from './citys-list/citys-list.component';
import { TheaterslistComponent } from './theaterslist/theaterslist.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { TheaterviewComponent } from './theaterview/theaterview.component';
import { DateviewComponent } from './dateview/dateview.component';
import { PlacedorderviewComponent } from './placedorderview/placedorderview.component';
import { ReactiveFormsModule } from '@angular/forms';

import { CookieService } from 'ngx-cookie-service';
import { RegistertheaterformComponent } from './registertheaterform/registertheaterform.component';
import { CityMovieTheatreDataComponent } from './city-movie-theatre-data/city-movie-theatre-data.component';

@NgModule({
    declarations: [
        AppComponent,
        CitysListComponent,
        TheaterslistComponent,
        HeaderComponent,
        FooterComponent,
        LoginComponent,
        TheaterviewComponent,
        DateviewComponent,
        PlacedorderviewComponent,
        RegistertheaterformComponent,
        CityMovieTheatreDataComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule
    ],
    providers: [ CookieService],
    bootstrap: [AppComponent]
})
export class AppModule {}
