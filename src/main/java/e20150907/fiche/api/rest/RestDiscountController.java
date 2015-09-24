package e20150907.fiche.api.rest;

import com.google.gson.Gson;
import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.discounts.DiscountFixedAmount;
import e20150907.fiche.domain.concrete.scanitems.FidelityCard;
import e20150907.fiche.domain.concrete.scanitems.Product;
import e20150907.fiche.repository.DiscountRepository;
import e20150907.fiche.repository.ScanItemRepository;
import e20150907.fiche.util.UrlUtil;
import sun.net.util.URLUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Windows 7 on 23-9-2015.
 */
@Path(UrlUtil.restful + "/discounts")
public class RestDiscountController {

    private static DiscountRepository repository = DiscountRepository.createInstance();

    @Path("/{discountId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDiscount(@PathParam("discountId") UUID discountId) {

        return new Gson().toJson(repository.getDiscountByID(discountId));
    }

    @Path("/")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getDiscounts() {
        return new Gson().toJson(repository.getDiscounts());
    }

    @Path("/today")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDiscountsToday(){
        return new Gson().toJson(repository.getDiscountsOfToday());
    }

}
