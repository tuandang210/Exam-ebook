package cmcglobal.ebook.service.impl;

import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.entity.Provider;
import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.repository.IBookRepository;
import cmcglobal.ebook.repository.IProviderRepository;
import cmcglobal.ebook.service.IBookService;
import cmcglobal.ebook.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("provider")
public class ProviderService implements IService <Provider> {

    @Autowired
    IProviderRepository providerRepository;

    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Provider findById(Long id) {
        return providerRepository.getProviderById(id);
//        Provider provider = providerRepository.getById(id);
//        return provider;
    }

    @Override
    public Provider findByCode(String name) {
        return providerRepository.getProviderByCode(name);
    }

    @Override
    public void add(Provider elemenInput) {
        providerRepository.save(elemenInput);
    }




    @Override
    public void delete(Long id) {
        Provider provider = providerRepository.getById(id);
        Book book = bookRepository.getBookByProvider(provider);
        if(provider !=null && book==null){
            providerRepository.delete(provider);
        }

    }

    @Override
    public void changeStatus(Long id) {
        Provider provider = providerRepository.getById(id);
        if(provider !=null){
            provider.setStatus();
            providerRepository.save(provider);
        }

    }
}
