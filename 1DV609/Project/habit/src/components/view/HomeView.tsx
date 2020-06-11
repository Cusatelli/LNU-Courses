import React, { Component } from "react";
import {
  NavLink
} from "react-router-dom";
import * as firebase from "firebase";

class HomeView extends Component {
    state = {
        isSignedIn: false
    };

    componentDidMount() {
        firebase
            .auth()
            .onAuthStateChanged(user => this.setState({ isSignedIn: !!user }));
    }

render() {
    if (this.state.isSignedIn) {
        return (
            <div className="container">
                <div>
                    <h1 className="grey-text text-darken-3">Welcome to iHabitMe!</h1>
                    <p className="grey-text text-darken-3">This is the home page of iHabitMe</p>
                </div>
            </div>
        );
    } else {
        return (
            <div className="container">
                <div>
                    <h1 className="grey-text text-darken-3">Welcome to iHabitMe!</h1>
                    <p className="grey-text text-darken-3">This is the home page of iHabitMe</p>
                    <div>
                        <NavLink to="/login">
                            <button className="btn pink lighten-1 margin-right-5px">
                                Sign up
                            </button>
                        </NavLink>
                        <NavLink to="/login">
                            <button className="btn pink lighten-1 margin-left-5px">
                                Login
                            </button>
                        </NavLink>
                    </div>
                </div>
            </div>
        );
    }

    }
}

export default HomeView;