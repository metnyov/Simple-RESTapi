package com.wkwn.rest.notes;

import java.util.UUID;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;


public class Note {
	
    private String id;
    private String title;
    private String text;
    private Date createDate;
    private Date updateDate;

    public Note() {
    	this.createDate = new Date();
        this.updateDate = new Date();
    }
    
    public JsonObject toJsonObject() {
    	return Json.createObjectBuilder()
				.add("id", this.id)
				.add("title", this.title)
				.add("text", this.text)
				.add("date_create", this.createDate.getTime() / 1000)
				.add("date_update", this.updateDate.getTime() / 1000)
				.build();
    }
    
    public void changeId() { this.id = UUID.randomUUID().toString(); }
    
    public void refreshUpdateDate() { this.updateDate = new Date(); }
    
    public void setId(String id) { this.id = id; }
    
    public void setTitle(String title) { this.title = title; }

    public void setText(String text) { this.text = text; }
    
    public void setCreateDate(Date createDate) { this.createDate = createDate; }
    
    public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }

    public String getId() { return this.id; }

    public String getTitle() { return this.title; }

    public String getText() { return this.text; }

    public Date getCreateDate() { return this.createDate; }

    public Date getUpdateDate() { return this.updateDate; }
    
}
