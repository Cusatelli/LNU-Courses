import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import FirebaseContext from './firebase/Context';
import Firebase from './firebase/Firebase';
import App from './App';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(
  <React.StrictMode>
      <FirebaseContext.Provider value={new Firebase()}>
    <App />
      </FirebaseContext.Provider>
  </React.StrictMode>,
  document.getElementById('root')
);

export default Firebase;
export { FirebaseContext };


// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
