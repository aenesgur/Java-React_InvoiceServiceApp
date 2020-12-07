import React from 'react';
import HeaderComponent from './components/HeaderComponent';
import ListUserComponent from './components/ListUserComponent';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import CreateUserComponent from './components/CreateUserComponent';
import ListInvoiceComponent from './components/ListInvoiceComponent';
import CreateInvoiceComponent from './components/CreateInvoiceComponent';
import ListInvoiceByUserComponent from './components/ListInvoiceByUserComponent';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch>
                <Route path="/" exact component={ListUserComponent}></Route>
                <Route path="/users" exact component={ListUserComponent}></Route>
                <Route path="/adduser" component={CreateUserComponent}></Route>
                <Route path="/invoices" component={ListInvoiceComponent}></Route>
                <Route path="/addinvoice" component={CreateInvoiceComponent}></Route>
                <Route path="/invoicesbyuser" component={ListInvoiceByUserComponent}></Route>
              </Switch>
            </div>
      </Router>
    </div>
  );
}

export default App;