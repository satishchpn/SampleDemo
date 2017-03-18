package com.websystique.springmvc.configuration;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ids.jpms.ApplicationEnums.LogStatus;
import com.ids.jpms.ws.imagineapp.wsstructure.response.authentication.ResAuthErrorStructure;

@Path("imagineapp/authenticationError")
public class AppAuhenticationErrorService {
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAuthenticationError(){
		ResAuthErrorStructure resAuthErrorStructure=new ResAuthErrorStructure();
		resAuthErrorStructure.setData(new ArrayList<Object>());
		resAuthErrorStructure.setDiscription("Invalid Token Details");
		resAuthErrorStructure.setStatus(LogStatus.FAILURE.getSymbol());
		resAuthErrorStructure.setHttpStatusCode(401);
		return Response.status(resAuthErrorStructure.getHttpStatusCode()).type(MediaType.APPLICATION_JSON).entity(resAuthErrorStructure).build();
	}
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAuthenticationErrorPost(){
		ResAuthErrorStructure resAuthErrorStructure=new ResAuthErrorStructure();
		resAuthErrorStructure.setData(new ArrayList<Object>());
		resAuthErrorStructure.setDiscription("Invalid Token Details");
		resAuthErrorStructure.setStatus(LogStatus.FAILURE.getSymbol());
		resAuthErrorStructure.setHttpStatusCode(401);
		return Response.status(resAuthErrorStructure.getHttpStatusCode()).type(MediaType.APPLICATION_JSON).entity(resAuthErrorStructure).build();
	}
	
}
