package kr.co.four;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.four.vo.DataBaseVo;

@Service
public class TestService implements UserDetailsService {

	private final DBRepository dao;
	
	public TestService(DBRepository dao) {
		this.dao = dao;
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException { //사용자를 찾습니다.
		DataBaseVo vo = dao.findByUserId(userId);
		return vo;
	}
	
	
	public boolean newMember(DataBaseVo vo) {  //사용자 가입 메소드 입니다.
		vo = dao.save(vo);
		System.out.println("vo.getIdx() : "+vo.getIdx());
		if(vo.getIdx() == null || vo.getIdx() <=0) return false;
		return true;
	}
	
}
