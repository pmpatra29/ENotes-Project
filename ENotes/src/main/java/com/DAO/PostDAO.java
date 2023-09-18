package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Bean.PostBean;

public class PostDAO {

	private Connection conn;

	public PostDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean AddNotes(String ti, String co, int id) {
		boolean f = false;
		try {
			String query = "insert into enotes_content(title,content,user_id) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	
	public List<PostBean> getData(int id) {

		List<PostBean> list = new ArrayList<PostBean>();

		PostBean pb = null;

		try {
			String query = "select * from enotes_content where user_id =? order by content_id DESC";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pb = new PostBean();
				pb.setId(rs.getInt(1));
				pb.setTitle(rs.getString(2));
				pb.setContent(rs.getString(3));
				pb.setPdate(rs.getDate(4));

				list.add(pb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public PostBean getDataById(int noteId) {
		
		PostBean p = null;
		
		try {
			
			String query = "select * from enotes_content where content_id=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, noteId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				p = new PostBean();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return p;
	}
	
	public boolean PostUpdate(int nid,String ti,String co) {
		boolean f = false;
		
		try {
			
			String query = "update enotes_content set title=?,content=? where content_id=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, nid);
			
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}
	
	
	public boolean deleteNotes(int nid) {
		
		boolean f = false;
		
		try {
			
			String query = "delete from enotes_content where content_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, nid);
			
			int x = ps.executeUpdate();
			
			if(x==1) {
				
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}

}
