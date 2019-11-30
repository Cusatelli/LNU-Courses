import { Injectable } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/database';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FileLinkService {
  /*
  this is for uploading the download links for each course to a separate category in the realitme database
  because this might be the only way to work with our current codebase
  */
  constructor(public db: AngularFireDatabase) { }

  getAll() {
    return this.db.list('/fileLinks', ref => (ref.orderByChild('name')))
      .snapshotChanges().pipe(
        map(actions =>
          actions.map(a => ({ key: a.key, link: a.payload.val() }))
        )
      );
  }

  get(id) {
    return this.db.object('/fileLinks/' + id);
  }

  getMore(id) {
    return this.db.object('/fileLinks/' + id).valueChanges().subscribe();
  }

  //iffy see what happenes and change later
  create(fileLink: String, id) {
    this.db.list('/fileLinks/' + id).push(fileLink);
    return this.db.object('/fileLinks/' + id).set(fileLink);
  }

  update(id, fileLink) {
    return this.db.object('/fileLinks/' + id).update(fileLink);
  }

  delete(id) {
    return this.db.object('/fileLinks/' + id).remove();
  }

}
