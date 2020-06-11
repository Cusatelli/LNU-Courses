import React, {Component} from "react";
import * as firebase from "firebase";

class UserProfile extends Component {

    render() {
        let user = firebase.auth().currentUser
        return (
            <div>
                <img src={user.photoURL} alt={user.displayName} className="userimg"/>
                <p>Display name: {user.displayName}</p>
                <p>Email: {user.email}</p>
            </div>
        )
    }
}
export default UserProfile