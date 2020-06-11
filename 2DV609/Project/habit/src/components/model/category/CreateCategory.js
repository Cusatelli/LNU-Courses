import React, { Component } from "react";
import firebase from "firebase";

class CreateCategory extends Component {
    constructor() {
        super();
        this.state = {
            title: "",
            description: ""
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
        db.collection("users").doc(user.uid).collection("categories").add({
            title: this.state.title,
            description: this.state.description
        });
        this.setState({
            title: "",
            description: ""
        });
        console.log(this.state);
    }
    render() {
        return (
            <div className="container">
                <form className="white" onSubmit={ this.handleSubmit }>
                    <h5 className="grey-text text-darken-3">Create a New Category</h5>
                    <div className="input-field">
                        <label className="title" htmlFor="title">Title:</label>
                        <input type="text" id="title" value={this.state.title} onChange={this.handleChange}/>
                    </div>
                    <div className="input-field">
                        <label className="description" htmlFor="description">Description:</label>
                        <input type="text" id="description" value={this.state.description} onChange={this.handleChange}/>
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

export default CreateCategory;