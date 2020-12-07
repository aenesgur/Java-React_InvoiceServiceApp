import React, { PureComponent } from 'react'

class HeaderComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            
        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className="navbar-brand">Invoice Service</div>
                        <ul className="navbar-nav">
                            <li className="nav-item active">
                                <a className="nav-link" href="http://localhost:3000/users">Users</a>
                            </li>
                            <li className="nav-item active">
                                <a className="nav-link" href="http://localhost:3000/invoices">Invoices</a>
                            </li>
                        </ul>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent