package jiliang.chen.streamPlayerServer.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerConfig {
	private String version = "1.0.0";
	private List<VedioCategory> categories = new ArrayList<VedioCategory>();

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<VedioCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<VedioCategory> categories) {
		this.categories = categories;
	}
	
	public void addCategory(VedioCategory category){
		categories.add(category);
	}
}
