package com.lokal.Model;

import java.util.Date;

public class Article {
    private Integer id;
    private String header;
    private String data;
    private String author;
    private Date lastUpdated;

    public Article() {
    }

    public Article(String header, String data, String author, Date lastUpdated) {
        this.header = header;
        this.data = data;
        this.author = author;
        this.lastUpdated = lastUpdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
