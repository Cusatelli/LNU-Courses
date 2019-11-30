import { Injectable } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/database';
import * as firebase from 'firebase';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private db: AngularFireDatabase) { }

  // location of this object in database
  save(user: firebase.User) {
    this.db.object('/users/' + user.uid).update({
      // this is the same name which we see in the navBar
      name: user.displayName,
      email: user.email
    });
  }

  // this give the user object from db
  get(uid: string): Observable<any> {
    return this.db.object('/users/' + uid).valueChanges();
  }

  // Store users Address in Firebase
  saveAddress(userId, billingAddress) {
    return this.db.database.ref().child('/users/' + userId + '/address/')
      .set(billingAddress);
    
    //OLD BACKUP CODE
    //return this.db.list('/users/' + userId + '/address').push(billingAddress);
  }

  // Get the users address object from Firebase
  getAddress(uid: string): Observable<any> {
    return this.db.list('/users/' + uid + '/address').valueChanges();
  }

}
