package kr.co.biz.dept;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@Column(length = 200)
	private String uid;
	
	@Column(length = 200)
	private String unm;
	
	private int uage;
	
	private int deptno;
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//	@Transient
	@ManyToOne
    @JoinColumn(name="DEPTNO" , insertable = false, updatable = false)
	private Dept dept;

}
