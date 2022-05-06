package com.javainuse.message;

public class ResponseFile {
  private String name;
  private String url;
  private String type;
  private long size;
  private long id;
  private String lugar;

  /*public ResponseFile(String name, String url, String type, long size) {
    this.name = name;
    this.url = url;
    this.type = type;
    this.size = size;
  }*/

    public ResponseFile(String name, String url, String type, long size,long id, String lugar) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
        this.id = id;
        this.lugar = lugar;
    }
  

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

    public long getId() {
        return id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
  

}
