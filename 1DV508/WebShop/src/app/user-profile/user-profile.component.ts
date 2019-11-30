import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';
import { UserService } from '../services/user/user.service';
import { Subscription } from 'rxjs/Subscription';
import { AngularFireAuth } from '@angular/fire/auth';
import { AngularFireDatabase, AngularFireList } from '@angular/fire/database';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  userSubscription: Subscription;
  userId: string;
  addressIsSaved: boolean;
  addressNeedsUpdate: boolean;
  address$: Observable<any>;
  items: AngularFireList<any>;
  items$: Observable<any[]>;

  checkbox = {
    checked: false
  }

  address = {
    firstname: '',
    surname: '',
    address1: '',
    address2: '',
    city: '',
    state: '',
    zip: ''
  };

  constructor(public authService: AuthService,
    public userService: UserService, public afAuth: AngularFireAuth,
    public db: AngularFireDatabase) { }

  async ngOnInit() {
    this.userSubscription = this.authService.user$.subscribe(user =>
      this.userId = user.uid);

    this.addressNeedsUpdate = true;
    this.items = this.db.list('users');
    this.items$ = this.items.valueChanges();
  }

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
  }

  submitAddress(data) {
    this.addressNeedsUpdate = false;

    this.userService.saveAddress(this.userId, data);
    this.addressIsSaved = false;
  }


}
