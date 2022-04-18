package cmcglobal.ebook.service;

import java.util.List;

public interface IService <E> {
    List<E> findAll();
    E findById(Long id);
    E findByCode(String name);
    void add(E elemenInput);
    void delete(Long id);
    void changeStatus(Long id);
}
