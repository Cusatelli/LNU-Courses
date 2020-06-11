import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";

import Navbar from "./components/model/user/Navbar";
import HomeView from "./components/view/HomeView";
import UserProfileView from './components/view/profile/user/UserProfileView';
import AboutView from "./components/view/AboutView";
import ContactView from "./components/view/ContactView";
import Login from "./components/model/user/Login";
import CreateHabit from "./components/model/habit/CreateHabit";
import CreateCategory from "./components/model/category/CreateCategory";
import { AuthProvider } from "./components/model/user/Auth.js"
import PrivateRoute from "./components/model/user/PrivateRoute";
import UserProfile from "./components/model/user/UserProfile";

function App() {
    return (
        <Router>
            <Navbar/>
            <Routing/>
        </Router>
    )
}

function Routing() {
    return(
        <AuthProvider>
            <div className="content">
                <Switch>
                    <Route exact path="/" component={HomeView}/>
                    <Route path="/about" component={AboutView}/>
                    <Route path="/contact" component={ContactView}/>
                    <Route path="/login" component={Login}/>
                    <PrivateRoute path="/createHabit" component={CreateHabit}/>
                    <PrivateRoute path="/createCategory" component={CreateCategory}/>
                    <PrivateRoute path="/userProfile" component={UserProfile}/>
                    <PrivateRoute path="/profile" component={UserProfileView}/>
                </Switch>
            </div>
        </AuthProvider>
    )
}

export default App;
