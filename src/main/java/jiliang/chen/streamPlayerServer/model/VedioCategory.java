package jiliang.chen.streamPlayerServer.model;
import java.util.ArrayList;
import java.util.List;

public class VedioCategory{
	private List<StreamVedio> vedios = new ArrayList<StreamVedio>();
	private String label;
	private int id;

	public VedioCategory(String label){
		setLabel(label);
	}

	public String getLabel(){
		return this.label;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public List<StreamVedio> getVedios(){
		return vedios;
	}

	public void addVedio(StreamVedio video){
		vedios.add(video);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}