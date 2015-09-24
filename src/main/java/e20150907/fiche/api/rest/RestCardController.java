package e20150907.fiche.api.rest;

import com.google.gson.Gson;
import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.scanitems.FidelityCard;
import e20150907.fiche.repository.ScanItemRepository;
import e20150907.fiche.util.UrlUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 23-9-2015.
 */
@Path("/" + UrlUtil.restful + "/cards")
public class RestCardController {

    private static ScanItemRepository repository = ScanItemRepository.createInstance();


    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCards(){
        List<ScanItem> scanItems = repository.getCards();
        List<FidelityCard> fidelityCards = new ArrayList<>();
        for(ScanItem scanItem : scanItems)
            if(scanItem instanceof FidelityCard)
                fidelityCards.add((FidelityCard) scanItem);
        return new Gson().toJson(fidelityCards.toArray());
    }
    @Path("/{cardcode}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCard(@PathParam("cardcode") String cardCode){
        ScanItem scanItem = repository.getItemByCode(cardCode);
        if(scanItem instanceof FidelityCard)
            return new Gson().toJson(scanItem);
        return new Gson().toJson(new FidelityCard());
    }

}
