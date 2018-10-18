import { MenuComponent } from './component/menu/menu.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { BuildingmanagerService } from './service/buildingmanager.service';
import { BuildingattendantService } from './service/buildingattendant.service';
import { BuildingComponent } from './component/building/building.component';
import { CheckoutComponent } from './component/checkout/checkout.component';
import { CheckinComponent } from './component/checkin/checkin.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

const appRoutes: Routes = [
  {
    path: '',
    component: CheckinComponent
  },
  {
    path: 'checkin',
    component: CheckinComponent
  },
  {
    path: 'checkout',
    component: CheckoutComponent
  },
  {
    path: 'current',
    component: BuildingComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    CheckinComponent,
    CheckoutComponent,
    BuildingComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpModule,
    BrowserModule,
    RouterModule.forRoot(
      appRoutes
    )
  ],
  providers: [
    BuildingattendantService,
    BuildingmanagerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
