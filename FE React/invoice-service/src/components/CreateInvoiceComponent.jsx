import React, { PureComponent } from 'react'
import InvoiceService from '../services/InvoiceService';

class CreateInvoiceComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            productName: '',
            amount: 0,
            billNo: '',
            userId: 0
        }
        this.changeProductNameHandler = this.changeProductNameHandler.bind(this);
        this.changeAmountHandler = this.changeAmountHandler.bind(this);
        this.changeBillNoHandler = this.changeBillNoHandler.bind(this);
        this.changeUserIdHandler = this.changeUserIdHandler.bind(this);
        this.saveInvoice = this.saveInvoice.bind(this);
    }
    changeProductNameHandler = (event) => {
        this.setState({productName: event.target.value});
    }

    changeAmountHandler = (event) => {
        this.setState({amount: event.target.value});
    }

    changeBillNoHandler = (event) => {
        this.setState({billNo: event.target.value});
    }

    changeUserIdHandler = (event) => {
        this.setState({userId: event.target.value});
    }

    saveInvoice = (event) => {
        event.preventDefault();
        let invoice = {productName: this.state.productName, amount: this.state.amount, billNo: this.state.billNo, userId: this.state.userId};
        console.log("invoice -> ", invoice)
        InvoiceService.createInvoice(invoice).then(res => {
            this.props.history.push('/invoices');
        })
        .catch(err => {
            alert("Message: " + err.response.data.message + " || Credit Limit " + err.response.data.creditLimit);
        });
    }

    cancel(){
        this.props.history.push('/invoices');
    }

    render() {
        return (
            <div>
                <div className = "container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add Invoice</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label>Product Name</label>
                                        <input placeholder="Product Name" name="productName" className="form-control"
                                        value={this.state.productName} onChange={this.changeProductNameHandler} />
                                    </div>

                                    <div className = "form-group">
                                        <label>Amount</label>
                                        <input type="number" placeholder="Amount" name="amount" className="form-control"
                                        value={this.state.amount} onChange={this.changeAmountHandler} />
                                    </div>

                                    <div className = "form-group">
                                        <label>Bill No</label>
                                        <input placeholder="Bill No" name="billNo" className="form-control"
                                        value={this.state.billNo} onChange={this.changeBillNoHandler} />
                                    </div>

                                    <div className = "form-group">
                                        <label>User Id</label>
                                        <input type="number" placeholder="User Id" name="userId" className="form-control"
                                        value={this.state.userId} onChange={this.changeUserIdHandler} />
                                    </div>

                                    <button className="btn btn-success" onClick={this.saveInvoice}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}> Cancel </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default CreateInvoiceComponent