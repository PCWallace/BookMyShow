import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { CitysListComponent } from "./Components/citys-list/citys-list.component";
import { TheaterslistComponent } from "./Components/theaterslist/theaterslist.component";
import { LoginComponent } from "./Components/login/login.component";

const routes: Routes = [
  {
    path: "",
    redirectTo: "/login",
    pathMatch: "full"
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "home",
    component: CitysListComponent
  },
  {
    path: "citydata",
    component: TheaterslistComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
