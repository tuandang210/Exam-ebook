package cmcglobal.ebook.service;

import cmcglobal.ebook.entity.Customer;

public interface ICustomerService {
    Customer findCustomerByName(String name);
}
