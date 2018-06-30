package cn.njnode.item.server;

import cn.njnode.HandlerResult;
import cn.njnode.SpaceName;
import cn.njnode.beans.item.ItemCategory;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@WebService
@Path("/itemCategoryServer")
@SpaceName(SpaceName.space.item)
public interface ItemCategoryServer {

    @POST
    @Path("/addItemCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    HandlerResult<ItemCategory> addItemCategory(ItemCategory itemCategory);

    @GET
    @Path("/deleteItemCategoryById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    HandlerResult<String> deleteItemCategoryById(@PathParam("id") Long id);

    @POST
    @Path("/updateItemCategoryById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    HandlerResult<String> updateItemCategoryById(ItemCategory itemCategory);

    @GET
    @Path("/queryItemCategoryById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    HandlerResult<ItemCategory> queryItemCategoryById(@PathParam("id") Long id);

    @POST
    @Path("/queryItemCategoryList/{pageNum}/{pageSize}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    HandlerResult<List<ItemCategory>> queryItemCategoryList(ItemCategory itemCategory, @PathParam("pageNum") Integer pageNum,
                                                   @PathParam("pageSize") Integer pageSize);

}
