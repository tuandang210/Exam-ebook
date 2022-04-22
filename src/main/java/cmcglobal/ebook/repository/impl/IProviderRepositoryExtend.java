package cmcglobal.ebook.repository.impl;

import cmcglobal.ebook.entity.Provider;

import java.util.List;

public interface IProviderRepositoryExtend {


    List<Provider> findProviderByCodesList(String stringQuery);
//    void saveAllProviderByHQL2(String stringQuery);

}
