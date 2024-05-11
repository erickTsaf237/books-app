package com.app.booksapp.model;


public interface MyEntity<ID> {
    public ID getId();
    //@JsonIgnore
    public void setId(ID i);
}



