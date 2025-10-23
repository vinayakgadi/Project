package com.codegnan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.Exception.BookNotFoundException;
import com.codegnan.Util.DVConnectionUtil;
import com.codegnan.model.Book;

public class BookDaoimpl implements BookDao {

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		String query="INSERT INTO LIBRARY(BID,BNAME,ANAME,PRICE) VALUES(?,?,?,?)";
		try(Connection con=DVConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(query)) {
			
			pst.setInt(1, book.getBid());
			pst.setString(2, book.getBname());
			pst.setString(3, book.getAname());
			pst.setDouble(4, book.getPrice());
			
			pst.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Insertion Failed"+e.getMessage());
			e.printStackTrace();
			
		}
		
	}

	@Override
	public List<Book> finalAll() {
		// TODO Auto-generated method stub
		String query="SELECT*FROM LIBRARY";
		List<Book> li= new ArrayList<>();
		try(Connection con=DVConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(query)){
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				li.add(new Book(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4)));
				
			}
			
		}catch(SQLException e) {
			System.out.println("Fetch Failed"+e.getMessage());
			
		}
		return li;
	}

	@Override
	public Book findById(int id) throws BookNotFoundException {
		// TODO Auto-generated method stub
		String query="SELECT*FROM LIBERARY WHERE ID=?";
		try(Connection con=DVConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(query)){
			pst.setInt(1, id);
			 ResultSet rs=pst.executeQuery();
			 if(rs.next()) {
				 return new Book(rs.getInt(1),
						 rs.getString(2),
						 rs.getString(3),
						 rs.getDouble(4));
				 
			 }else {
				 throw new BookNotFoundException(id+"Not Found.");
			 }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public void Update(Book book) throws BookNotFoundException {
		// TODO Auto-generated method stub
		String query="UPDATE LIBRARY SET BNAME=?,ANAME=?,PRICE=? WHERE BID=?";
		try(Connection con=DVConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(query)){
			pst.setInt(1, book.getBid());
			pst.setString(2, book.getBname());
			pst.setString(3, book.getAname());
			pst.setDouble(4, book.getPrice());
			
		        int rows_effected = pst.executeUpdate();
		        if(rows_effected==0) {
		            throw new BookNotFoundException(book.getBid()+" Book not found.");
		        }else {
		            System.out.println("Updated "+ book);
		        }
		    }catch(SQLException e) {
		        System.out.println("Updation Failed: "+ e.getMessage());
		    }


			
		}
		
	

	@Override
	public void DeleteById(int Id) throws BookNotFoundException {
		// TODO Auto-generated method stub
		String query="DELECT FROM LIBRARY WHERE BID=?";
		try(Connection con=DVConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(query)){
			pst.setInt(1, Id);
			int rows_effected=pst.executeUpdate();
			if(rows_effected==0) {
				throw new BookNotFoundException(Id+"Book not found");
			}else {
				System.out.println("delected Successfull");
			}
			
		}catch(SQLException e) {
			System.out.println("delection failed"+e.getMessage());
		}
		
		
	}

	public List<Book> findAll() {
		
		String query="SELECT*FROM LIBRARY";
		List<Book> li= new ArrayList<>();
		try(Connection con=DVConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(query)){
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				li.add(new Book(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4)));
				
			}
			
		}catch(SQLException e) {
			System.out.println("Fetch Failed"+e.getMessage());
			
		}
		return li;
	}

	

}
