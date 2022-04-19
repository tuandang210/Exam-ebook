package cmcglobal.ebook.service.impl;

import cmcglobal.ebook.common.ResponseData;
import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.entity.Provider;
import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.exception.ExceptionResponse;
import cmcglobal.ebook.repository.IBookRepository;
import cmcglobal.ebook.repository.IProviderRepository;
import cmcglobal.ebook.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("provider")
public class ProviderService implements IService <Provider> {

    @Autowired
    IProviderRepository providerRepository;

    @Autowired
    IBookRepository bookRepository;

    @Override
    public ResponseData findAll() {
        ResponseData responseData = new ResponseData();
        List<Provider> providerList = providerRepository.findAll();
        responseData.setData(providerList);
        responseData.setMessage("FindAll");
        responseData.setStatus("Success");
        responseData.setCode("200");
        return responseData;

    }

    @Override
    public ResponseData findById(Long id) {
        ResponseData responseData = new ResponseData();
        Optional<Provider> provider = providerRepository.findById(id);
        if(provider.isPresent()){
            responseData.setData(provider);
            responseData.setMessage("Find ProviderById");
            responseData.setStatus("Success");
            responseData.setCode("200");
        }
        else{
            responseData.setMessage("Not Found");
            responseData.setStatus("fail");
            responseData.setCode("200-1");
        }

        return responseData;
    }

    @Override
    public ResponseData findByCode(String name) {
        ResponseData responseData = new ResponseData();
        Provider provider = providerRepository.getProviderByCode(name);
        if(provider!=null){
            responseData.setData(provider);
            responseData.setMessage("Find By Code Name");
            responseData.setStatus("Success");
            responseData.setCode("200");
        }
        else{
            responseData.setMessage("Not Found");
            responseData.setStatus("fail");
            responseData.setCode("200-1");
        }

        return responseData;
    }



    @Override
    public ResponseData add(Provider elemenInput)  {
        ResponseData responseData = new ResponseData();
        try {
            ExceptionResponse.checkExceptionOfProvider(elemenInput);
            if(providerRepository.getProviderByCode(elemenInput.getCode())==null){
                providerRepository.save(elemenInput);
                responseData.setData(elemenInput);
                responseData.setMessage("add Provider");
                responseData.setStatus("Success");
                responseData.setCode("200");
            }
            else{
                responseData.setData(elemenInput);
                responseData.setMessage("Provider is exits");
                responseData.setStatus("fail");
                responseData.setCode("200-1");
            }

        }
        catch(ExceptionHandle e){
            responseData.setData(elemenInput);
            responseData.setMessage(e.getMessage());
            responseData.setCode(e.getCode());
            responseData.setStatus("Error");
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;
    }

    @Override
    public ResponseData delete(Long id) {
        ResponseData responseData = new ResponseData();
        Provider provider = providerRepository.getById(id);
        Book book = bookRepository.getBookByProvider(provider);

        if(provider !=null && book==null){
            providerRepository.delete(provider);
            responseData.setData(provider);
            responseData.setMessage("DELETE");
            responseData.setStatus("Success");
            responseData.setCode("200");
        }
        else{
            responseData.setMessage("Not Found");
            responseData.setStatus("fail");
            responseData.setCode("200-1");
        }

        return responseData;

    }

    @Override
    public ResponseData changeStatus(Long id) {
        ResponseData responseData = new ResponseData();
        Provider provider = providerRepository.getProviderById(id);
        if(provider !=null) {
            provider.setStatus();
            providerRepository.save(provider);
            responseData.setData(provider);
            responseData.setMessage("Change Status");
            responseData.setStatus("Success");
            responseData.setCode("200");
        }

        else{
            responseData.setMessage("Object is not exits");
            responseData.setStatus("fail");
            responseData.setCode("200-1");
        }

        return responseData;
    }

    @Override
    public ResponseData update(Provider provider) {
        ResponseData responseData = new ResponseData();
        try {
            ExceptionResponse.checkExceptionOfProvider(provider);
            if(provider.getId()!=null){
                providerRepository.save(provider);
                responseData.setData(provider);
                responseData.setMessage("update Provider");
                responseData.setStatus("Success");
                responseData.setCode("200");
            }
            else{
                responseData.setData(provider);
                responseData.setMessage("Primary Key is not exits");
                responseData.setStatus("fail");
                responseData.setCode("200-1");
            }

        }
        catch(ExceptionHandle e){
            responseData.setData(provider);
            responseData.setMessage(e.getMessage());
            responseData.setCode(e.getCode());
            responseData.setStatus("Error");
        }

        catch (Exception e) {
            e.printStackTrace();
            responseData.setMessage(e.getMessage());
            responseData.setStatus("Error");
        }

        return responseData;
    }


}
