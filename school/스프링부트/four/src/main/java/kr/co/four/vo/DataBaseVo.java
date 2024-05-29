package kr.co.four.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "User")
public class DataBaseVo  implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;
	
    private String name;
    private String auth;
    private String password;  //시큐리티에서는 password 라는 값을 비밀번호로 사용합니다. 그러므로 해당 규칙은 지켜야 합니다.
    
    @Column(unique = true)
    private String userId;

    
    //계정이 갖고있는 권한 목록은 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//가지고 있는 권한 가져와서 넣기. 권한이 n개(두 개 이상)라면 반복문을 통해 add 하여 줍니다.
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		
		if(auth!=null) {
			for(String autoOne : auth.split(",")) {
				list.add(new SimpleGrantedAuthority(autoOne)); 
			}
		}else {
			list.add(new SimpleGrantedAuthority("etc")); ;
		}
		return list;
	}
	
	@Override
	public String getUsername() {
		return this.userId;  //여기가 바로 사용자 아이디 입니다.
	}
	
	
	//계정이 만료되지 않았는지 리턴 (true: 만료 안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//계정이 잠겨있는지 않았는지 리턴. (true: 잠기지 않음)
    @Override
	public boolean isAccountNonLocked() {
		return true;
	}
    
    //비밀번호가 만료되지 않았는지 리턴한다. (true: 만료 안됨)
    @Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
    
    //계정이 활성화(사용가능)인지 리턴 (true: 활성화)
    @Override
	public boolean isEnabled() {
		return true;
	}
}