import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { ShoppingCart } from '../models/shopping-cart';
import { Subscription, Observable } from 'rxjs';
import { OrderService } from '../services/order/order.service';
import { AuthService } from '../services/auth/auth.service';
import { Router } from '@angular/router';
import { Order } from '../models/Order';
import { UserProfileComponent } from '../user-profile/user-profile.component';
import { AngularFireList, AngularFireDatabase } from '@angular/fire/database';
import { UserService } from '../services/user/user.service';

@Component({
  selector: 'app-shipping-form',
  templateUrl: './shipping-form.component.html',
  styleUrls: ['./shipping-form.component.css']
})
export class ShippingFormComponent implements OnInit, OnDestroy {
  @Input('cart') cart: ShoppingCart;
  @Input('uP') profile: UserProfileComponent;
  

  // THIS ORDERADDRESS GIVES ERROR! // CANNOT USE THIS.USERPROFILE.ADDRESS.ETC. //
  orderAddress = {
    addressLine1: this.userProfile.address.address1,
    addressLine2: this.userProfile.address.address2,
    city: this.userProfile.address.city,
    name:  this.userProfile.address.surname
  };

  userId: string;
  userSub: Subscription;

  addressNeedsUpdate: boolean;
  items: AngularFireList<any>;
  items$: Observable<any[]>;

  constructor(
    private orderService: OrderService,
    private authService: AuthService,
    private router: Router,
    private db: AngularFireDatabase,
    private userService: UserService,
    private userProfile: UserProfileComponent
  ){}

  async ngOnInit(){
    this.userSub = this.authService.user$.subscribe(user => this.userId = user.uid);

    //this.addressNeedsUpdate = true;
    this.items = this.db.list('users');
    this.items$ = this.items.valueChanges();
  }
  
  ngOnDestroy(){
    this.userSub.unsubscribe();
  }

  async placeOrderWithSavedAddress(name: string, address1: string, address2: string, city: string) {
    let shipping = {
      name: name,
      addressLine1 : address1,
      addressLine2 : address2,
      city: city
    }
    
    let order = new Order(this.userId, shipping, this.cart, this.cart.totalPrice);
    let result = await this.orderService.placeOrder(order);

    this.router.navigate(['/order-success', result.key]);
  }

}
