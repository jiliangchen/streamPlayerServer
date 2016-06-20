package jiliang.chen.streamPlayerServer.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import jiliang.chen.streamPlayerServer.model.StreamVedio;
import jiliang.chen.streamPlayerServer.model.VedioCategory;

@Service("configSerivce")
public class ConfigSerivce {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
	public List<VedioCategory> listCategories(){
		List<VedioCategory> result =jdbcTemplate.query("select id,label from vedio_category", new RowMapper<VedioCategory>(){
			@Override
			public VedioCategory mapRow(ResultSet set, int index) throws SQLException {
				VedioCategory vc = new VedioCategory(set.getString("label")); 
				vc.setId(set.getInt("id"));
				return vc;
			}
		});
		
		return result;
	}
	
	public List<StreamVedio> listVedioInCategory(int id){
		List<StreamVedio> result =jdbcTemplate.query("select name,url,description from stream_vedio where category = " + id, new RowMapper<StreamVedio>(){
			@Override
			public StreamVedio mapRow(ResultSet set, int index) throws SQLException {
				StreamVedio sv = new StreamVedio(set.getString("name"), set.getString("url"), set.getString("description")); 
				return sv;
			}
		});
		
		return result;
	}
}
