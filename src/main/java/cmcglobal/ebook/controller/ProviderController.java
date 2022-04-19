package cmcglobal.ebook.controller;

import cmcglobal.ebook.entity.Provider;
import cmcglobal.ebook.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/provider")
public class ProviderController {
    @Autowired
    @Qualifier("provider")
    IService providerService ;

    @GetMapping(value="/getAll")
    public ResponseEntity<List<Provider>> getAllProvider(){

        List<Provider> list = providerService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value="/getById/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id){
        Provider provider = (Provider) providerService.findById(id);
        return new ResponseEntity<>(provider, HttpStatus.OK);
    }


    @PostMapping(value="/addProvider")
    public ResponseEntity<String> addProvider(@RequestBody Provider provider){
        if(providerService.findByCode(provider.getCode())==null){
            providerService.add(provider);
            return new ResponseEntity<>("da them Provider", HttpStatus.OK);
        }else return new ResponseEntity<>("da ton tai provider", HttpStatus.OK);

    }

    @PutMapping(value="/changeStatus/{id}")
    public ResponseEntity<String> changeStatus(@PathVariable Long id){
     providerService.changeStatus(id);

    return new ResponseEntity<>("Da thay doi trang thái", HttpStatus.OK);

    }

    @PutMapping(value="/update")
    public ResponseEntity<String> updateProvider(@RequestBody Provider provider){
        providerService.add(provider);
        return new ResponseEntity<>("Da Cap nhat Provider", HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteProvider(@Param("id") Long id){
        providerService.delete(id);
        return new ResponseEntity<>("Da  xa nha xuat ban", HttpStatus.OK);

    }


}
