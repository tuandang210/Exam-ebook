package cmcglobal.ebook.service.impl;

import cmcglobal.ebook.common.ResponseData;
import cmcglobal.ebook.entity.*;
import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.exception.ExceptionResponse;
import cmcglobal.ebook.model.request.BookOrderRequest;
import cmcglobal.ebook.model.request.OrderRequest;
import cmcglobal.ebook.repository.IBookRepository;
import cmcglobal.ebook.repository.IOrderDetailRepository;
import cmcglobal.ebook.service.IBookService;
import cmcglobal.ebook.service.IOrderDetailService;
import cmcglobal.ebook.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IService<OrderDetail>, IOrderDetailService {

    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IBookService bookService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;



    @Override
    public ResponseData findAll() {
        return null;
    }

    @Override
    public ResponseData findById(Long id) {
        return null;
    }

    @Override
    public ResponseData findByCode(String name) {
        return null;
    }

    @Override
    public ResponseData add(OrderDetail elementInput) {
        return null;
    }

    @Override
    public ResponseData delete(Long id) {
        return null;
    }

    @Override
    public ResponseData changeStatus(Long id) {
        return null;
    }

    @Override
    public ResponseData update(Provider provider) {
        return null;
    }

    @Override
    public ResponseData saveNewOrderDetail(OrderRequest orderRequest) throws ExceptionHandle {
        ExceptionResponse.checkExceptionOfOrderDetail(orderRequest);
        ResponseData responseData = new ResponseData();
        try {
            Customer checkCustomer = customerService.findCustomerByEmail(orderRequest.getCustomer().getEmail());

            Order order = new Order();
            order.setCustomer(orderRequest.getCustomer());

            if(checkCustomer == null){
                ResponseData customer = customerService.add(orderRequest.getCustomer());
                Customer checkNewCustomer = customerService.findCustomerByEmail(orderRequest.getCustomer().getEmail());
                order.setCustomer(checkNewCustomer);
            }else {
                order.setCustomer(checkCustomer);
            }



            List<BookOrderRequest> bookList = orderRequest.getBookOrderRequestList();
            ResponseData newOrder = orderService.add(order);


            for (BookOrderRequest bookOrderRequest : bookList) {
                OrderDetail newOrderDetail = new OrderDetail();
                Book book = bookRepository.findByISBNCode(bookOrderRequest.getIsbnCode());
                if (book != null && !book.getStatus()) {
                    newOrderDetail.setOrder(order);
                    newOrderDetail.setBooks(book);
                    Long quantityNewOrder = (long) bookOrderRequest.getQuantityOfBookOrder();
                    if(book.getQuantity() < quantityNewOrder){
                        throw new ExceptionHandle("Out of quantity", "500");
                    }
                    newOrderDetail.setQuantity(quantityNewOrder);
                    book.setQuantity(book.getQuantity() - quantityNewOrder);
                    bookRepository.save(book);
                    orderDetailRepository.save(newOrderDetail);
                }
            }

            responseData.setCode("200");
            responseData.setStatus("SUCCESS");
            responseData.setMessage("ADDED");
        }
        catch (ExceptionHandle e){
            responseData.setMessage(e.getMessage());
            e.printStackTrace();
            responseData.setCode(e.getCode());
            responseData.setStatus("OUT OF QUANTITY");
        } catch (Exception e){
            responseData.setMessage(e.getMessage());
            e.printStackTrace();
            responseData.setCode("400");
            responseData.setStatus("ERROR");
        }
        return responseData;
    }
}
