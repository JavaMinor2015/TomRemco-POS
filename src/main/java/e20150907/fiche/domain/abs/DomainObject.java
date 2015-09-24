package e20150907.fiche.domain.abs;

import e20150907.fiche.util.UrlUtil;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Tom on 23-9-2015.
 */
@Getter
public abstract class DomainObject implements Serializable {
    protected UUID id;
    protected String self = UrlUtil.host + UrlUtil.restful;

    public DomainObject(){
        id = UUID.randomUUID();
    }
}
