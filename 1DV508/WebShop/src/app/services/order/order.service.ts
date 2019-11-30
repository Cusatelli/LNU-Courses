import { Injectable } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/database';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private db: AngularFireDatabase) { }

  placeOrder(order){
    return this.db.list('/orders').push(order);
  }

  getOrders(){
    return this.db.list('/orders/').valueChanges();
  }

  getAll(){
    return this.db.list('/orders', ref => (ref.orderByChild('userId')))
      .snapshotChanges().pipe(
        map(actions =>
          actions.map(a => ({ key: a.key, ...a.payload.val() }))
        )
      );
  }

  getOrdersByUser(userId: string) {
    return this.db.list('/orders', ref => ref.orderByChild('userId')
    .equalTo(userId)).snapshotChanges().map(actions=>{
      return actions.map(action=>({key: action.key, ...action.payload.val() }));
    });
  }

  getOrder(uid:string){
    return this.db.object('/orders/'+uid);
  }

  updateStatus(InputStatus, orderuid){
    let ref = this.db.database.ref('orders').child(orderuid);
    ref.update({status:InputStatus});
  }
}

