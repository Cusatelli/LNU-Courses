import React, {Component} from "react";
import * as firebase from "firebase";
import {NavLink} from "react-router-dom";
import Logo from "../../../iHabitMe_Logo.png";

class Navbar extends Component {

    constructor() {
        super();
        this.state = {
            isSignedIn: false
        };
         }

    componentDidMount() {
        firebase.auth().onAuthStateChanged(user => this.setState({isSignedIn: !!user}));
    }

    logout = () => {
          firebase.auth().signOut().then(function() {
              console.log("signed out")
          }).catch(function(error) {
            console.log(error)
        });
        this.setState((state) => {
            return {isSignedIn: false}
        });
    }

    render() {
        if (this.state.isSignedIn) {
            return (
                <nav className="nav-wrapper grey darken-4">
                    <ul id="navbar" className="container">
                        <li><img src={Logo} alt="logo" className="logo"/></li>
                        <li><NavLink exact to="/">iHabitMe</NavLink></li>
                        <li><NavLink to="/profile">Profile</NavLink></li>
                        <li><NavLink to="/about">About</NavLink></li>
                        <li><NavLink to="/contact">Contact</NavLink></li>
                        <li><NavLink to="/"><button className="btn pink lighten-1" onClick={() => this.logout()}>Sign-out</button></NavLink></li>
                    </ul>
                </nav>
            )
        } else {
            return (
                <nav className="nav-wrapper grey darken-4">
                    <ul id="navbar" className="container">
                        <li><img src={Logo} alt="logo" className="logo"/></li>
                        <li><NavLink exact to="/">iHabitMe</NavLink></li>
                        <li><NavLink to="/about">About</NavLink></li>
                        <li><NavLink to="/contact">Contact</NavLink></li>
                    </ul>
                </nav>
            )
        }
    }
}
export default Navbar
