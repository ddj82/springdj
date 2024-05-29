package kr.co.biz.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardService extends JpaRepository<Board, Integer>{
	
	/*
	@Transactional : 트랜젝션 제어 어노테이션 임. 
	    - 메서드레벨인 경우 : 해당 메소드의 정상완료 시 커밋, 예외 발생시 롤백 반환
	    - 클래스레벨인 경우 : 해당 클래스안의 모든 메소드 실행 시 정상완료 시 커밋, 예외 발생시 롤백 반환
	@Modifying : DML의 경우(insert, delete, update) 데이터를 수정하는 쿼리라는 것을 명시해주어야 해당쿼리가 DML임을 인식할 수 있다.
	@Query(value="SQL쿼리문", nativeQuery = true) : SQL쿼리문을 직접 대입하여 사용할 수 있도록 해주는 어노테이션임.
	    - nativeQuery = true : 네이티브SQL, 원시동적SQL을 사용한다는 속성임. 
	 * 
	 * 
	 * */
	public static final String INSERT_BOARD = "INSERT INTO BOARD ( CONTENT , TITLE,  WRITER , REG_DATE )  VALUES  ( :#{#board.content} ,  :#{#board.title} , :#{#board.writer} , , :#{#board.regDate} ) ";
	
	@Transactional
	@Modifying
	@Query(value=INSERT_BOARD, nativeQuery = true)
	int insertBoard(@Param("board") Board board);
	
	
	
	@Query(value="SELECT * FROM BOARD ORDER BY BOARD_NO DESC", nativeQuery = true)
	List<Board> findByBoard();
	
	@Query(value="SELECT * FROM BOARD WHERE BOARD_NO = ?1", nativeQuery = true)
	Board findByBoardNo(int boardNo);
	
	
	@Query(value="SELECT * FROM BOARD WHERE TITLE LIKE ?1 OR WRITER LIKE ?2", nativeQuery = true)
	List<Board> findByTitleOrWriter(String title, String writer);

	
	
	
	public static final String UPDATE_BOARD = "UPDATE BOARD SET CONTENT = :#{#board.content} , TITLE = :#{#board.title} , WRITER = :#{#board.writer} WHERE BOARD_NO = :#{#board.boardNo} ";
	
	@Transactional
	@Modifying
	@Query(value=UPDATE_BOARD, nativeQuery = true)
	int updateBoard(@Param("board") Board board);
	
	
	
	
	public static final String DELETE_BOARD = "DELETE FROM BOARD WHERE BOARD_NO = :boardNo ";
	
	@Transactional
	@Modifying
	@Query(value=DELETE_BOARD, nativeQuery = true)
	int deleteBoard(@Param("boardNo") int boardNo);
	
}
