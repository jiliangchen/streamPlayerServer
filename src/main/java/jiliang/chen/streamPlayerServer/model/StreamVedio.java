package jiliang.chen.streamPlayerServer.model;
public class StreamVedio  {

    private String name;
    private String url;
    private String description;

    public StreamVedio(String name,String url,String description){
        setName(name);
        setUrl(url);
        setDescription(description);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}