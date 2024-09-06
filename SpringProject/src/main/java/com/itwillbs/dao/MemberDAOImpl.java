package com.itwillbs.dao;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.itwillbs.domain.MemberDTO;

public class MemberDAOImpl implements MemberDAO{
	
	private SimpleJdbcTemplate jdbcTemplate;
	private String sql;
	
	@Inject
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl insertMember()");
		sql = "insert into members(id,pass,name,date) values(?,?,?,?)";
		jdbcTemplate.update(sql, memberDTO.getId(), memberDTO.getPass(), memberDTO.getName(), memberDTO.getDate());
	}
	
}
