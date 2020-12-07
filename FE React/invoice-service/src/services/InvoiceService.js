import axios from 'axios';

const GET_INVOICE_API = 'http://localhost:8081/api/invoice/getall';
const GET_INVOICES_BY_USER_ID_API = 'http://localhost:8081/api/invoice?userId=';
const POST_INVOICE_API ='http://localhost:8081/api/invoice';

class InvoiceService{
    getInvoices(){
        return axios.get(GET_INVOICE_API);
    }

    createInvoice(invoice){
        return axios.post(POST_INVOICE_API, invoice);
    }

    getInvoicesByUserId(userId){
        return axios.get(GET_INVOICES_BY_USER_ID_API+userId);
    }
}

export default new InvoiceService();