package cmcglobal.ebook.service.impl;

import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.entity.Provider;
import cmcglobal.ebook.exception.ExceptionHandle;
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

    @Override
    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Provider findById(Long id) {
        return providerRepository.getById(id);
    }

    @Override
    public Provider findByName(String name) {
        return providerRepository.getProviderByName(name);
    }

    @Override
    public void add(Provider elemenInput) {
        providerRepository.save(elemenInput);
    }

    @Override
    public void delete(Long id) {
        Provider provider = providerRepository.getById(id);
        if(provider !=null){
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
