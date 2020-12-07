import React, { PureComponent } from 'react'
import InvoiceService from '../services/InvoiceService';

class ListInvoiceByUserComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
           invoices: [],
           productName: '',
           amount: 0,
           billNo: '',
           userId: 0
        }
        this.changeUserIdHandler = this.changeUserIdHandler.bind(this);
    }
    changeUserIdHandler = (event) => {
        this.setState({userId: event.target.value});
    }
    saveInvoice = (event) => {
        event.preventDefault();
        let invoices = {productName: this.state.productName, amount: this.state.amount, billNo: this.state.billNo, userId: this.state.userId};
        console.log(parseInt(invoices.userId));
        InvoiceService.getInvoicesByUserId(parseInt(invoices.userId)).then(res => {
            console.log(res.data)
            this.setState({invoices: res.data});
        })
        .catch(err => {
            console.log(err);
        });
    }
    /*componentDidMount(){
        this.setState({invoices: res.data});
    }*/
    render() {
        return (
            <div>
                <form>
                    <div className = "form-group">
                        <label>User Id</label>
                        <input type="number" placeholder="User Id" name="userId" className="form-control"
                        value={this.state.userId} onChange={this.changeUserIdHandler} />
                    </div>

                    <button className="btn btn-success" onClick={this.saveInvoice}>Search</button>
                </form>

                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Product Name</th>
                                <th>Bill No</th>
                                <th>Amount</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.invoices.map(
                                    invoice => 
                                    <tr key = {invoice.id}>
                                        <td>{invoice.id}</td>
                                        <td>{invoice.productName}</td>
                                        <td>{invoice.billNo}</td>
                                        <td>{invoice.amount}</td>
                                        <td>{invoice.status}</td>
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

export default ListInvoiceByUserComponent