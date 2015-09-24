package e20150907.fiche.api;

import com.google.gson.Gson;
import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.discounts.DiscountNone;
import e20150907.fiche.domain.concrete.scanitems.Product;
import e20150907.fiche.repository.ScanItemRepository;
import e20150907.fiche.util.PreferenceUtil;
import e20150907.fiche.util.UrlUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Tom on 22-9-2015.
 */
@Path("/" + UrlUtil.restful + "/products")
public class RestProductController {
    private static ScanItemRepository repository = ScanItemRepository.createInstance();

    public RestProductController(){
        //TODO maybe set it back in the constructor
    }

    @Path("/")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducts(){
        List<Product> products = new ArrayList<>();
        for(ScanItem scanItem : repository.getProducts())
            if(scanItem instanceof Product)
                products.add((Product) scanItem);
        return new Gson().toJson(products);
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addProduct(Product product){
        repository.addScanItem(product);
        return new Gson().toJson(product);
    }

    @Path("/{productID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductById(@PathParam("productID") UUID productID){
        ScanItem scanItem = repository.getItemById(productID);
        return new Gson().toJson(productCheck(scanItem));
    }

    @Path("/{productID}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String putProductById(@PathParam("productID") UUID productID, Product putProduct){
        ScanItem scanItem = repository.getItemById(productID);
        Product product = null;
        if(scanItem instanceof Product) {
            product = (Product) scanItem;
            product.replace(putProduct);
        }
        return new Gson().toJson(product);
    }

    @Path("/{productID}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteProductById(@PathParam("productID") UUID productID){
        ScanItem scanItem = repository.deleteScanItemById(productID);
        return new Gson().toJson(productCheck(scanItem));
    }

    @Path("/barcode/{barcode}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductByBarcode(@PathParam("barcode") String barcode){
        ScanItem scanItem = repository.getItemByCode(barcode);
        return new Gson().toJson(productCheck(scanItem));
    }

    @Path("/barcode/{barcode}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putProductByBarcode(Product putProduct, @PathParam("barcode") String barcode){
        ScanItem scanItem = repository.getItemByCode(barcode);
        Product product = null;
        if(scanItem instanceof Product) {
            product = (Product) scanItem;
            product.replace(putProduct);
        }
        return new Gson().toJson(productCheck(scanItem));
    }

    @Path("/barcode/{barcode}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteProductByBarcode(@PathParam("barcode") String barcode){
        ScanItem scanItem = repository.deleteScanItemByCode(barcode);
        return new Gson().toJson(productCheck(scanItem));
    }

    @Path("/categories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategories(){
        Gson gson = new Gson();
        return gson.toJson(PreferenceUtil.getPRICING_CATEGORIES());
    }

    @Path("/categories/{category}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductsByType(@PathParam("category") String category){
        List<ScanItem> scanItemList = repository.getItemByType(category);
        List<Product> productList = new ArrayList<>();
        if(!scanItemList.isEmpty())
            for(ScanItem scanItem : scanItemList)
                    if(scanItem instanceof Product)
                        productList.add((Product) scanItem);
        return new Gson().toJson(productList.toArray());
    }

    @Path("/{productid}/discount")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDiscount(@PathParam("productid") UUID productid){
        ScanItem scanItem = repository.getItemById(productid);
        Product product = new Product();
        if(scanItem instanceof Product)
            product = (Product) scanItem;
        return new Gson().toJson(product.getDiscount());
    }

    @Path("/{productid}/discount")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postDiscount(@PathParam("productid") UUID productid, Discount discount){
        return new Gson().toJson(setDiscount(productid, discount));
    }

    @Path("/{productid}/discount")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String putDiscount(@PathParam("productid") UUID productid, Discount discount){
        return new Gson().toJson(setDiscount(productid, discount));
    }

    @Path("/{productid}/discount")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteDiscount(@PathParam("productid") UUID productid){
        return new Gson().toJson(setDiscount(productid, new DiscountNone()));
    }

    private Product productCheck(ScanItem scanItem){
        Product product = null;
        if(scanItem instanceof Product)
            product = (Product) scanItem;
        return product;
    }

    private Discount setDiscount(UUID productid, Discount discount){
        ScanItem scanItem = repository.getItemById(productid);
        Product product = new Product();
        if(scanItem instanceof Product) {
            product = (Product) scanItem;
            product.setDiscount(discount);
        }
        return product.getDiscount();
    }
}
