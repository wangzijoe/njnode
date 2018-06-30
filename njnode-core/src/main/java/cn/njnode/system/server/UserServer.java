package cn.njnode.system.server;

import cn.njnode.HandlerResult;
import cn.njnode.SpaceName;
import cn.njnode.SpaceName.space;
import cn.njnode.beans.system.User;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@WebService
@Path("/userServer")
@SpaceName(space.system)
public interface UserServer {

	@POST
	@Path("/addUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<User> addUser(User user);

	@GET
	@Path("/deleteUserById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<String> deleteUserById(@PathParam("id") String id);

	@POST
	@Path("/updateUserById")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<String> updateUserById(User user);

	@GET
	@Path("/queryUserById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<User> queryUserById(@PathParam("id") String id);

	@POST
	@Path("/queryUserList/{pageNum}/{pageSize}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<List<User>> queryUserList(User user, @PathParam("pageNum") Integer pageNum,
			@PathParam("pageSize") Integer pageSize);

	@GET
	@Path("/queryRolesByUserName/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<List<String>> queryRolesByUserName(@PathParam("userName") String userName);

	@GET
	@Path("/queryPermisionByUserName/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	HandlerResult<List<String>> queryPermisionByUserName(@PathParam("userName") String userName);

}
