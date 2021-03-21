package com.example.moneytrancation.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="primaryaccount")
public class PrimaryAccount {
	
	@Column(name="id")
	private long id;
	@Column(name="accountNumber")
	private int accountNumber;
	
	@Column(name="accountBalance")
	private BigDecimal  accountBalance;
	
	@OneToMany(mappedBy="primaryAccount",cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<PrimaryTransaction> primarytransaction;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
	private User user;
	
	public PrimaryAccount()
	{
		
	}
	
	

	public PrimaryAccount(long id, int accountNumber, BigDecimal accountBalance,
			List<PrimaryTransaction> primarytransaction, User user) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.primarytransaction = primarytransaction;
		this.user = user;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<PrimaryTransaction> getPrimarytransaction() {
		return primarytransaction;
	}

	public void setPrimarytransaction(List<PrimaryTransaction> primarytransaction) {
		this.primarytransaction = primarytransaction;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PrimaryAccount [id=" + id + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", primarytransaction=" + primarytransaction + "]";
	}
	
	

}
