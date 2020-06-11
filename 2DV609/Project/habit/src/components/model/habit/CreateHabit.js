import React, { Component } from "react";
import * as firebase from 'firebase';
import 'firebase/firestore';

import { difficulty as diff } from "../difficulty/Difficulty";

class CreateHabit extends Component {
    constructor() {
        super();
        this.state = {
            title: "",
            description: "",
            category: "",
            difficulty: diff[0].value,
            reward: 1,
            createdAt: new Date(),
            completed: false,
        };
    }
    handleChange = (e) => {
        this.setState({
            [e.target.id]: e.target.value
        })
    }
    handleSubmit = (e) => {
        e.preventDefault();
        const db = firebase.firestore();
        var user = firebase.auth().currentUser;
        console.log(user.uid);
        /* Add data to firebase signed in user */
        const userRef = db.collection("users").doc(user.uid).collection("habits").add({
            title: this.state.title,
            description: this.state.description,
            category: this.state.category,
            difficulty: this.state.difficulty,
            reward: this.state.reward,
            createdAt: new Date(),
            completed: false,
        });
        this.setState({
            title: "",
            description: "",
            category: "",
            difficulty: diff[0].value,
            reward: 1,
            createdAt: new Date(),
            completed: false,
        });
        console.log(this.state);
    }
    render() {
        return (
            <div className="container">
                <form className="white" onSubmit={ this.handleSubmit }>
                    <h5 className="grey-text text-darken-3">Create a New Habit</h5>
                    <div className="input-field">
                        <label className="title" htmlFor="title">Title:</label>
                        <input type="text" id="title" required value={this.state.title} onChange={this.handleChange}/>
                    </div>
                    <div className="input-field">
                        <label className="description" htmlFor="description">Description:</label>
                        <input type="text" id="description" required value={this.state.description} onChange={this.handleChange}/>
                    </div>
                    <div className="input-field">
                        <label className="category" htmlFor="category">Category:</label>
                        <input type="text" id="category" required value={this.state.category} onChange={this.handleChange}/>
                    </div>
                    <div className="input-field short">
                        <label className="difficulty" htmlFor="difficulty">Difficulty: "{ diff[this.state.difficulty - 1].label }"</label>
                        <input type="number" id="difficulty" min="1" max="5" required value={this.state.difficulty} onChange={this.handleChange}/>
                    </div>
                    <div className="input-field short">
                        <label className="reward" htmlFor="reward">Reward:</label>
                        <input type="number" id="reward" min="1" max="10" required value={this.state.reward} onChange={this.handleChange}/>
                    </div>
                    <div>
                        <button className="btn pink lighten-1">
                            Create
                        </button>
                    </div>
                </form>
            </div>
        )
    }
}

export default CreateHabit;