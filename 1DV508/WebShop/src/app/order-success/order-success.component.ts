import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShoppingCartService } from '../services/shopping-cart/shopping-cart.service';

@Component({
  selector: 'app-order-success',
  templateUrl: './order-success.component.html',
  styleUrls: ['./order-success.component.css']
})
export class OrderSuccessComponent implements OnInit {

  constructor(private router: Router, private shoppingcartService: ShoppingCartService) {

   }

  ngOnInit() {
    this.shoppingcartService.clearCart();
    
    setTimeout(() => {
      this.router.navigate(['/']);
  }, 5000);  //5s



  }

}
