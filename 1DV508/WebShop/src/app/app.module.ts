import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AngularFireModule} from '@angular/fire';
import { AngularFireDatabaseModule} from '@angular/fire/database';
import { AngularFireAuthModule} from '@angular/fire/auth';
import { AngularFireStorageModule } from '@angular/fire/storage';
import { AngularFirestoreModule } from '@angular/fire/firestore';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CustomFormsModule } from 'ng2-validation';

import { AppComponent } from './app.component';
import { environment } from '../environments/environment';
import { LoginComponent } from './login/login.component';
import { BsNavbarComponent } from './bs-navbar/bs-navbar.component';
import { ShopComponent } from './shop/shop.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { AuthService } from './services/auth/auth.service';
import { AuthGuardService as AuthGuard } from './services/auth-guard/auth-guard.service';
import { HomeComponent } from './home/home.component';
import { MyOrdersComponent } from './my-orders/my-orders.component';
import { UserService } from './services/user/user.service';
import { CategoryService } from './services/category/category.service';
import { ProductService } from './services/product/product.service';
import { ProductsComponent } from './products/products.component';
import { ShoppingCartService } from './services/shopping-cart/shopping-cart.service';
import { ProductCardComponent } from './products/product-card/product-card.component';
import { AdminModule } from './admin/admin.module';
import { FileLinkService } from './services/file-link/file-link.service';
import { ProductPageComponent } from './products/product-page/product-page.component';
import { ProductQuantityComponent } from './product-quantity/product-quantity.component';
import { OrderService } from './services/order/order.service';
import { CheckOutComponent } from './checkout/checkout.component';
import { OrderSuccessComponent } from './order-success/order-success.component';
import { ShippingFormComponent } from './shipping-form/shipping-form.component';
import { ShoppingCartSummaryComponent } from './shopping-cart-summary/shopping-cart-summary.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BsNavbarComponent,
    ShopComponent,
    ShoppingCartComponent,
    HomeComponent,
    MyOrdersComponent,
    ProductsComponent,
    ProductCardComponent,
    ProductPageComponent,
    ProductQuantityComponent,
    CheckOutComponent,
    OrderSuccessComponent,
    ShippingFormComponent,
    ShoppingCartSummaryComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CustomFormsModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireDatabaseModule,
    AngularFireAuthModule,
    AngularFireStorageModule,
    AngularFirestoreModule,
    RouterModule.forRoot([
      {path: '', component: ProductsComponent},
      {path: 'shop', component: ShopComponent},
      {path: 'shopping-cart', component: ShoppingCartComponent},
      {path: 'login', component: LoginComponent},
      {path: 'about', component: HomeComponent},
      
      {path: 'order-success/:id', component: OrderSuccessComponent},

      {
        path: 'products/:id',
        component: ProductPageComponent
      },
      {
        path: 'my/profile',
        component: UserProfileComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'my/orders',
        component: MyOrdersComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'check-out',
        component: CheckOutComponent,
      },
    ]),
    NgbModule.forRoot(),
    AdminModule,
  ],
  providers: [
    AuthService,
    AuthGuard,
    UserService,
    CategoryService,
    ProductService,
    ShoppingCartService,
    FileLinkService,
    OrderService,
    UserProfileComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
