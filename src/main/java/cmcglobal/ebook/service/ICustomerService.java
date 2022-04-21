package cmcglobal.ebook.service;

import cmcglobal.ebook.entity.Customer;

public interface ICustomerService extends IAddEntity<Customer> {
    Customer findCustomerByEmail(String email);
}
