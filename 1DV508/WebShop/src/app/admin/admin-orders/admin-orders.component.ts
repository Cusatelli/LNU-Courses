import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent {

  orders$;

  constructor(private orderService: OrderService) { 
    this.orders$ = orderService.getAll();
  }

  //updates status on order by key
  statusChanged(value, key){
    switch (+value) {
      case 0:  
        console.log("In progress" + key);
        this.orderService.updateStatus("In progress", key)
        break;
      case 1:
          console.log("Processing"+ key);
          this.orderService.updateStatus("Processing", key);
        break;
      case 2:
          console.log("Completed"+ key);
          this.orderService.updateStatus("Completed", key)
        break;    
      default:
        break;
    }
  }

  // Updates html select drop down with the status of the course
selectStatus(status) {
  if (status === 'In Progress') {
    return  0;
  } else if (status === 'Processing') {
    return 1;
  } else if (status === 'Completed') {
    return  2;
  } else {
    return  -1;
  }



  }
}
