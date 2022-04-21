package cmcglobal.ebook.service.impl;

import cmcglobal.ebook.common.ResponseData;
import cmcglobal.ebook.entity.Customer;
import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.exception.ExceptionResponse;
import cmcglobal.ebook.repository.ICustomerRepository;
import cmcglobal.ebook.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "CustomerService")
public class CustomerService implements ICustomerService {
    @Autowired
    public ICustomerRepository customerRepository;


    @Override
    public ResponseData add(Customer elementInput) throws ExceptionHandle {
        ResponseData responseData = new ResponseData();
        ExceptionResponse.checkExceptionOfCustomer(elementInput);
        Customer customer = customerRepository.findCustomerByEmail(elementInput.getEmail());
            if(customer == null) {
                customerRepository.save(elementInput);
                responseData.setData(elementInput);
                responseData.setCode("200");
                responseData.setMessage("SUCCESS");
                responseData.setStatus("ADDED");
            }

        return responseData;
    }


    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }
}
