import React, { Component } from "react";
import UserProfile from "../../../model/user/UserProfile";

import {
  Route,
  NavLink
} from "react-router-dom";

class UserProfileView extends Component {
    render() {
        return (
            <div className="container">
                <div>
                    <h1 className="grey-text text-darken-3">User Profile</h1>
                    <p className="grey-text text-darken-3">This is the profile page of iHabitMe.</p>
                </div>
                <div>
                    <UserProfile/>
                </div>
                <div>
                    <NavLink to="/createHabit">
                        <button className="btn pink lighten-1 margin-right-5px">
                            Create Habit
                        </button>
                    </NavLink>
                    <NavLink to="/createCategory">
                        <button className="btn pink lighten-1 margin-left-5px">
                            Create Category
                        </button>
                    </NavLink>
                </div>
            </div>
        );
    }
}

export default UserProfileView;