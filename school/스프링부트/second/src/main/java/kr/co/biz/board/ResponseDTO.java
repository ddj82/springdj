package kr.co.biz.board;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
	private String error;
	private List<T> data;
	private Map<T, Object> mapdata;
}

/*@Data :게터(Getter), 세터(Setter), toString(), equals(), hashCode() 메서드 등을 생성해주는 기능을 제공*/