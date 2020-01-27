import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { CitysListComponent } from './Components/citys-list/citys-list.component';
import { TheaterslistComponent } from './Components/theaterslist/theaterslist.component';
import { HeaderComponent } from './Components/header/header.component';
import { FooterComponent } from './Components/footer/footer.component';
import { LoginComponent } from './Components/login/login.component';
import { TheaterviewComponent } from './Components/theaterview/theaterview.component';
import { DateviewComponent } from './Components/dateview/dateview.component';
import { PlacedorderviewComponent } from './Components/placedorderview/placedorderview.component';
import { ReactiveFormsModule } from '@angular/forms';

import { CookieService } from 'ngx-cookie-service';
import { RegistertheaterformComponent } from './Components/registertheaterform/registertheaterform.component';
import { CityMovieTheatreDataComponent } from './Components/city-movie-theatre-data/city-movie-theatre-data.component';

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
