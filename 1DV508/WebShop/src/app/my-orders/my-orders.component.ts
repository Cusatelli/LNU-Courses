import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';
import { OrderService } from '../services/order/order.service';
import { ShoppingCartService } from '../services/shopping-cart/shopping-cart.service';
import { FileLinkService } from 'src/app/services/file-link/file-link.service';


@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.css']
})
export class MyOrdersComponent implements OnInit {
  orders$;
  cart$;
  downloadLink;

  constructor(
    private authService: AuthService,
    private orderService: OrderService,
    private cartService: ShoppingCartService,
    private fileLinkService : FileLinkService
  ) { 
    this.orders$ = authService.user$.switchMap(u => orderService.getOrdersByUser(u.uid));
  }

  getLink(key: String){
    this.fileLinkService.get(key).snapshotChanges().subscribe(a => this.downloadLink = a.payload.val());  
    return this.downloadLink;
  }

  async ngOnInit() {
    this.cart$ = await this.cartService.getCart();
  }

}