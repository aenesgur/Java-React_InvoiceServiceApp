package com.emlakjetcase.invoiceservice.controllers;

import com.emlakjetcase.invoiceservice.dto.InvoiceDto;
import com.emlakjetcase.invoiceservice.entities.Invoice;
import com.emlakjetcase.invoiceservice.entities.User;
import com.emlakjetcase.invoiceservice.helpers.InvoiceMapper;
import com.emlakjetcase.invoiceservice.models.ResponseModel;
import com.emlakjetcase.invoiceservice.services.InvoiceService;
import com.emlakjetcase.invoiceservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService _invoiceService;

    @Autowired
    private UserService _userService;

    @Autowired
    private InvoiceMapper _invoiceMapper;

    @Autowired
    private ResponseModel _responseModel;

    @Autowired
    private Environment env;

    @PostMapping
    public ResponseEntity<ResponseModel> AddInvoice(@Valid @RequestBody InvoiceDto invoiceDto){
        User user = _userService.GetById(invoiceDto.getUserId());
        Invoice invoice = _invoiceMapper.MapToInvoice(invoiceDto, user);
        Invoice newInvoice = _invoiceService.Add(invoice);
        if(newInvoice == null){
            _responseModel.setSuccess(false);
            _responseModel.setMessage("Something went wrong on the server!");
            return new ResponseEntity(_responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else if (newInvoice.getStatus() == "NOT_APPROVED") {
            _responseModel.setSuccess(false);
            _responseModel.setMessage(user.getFirstName()+"'s transaction is denied because of the credit limit");
            _responseModel.setCreditLimit(Integer.parseInt(env.getProperty("invoice.credit-limit")));
            return new ResponseEntity(_responseModel, HttpStatus.BAD_REQUEST);
        }

        _responseModel.setSuccess(true);
        _responseModel.setMessage("Invoice added succesfully");
        _responseModel.setCreditLimit(Integer.parseInt(env.getProperty("invoice.credit-limit")));
        return new ResponseEntity(_responseModel, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Invoice>> GetInvoices(){
        return ResponseEntity.ok(_invoiceService.GetAll());
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDto>> GetInvoicesByUserId(@RequestParam(value = "userId") Long userId){
        List<Invoice> invoice = _invoiceService.GetAllByUserId(userId);
        if(invoice == null || invoice.size() == 0){
            return null;
        }
        List<InvoiceDto> invoiceDtoList = _invoiceMapper.MapToInvoiceDtoList(invoice);
        return ResponseEntity.ok(invoiceDtoList);
    }
}
