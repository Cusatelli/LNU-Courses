import React, {Component, useCallback, useContext} from "react";
import "firebase/firestore";
import * as firebase from "firebase/app";
import GoogleButton from 'react-google-button'
import { withRouter, Redirect} from "react-router"


const Login = ({ history }) => {
        const handleLogin = useCallback(
            async event => {
                event.preventDefault()
                try {
                    let provider = new firebase.auth.GoogleAuthProvider();
                    await firebase
                        .auth()
                        .signInWithPopup(provider)
                        .then(function(result) {
                            let token = result.credential.accessToken;
                            let user = result.user;
                            const db = firebase.firestore();
                            db.collection("users")
                                .doc(user.uid)
                                .get()
                                .then(doc => {
                                    if (doc.exists) {
                                        console.log("User already exist");
                                    } else {
                                        db.collection("users")
                                            .doc(user.uid)
                                            .set({
                                                name: user.displayName,
                                                email: user.email,
                                                img: user.photoURL
                                            })
                                            .then(function() {
                                                console.log("Document successfully written!");
                                            })
                                            .catch(function(error) {
                                                console.error("Error writing document: ", error);
                                            });
                                    }
                                });
                        })
                    history.push("/")
                } catch (e) {
                    console.log(e)
                }
            },
            [history]
        )
        return (
            <div className="container">
                <GoogleButton onClick={handleLogin || null}>log in</GoogleButton>
            </div>
        );

    };
export default withRouter(Login)