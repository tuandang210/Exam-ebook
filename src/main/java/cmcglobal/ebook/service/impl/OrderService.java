package cmcglobal.ebook.service.impl;

import cmcglobal.ebook.common.ResponseData;
import cmcglobal.ebook.entity.Order;
import cmcglobal.ebook.repository.IOrderRepository;
import cmcglobal.ebook.service.IAddEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "orderService")
public class OrderService implements IAddEntity<Order> {
    @Autowired
    private IOrderRepository iOrderRepository;


    @Override
    public ResponseData add(Order elementInput) {

        ResponseData responseData = new ResponseData();
        try {
            iOrderRepository.save(elementInput);
            responseData.setData(elementInput);
            responseData.setCode("201");
            responseData.setMessage("SUCCESS");
            responseData.setStatus("ADDED");
        }catch (Exception e){
            responseData.setMessage(e.getMessage());
            e.printStackTrace();
            responseData.setCode("400");
            responseData.setStatus("ERROR");
        }
        return responseData;
    }


}
