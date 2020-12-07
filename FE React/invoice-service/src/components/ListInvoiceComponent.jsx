import React, { PureComponent } from 'react'
import InvoiceService from '../services/InvoiceService';

class ListInvoiceComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            invoices: []
        }
        this.addInvoice = this.addInvoice.bind(this);
        this.getInvoicesByUser = this.getInvoicesByUser.bind(this);
    }

    componentDidMount(){
        InvoiceService.getInvoices().then((res)=>{
            this.setState({invoices: res.data});
        })
    }
    addInvoice(){
        this.props.history.push('/addinvoice');
    }
    getInvoicesByUser(){
        this.props.history.push('/invoicesbyuser');
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Invoice List</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addInvoice}>Add Invoice</button>
                    <button className="btn btn-info" onClick={this.getInvoicesByUser}>Get Invoices By User</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Product Name</th>
                                <th>Bill No</th>
                                <th>Amount</th>
                                <th>Status</th>
                                <th>User Id</th>
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
                                        <td>{invoice.user.id}</td>
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

export default ListInvoiceComponent