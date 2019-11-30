import { Component, OnInit, OnDestroy } from '@angular/core';
import { OrderService } from '../services/order/order.service';
import { ShoppingCart } from '../models/shopping-cart';
import { Subscription } from 'rxjs/Subscription';
import { AuthService } from '../services/auth/auth.service';
import { ShoppingCartService } from '../services/shopping-cart/shopping-cart.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})


  export class CheckOutComponent implements OnInit {
    cart$: Observable<ShoppingCart>;

     constructor(
       private shoppingCartService: ShoppingCartService,
    ){}
    
    async ngOnInit(){
      this.cart$ = await this.shoppingCartService.getCart();
    }

  }