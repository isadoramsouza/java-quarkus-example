package com.isadora.controller;

import com.isadora.model.dto.BookDTO;
import com.isadora.service.BookService;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.AllArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@AllArgsConstructor
@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    private BookService bookService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        return Response.ok(bookService.findById(id)).status(HttpResponseStatus.OK.code()).build();
    }

    @POST
    public Response save(BookDTO bookDTO) {
        bookService.save(bookDTO);
        return Response.ok().status(HttpResponseStatus.CREATED.code()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        bookService.delete(id);
        return Response.ok().status(HttpResponseStatus.OK.code()).build();
    }
}