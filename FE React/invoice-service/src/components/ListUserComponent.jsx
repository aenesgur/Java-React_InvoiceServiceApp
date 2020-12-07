import React, { PureComponent } from 'react'
import UserService from '../services/UserService';

class ListUserComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            users: []
        }
        this.addUser = this.addUser.bind(this);
    }

    componentDidMount(){
        UserService.getUsers().then((res)=>{
            this.setState({users: res.data});
        })
    }
    addUser(){
        this.props.history.push('/adduser');
    }
    render() {
        return (
            <div>
                <h2 className="text-center">User List</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addUser}>Add User</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user => 
                                    <tr key = {user.id}>
                                        <td>{user.id}</td>
                                        <td>{user.firstName}</td>
                                        <td>{user.lastName}</td>
                                        <td>{user.email}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListUserComponent