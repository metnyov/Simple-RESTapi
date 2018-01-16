package com.wkwn.rest.notes;

import javax.json.Json;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class MyResponse {
	public static Response goodDelete(String id) {
		return Response
				.status(Response.Status.OK)
				.entity(Json.createObjectBuilder()
						.add("response", true)
						.add("message", "Success! Note was removed.")
						.add("id", id)
						.build().toString())
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	public static Response goodUpdate(String id) {
		return Response
				.status(Response.Status.OK)
				.entity(Json.createObjectBuilder()
						.add("response", true)
						.add("message", "Success! Note was updated.")
						.add("id", id)
						.build().toString())
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	public static Response goodPost(String id) {
		return Response
				.status(Response.Status.OK)
				.entity(Json.createObjectBuilder()
						.add("response", true)
						.add("message", "Success! Note was posted.")
						.add("id", id)
						.build().toString())
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	public static Response badNotFoundId(String id) {
		return Response
				.status(Response.Status.BAD_REQUEST)
				.entity(Json.createObjectBuilder()
						.add("response", false)
						.add("message", "Error! Id not found.")
						.add("id", id)
						.build().toString())
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	public static Response badNullId() {
		return Response
				.status(Response.Status.BAD_REQUEST)
				.entity(Json.createObjectBuilder()
						.add("response", false)
						.add("message", "Error! Json request: 'id' is empty.")
						.build().toString())
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	public static Response badNullTitle() {
		return Response
				.status(Response.Status.BAD_REQUEST)
				.entity(Json.createObjectBuilder()
						.add("response", false)
						.add("message", "Error! Json request: 'title' is empty.")
						.build().toString())
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	public static Response badNullText() {
		return Response
				.status(Response.Status.BAD_REQUEST)
				.entity(Json.createObjectBuilder()
						.add("response", false)
						.add("message", "Error! Json request: 'text' is empty.")
						.build().toString())
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
}
