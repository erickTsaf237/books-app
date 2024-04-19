package com.app.booksapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface MyEntity<ID> {
    public ID getId();
    @JsonIgnore
    public void setId(ID i);
}
