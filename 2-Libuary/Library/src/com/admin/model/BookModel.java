package com.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.entiy.Book;
import com.common.utils.DbHuilder;

public class BookModel {
	

	/**
	 * �������
	 * @param book
	 * @return i>0�ɹ�
	 */
	public int addBook(Book book){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into bookinfo values(my_bookinfo.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, book.getIsbn(), book.getBookname(), book.getTypeid(), book.getPublisher(), book.getWriter(), book.getPicture(), book.getIntroduce(), book.getPrice(), book.getNewbook(), book.getCommand());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	//��ѯ���е�������
	public int allNum(){
		int count = 0; //��¼���й��ж���������
		Connection conn = DbHuilder.getConn();
		//�����еļ�¼�����������count��
		String sql = " SELECT COUNT(*) count FROM bookinfo ";
		ResultSet rs2 = DbHuilder.executeQuery(conn, sql);
		try {
			if(rs2.next()){
				count = rs2.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	/**
	 * ��ѯͼ����Ϣ
	 * @return ����һ��Book����
	 */
	public List<Book> queryBookInfo(int min, int max){
		Connection conn = DbHuilder.getConn();

		String sql = "select * from (select t.*, rownum rn from bookinfo t order by bookid) m, booktype b where m.typeid=b.typeid and m.rn between ? and ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, min, max);
		//����һ��Book���͵ļ���
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			while(rs.next()){
				Book book = new Book();
				book.setBookid(rs.getInt("bookid"));
				book.setIsbn(rs.getString("isbn"));
				book.setBookname(rs.getString("bookname"));
				book.setPublisher(rs.getString("publisher"));
				book.setIntroduce(rs.getString("introduce"));
				book.setPicture(rs.getString("picture"));
				book.setPrice(rs.getInt("price"));
				book.setTypeid(rs.getInt("typeid"));
				book.setTypename(rs.getString("typename"));
				book.setNewbook(rs.getInt("newbook"));
				book.setCommand(rs.getInt("command"));
				book.setWriter(rs.getString("writer"));
				
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return bookList;
	}
	
	/**
	 * ɾ��ָ�����鼮
	 * @param book
	 * @return i>0 �ɹ�
	 */
	public int deleteBookModel(Book book){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from bookinfo where isbn = ?";
		int i = DbHuilder.executeUpdate(conn, sql, book.getIsbn());
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
	public List<Book> checkOneBookModel(Book book){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from bookinfo bo, booktype be where bo.typeid = be.typeid and bookid = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, book.getBookid());
		//����һ��Book���͵ļ���
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			while(rs.next()){
				Book book2 = new Book();
				book2.setBookid(rs.getInt("bookid"));
				book2.setIsbn(rs.getString("isbn"));
				book2.setBookname(rs.getString("bookname"));
				book2.setPublisher(rs.getString("publisher"));
				book2.setIntroduce(rs.getString("introduce"));
				book2.setPicture(rs.getString("picture"));
				book2.setPrice(rs.getInt("price"));
				book2.setTypeid(rs.getInt("typeid"));
				book2.setTypename(rs.getString("typename"));
				book2.setNewbook(rs.getInt("newbook"));
				book2.setCommand(rs.getInt("command"));
				book2.setWriter(rs.getString("writer"));
				
				bookList.add(book2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return bookList;
	}
	
	
	public int editBook(Book book){
		Connection conn = DbHuilder.getConn();
		String sql = "";
		int i = 0;
		if(book.getPicture() == ""){
			sql = "update bookinfo set isbn=?, bookname=?, typeid=?, publisher=?, writer=?, introduce=?, price=?, newbook=?, command=? where bookid = ?";
			
			i = DbHuilder.executeUpdate(conn, sql, book.getIsbn(), book.getBookname(), book.getTypeid(), book.getPublisher(), book.getWriter(), book.getIntroduce(), book.getPrice(), book.getNewbook(), book.getCommand(), book.getBookid());
		}else{
			sql = "update bookinfo set isbn=?, bookname=?, typeid=?, publisher=?, writer=?, picture=?, introduce=?, price=?, newbook=?, command=? where bookid = ?";
			
			i = DbHuilder.executeUpdate(conn, sql,  book.getIsbn(), book.getBookname(), book.getTypeid(), book.getPublisher(), book.getWriter(),book.getPicture(), book.getIntroduce(), book.getPrice(), book.getNewbook(), book.getCommand(), book.getBookid());
		}
		DbHuilder.colseConn(conn);
		return i;
	}
	
	
	/**
	 * ȡ������ļ���
	 * @return
	 */
	public List<Book> queryNewBook(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from (select t.*, rownum rn from bookinfo t where newbook=1 order by bookid desc) m, booktype b where m.typeid=b.typeid and m.rn between 1 and 4";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		//����һ��Book���͵ļ���
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			while(rs.next()){
				Book book = new Book();
				book.setBookid(rs.getInt("bookid"));
				book.setIsbn(rs.getString("isbn"));
				book.setBookname(rs.getString("bookname"));
				book.setPublisher(rs.getString("publisher"));
				book.setIntroduce(rs.getString("introduce"));
				book.setPicture(rs.getString("picture"));
				book.setPrice(rs.getInt("price"));
				book.setTypeid(rs.getInt("typeid"));
				book.setTypename(rs.getString("typename"));
				book.setNewbook(rs.getInt("newbook"));
				book.setCommand(rs.getInt("command"));
				book.setWriter(rs.getString("writer"));
				
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return bookList;
	}
	
	//������bookid���������Ϣ
	public Book checkOneBookInfo(int bookid){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from bookinfo bo, booktype be where bo.typeid = be.typeid and bookid = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, bookid);
		Book book = new Book();
		try {
			while(rs.next()){
				book.setBookid(rs.getInt("bookid"));
				book.setIsbn(rs.getString("isbn"));
				book.setBookname(rs.getString("bookname"));
				book.setPublisher(rs.getString("publisher"));
				book.setIntroduce(rs.getString("introduce"));
				book.setPicture(rs.getString("picture"));
				book.setPrice(rs.getInt("price"));
				book.setTypeid(rs.getInt("typeid"));
				book.setTypename(rs.getString("typename"));
				book.setNewbook(rs.getInt("newbook"));
				book.setCommand(rs.getInt("command"));
				book.setWriter(rs.getString("writer"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbHuilder.colseConn(conn);
		}
		
		return book;
	}
}




















