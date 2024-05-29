package kr.co.biz.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.biz.board.Board;
import kr.co.biz.board.BoardService;
import kr.co.biz.board.ResponseDTO;

@RestController
@RequestMapping("/boards")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@PostMapping
	public String register(@Validated @RequestBody Board board) throws Exception {
		board.setRegDate(LocalDateTime.now());
        service.save(board);
		return "ok";
	}
	
	
	@GetMapping
	public List<Board> list() {
		List<Board>  bl = service.findAll();
		for(Board b : bl) {
			System.out.println("b: "+b.toString());
		}
		return bl;
	} 

	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) throws Exception {
		Optional<Board> boardList = service.findById(boardNo);
		Board board = null;
        if(boardList.isPresent()) {
        	board = boardList.get();
        }
		return new ResponseEntity<>(board, HttpStatus.OK);
	}
	
	@GetMapping("/search/{keyword}")
	public List<Board> search(@PathVariable("keyword") String keyword) throws Exception {
		keyword = "%"+keyword+"%";
		List<Board> board = service.findByTitleLikeOrWriterLike( keyword ,  keyword );
//		List<Board> board = service.findByTitleLikeAndWriterLike( keyword ,  keyword );
		return board;
	}
	
	
	@PutMapping("/{boardNo}")
	public String modify(@PathVariable("boardNo") int boardNo, @Validated @RequestBody Board board) throws Exception {
		Optional<Board> boardList = service.findById(boardNo);
		Board vo = null;
        if(boardList.isPresent()) {
        	vo = boardList.get();
        	vo.setBoardNo(boardNo);
        	vo.setContent(board.getContent());
        	vo.setTitle(board.getTitle());
        	vo.setWriter(board.getWriter());
        	service.save(vo);
        }
		return "ok";
	}
	
	@DeleteMapping("/{boardNo}")
	public String remove(@PathVariable("boardNo") int boardNo) throws Exception {
//		Optional<Board> boardList = this.service.findById(boardNo);
//		Board vo = null;
//        if(boardList.isPresent()) {
//        	vo = boardList.get();
//        }
//        this.service.delete(vo);
        service.deleteById(boardNo);
		return "삭제되었습니다.";
	}
	
	@GetMapping("/test/{keyword}")
	public ResponseDTO<String> testControllerResponseBody(@PathVariable("keyword") String keyword) {
		keyword = "%"+keyword+"%";
		List<Board> board = service.findByTitleLikeOrWriterLike( keyword ,  keyword );
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("keyword", keyword);
		map.put("result", board);
		ResponseDTO<String> response = ResponseDTO.<String>builder().mapdata(map).error("200").build();
		return response;
	}
}
