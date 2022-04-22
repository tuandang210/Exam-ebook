package cmcglobal.ebook.service.impl;

import cmcglobal.ebook.common.ResponseData;
import cmcglobal.ebook.entity.Provider;
import cmcglobal.ebook.service.IService;

public interface IProviderService extends IService<Provider> {
    ResponseData getAllProivderByConditions(Provider inputElement);
    ResponseData saveAll(Provider[] providers);
}
