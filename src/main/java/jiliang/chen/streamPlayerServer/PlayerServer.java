package jiliang.chen.streamPlayerServer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jiliang.chen.streamPlayerServer.model.PlayerConfig;
import jiliang.chen.streamPlayerServer.model.StreamVedio;
import jiliang.chen.streamPlayerServer.model.VedioCategory;
import jiliang.chen.streamPlayerServer.service.ConfigSerivce;

@SpringBootApplication
@RequestMapping("/player/stream")
public class PlayerServer {
	@Autowired
	ConfigSerivce configSerivce;
	
	public static void main(String[] args) {
		SpringApplication.run(PlayerServer.class, args);
	}

	@RequestMapping("/welcome")
	public @ResponseBody String sayHello() {
		return "hello,this is the config server of stream player";
	}

	@RequestMapping("/config")
	public @ResponseBody PlayerConfig sayHello(
			@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
		PlayerConfig result = new PlayerConfig();

		List<VedioCategory> categories = configSerivce.listCategories();
		for(VedioCategory c:categories){
			List<StreamVedio> vedios = configSerivce.listVedioInCategory(c.getId());
			for(StreamVedio sv:vedios){
				c.addVedio(sv);
			}
			
			result.addCategory(c);
		}
		
		return result;
	}
	
	private PlayerConfig getConfig(){
		PlayerConfig result = new PlayerConfig();
		result.addCategory(getHearthStone());
		result.addCategory(getLol());
		return result;
	}

	private VedioCategory getHearthStone() {
		VedioCategory c = new VedioCategory("炉石传说");
		StreamVedio qiuri = new StreamVedio("秋日", "http://flv.quanmin.tv/live/2821027_L4.flv", "");
		StreamVedio yilidi = new StreamVedio("中华毅力帝", "http://flv.quanmin.tv/live/2839314_L4.flv", "");
		StreamVedio wangbuer = new StreamVedio("王不二", "http://flv.quanmin.tv/live/2820986_L4.flv", "");
		c.addVedio(qiuri);
		c.addVedio(yilidi);
		c.addVedio(wangbuer);
		return c;
	}

	private VedioCategory getLol() {
		VedioCategory c = new VedioCategory("英雄联盟");
		StreamVedio xiolong = new StreamVedio("全民小龙", "http://flv.quanmin.tv/live/29105_L4.flv", "");
		c.addVedio(xiolong);
		return c;
	}
}
