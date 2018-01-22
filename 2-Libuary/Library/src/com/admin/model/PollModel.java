package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.Poll;
import com.common.utils.DbHuilder;

/**
 * ͶƱ���ݴ���
 * @author: �����
 *
 * 2017��10��25��
 */
public class PollModel {
	
	/**
	 * ��ѯͶƱ��Ϣ
	 * @return ����һ������
	 */
	public List<Poll> queryPollInfo(){
		Connection conn = DbHuilder.getConn();
		String sql = "select pollname,sum(pollnum) col from poll group by pollname";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		//����һ��BookClassify���͵ļ���
		List<Poll> pollList = new ArrayList<Poll>();
		
		try {
			while(rs.next()){
				Poll poll = new Poll();
				//poll.setPollid(rs.getInt("pollid"));
				poll.setPollname(rs.getString("pollname"));
				poll.setPollnum(rs.getInt("col"));
				pollList.add(poll);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return pollList;
	}
	
	public int addPoll(Poll poll){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into poll values(my_poll.nextval, ?, 1)";
		int i = DbHuilder.executeUpdate(conn, sql, poll.getPollname());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
}















