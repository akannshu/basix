package com.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.dto.Account;
import com.account.exceptions.DataAccessException;


@Repository
public class AccountDaoImpl implements AccountDao {

	private DataSource dataSource;
	
	public AccountDaoImpl() {}
	
	@Autowired
	public AccountDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Account> getAllAccounts() {
		
		List<Account> accounts = new ArrayList<>();
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM account");
			pstmt.executeQuery();
			
			ResultSet rs = pstmt.getResultSet();
			while(rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getInt(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getDouble(3));
				accounts.add(acc);
			}
			
					
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
		
		return accounts;
	}

	public Account getById(Integer id) {
		
		Account acc = new Account();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM account WHERE id=?");
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			
			ResultSet rs = pstmt.getResultSet();
			while(rs.next()) {
				acc.setId(rs.getInt(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getDouble(3));
			}
			
					
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
		
		return acc;
	}

	public void update(Account account) {
		System.out.println(account);
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("UPDATE account SET balance=? WHERE id=?");
			pstmt.setDouble(1, account.getBalance());
			pstmt.setInt(2, account.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	public void delete(Integer id) {
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM account WHERE id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
					
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}

	}

	public void insert(Account account) {
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO account VALUES(?, ?, ?)");
			pstmt.setInt(1, account.getId());
			pstmt.setString(2, account.getName());
			pstmt.setDouble(3, account.getBalance());
			pstmt.executeUpdate();
					
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
		
	}

}
