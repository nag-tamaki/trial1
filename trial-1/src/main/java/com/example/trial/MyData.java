package com.example.trial;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mydata")

@NamedQuery(name = "findByAge", query = "from MyData where age > :min and age < :max")

/*
@NamedQueries(
		@NamedQuery(
				name="findWithName",
				query="from MyData where name like :fname" )
		)
*/
public class MyData {

	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable = true)
	private List<MsgData> msgdatas;
	public List<MsgData> getMsgdatas(){
		return msgdatas;
	}
	public void setMsgDatas(List<MsgData> msgdatas) {
		this.msgdatas = msgdatas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column(length=50, nullable=false)
	private String name;

	@Column(length=200, nullable=false)
	private String mail;

	@Column(nullable=true)
	private Integer age;

	@Column(nullable=true)
	private String memo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


}