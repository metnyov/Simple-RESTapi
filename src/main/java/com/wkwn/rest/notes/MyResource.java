package com.wkwn.rest.notes;

import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getNotes() { return NoteArray.toJsonArray().toString(); }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNote(Note note) {

        if (note.getTitle() == null)
            return MyResponse.badNullTitle();
        else if (note.getText() == null)
            return MyResponse.badNullText();
        note.changeId();
        NoteArray.notes.put(note.getId(), note);
        return MyResponse.goodPost(note.getId());
    }

    @PUT	//update
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNote(Note note) {

        if (note.getId() == null)
            return MyResponse.badNullId();
        else if (note.getTitle() == null)
            return MyResponse.badNullTitle();
        else if (note.getText() == null)
            return MyResponse.badNullText();
        else if (NoteArray.updNoteById(note.getId(), note.getTitle(), note.getText()))
            return MyResponse.goodUpdate(note.getId());
        else
            return MyResponse.badNotFoundId(note.getId());
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteNote(Note note) {
        if (note.getId() == null)
            return MyResponse.badNullId();
        else if (NoteArray.removeNoteById(note.getId()))
            return MyResponse.goodDelete(note.getId());
        else
            return MyResponse.badNotFoundId(note.getId());
    }
}
