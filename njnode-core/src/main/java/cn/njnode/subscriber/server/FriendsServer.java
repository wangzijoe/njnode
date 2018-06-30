package cn.njnode.subscriber.server;

import cn.njnode.HandlerResult;
import cn.njnode.SpaceName;
import cn.njnode.SpaceName.space;
import cn.njnode.beans.subscriber.Friends;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@WebService
@Path("/friendsServer")
@SpaceName(space.subscriber)
public interface FriendsServer {

	@POST
	@Path("/addFriends")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<Friends> addFriends(Friends friends);

	@GET
	@Path("/deleteFriendsById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<String> deleteFriendsById(Integer id);

	@POST
	@Path("/updateFriendsById")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<String> updateFriendsById(Friends friends);

	@GET
	@Path("/queryFriendsById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<Friends> queryFriendsById(Integer id);
	
	@POST
	@Path("/queryFriendsList/{pageNum}/{pageSize}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<List<Friends>> queryFriendsList(Friends friends, @PathParam("pageNum") Integer pageNum,
			@PathParam("pageSize") Integer pageSize);
}
