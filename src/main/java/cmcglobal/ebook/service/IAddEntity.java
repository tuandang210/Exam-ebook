package cmcglobal.ebook.service;

import cmcglobal.ebook.common.ResponseData;
import cmcglobal.ebook.exception.ExceptionHandle;

public interface IAddEntity<G> {
    ResponseData add(G elemenInput) throws ExceptionHandle;
}
