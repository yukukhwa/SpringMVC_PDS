package com.test.pds;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.pds.board.service.Board;
import com.test.pds.board.service.BoardFile;
import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired private BoardService boardService;
	
	@RequestMapping(value = "/getBoardOne", method = RequestMethod.GET)
	public String selectBoardOne(Model model, int boardId) {		
		Map<String, Object> map = boardService.selectBoardOne(boardId);
		model.addAttribute("board", map.get("board"));
		model.addAttribute("boardFileList", map.get("boardFileList"));
		return "board/getBoardOne";
	}
	
	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String selectBoardList(Model model, @RequestParam(value="currentPage",defaultValue="1") int currentPage, @RequestParam(value="pagePerRow",defaultValue="3") int pagePerRow) {
		Map<String, Object> map = boardService.selectBoardList(currentPage, pagePerRow);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		return "board/getBoardList";
	}
	@RequestMapping(value = "/addBoard", method = RequestMethod.GET)
	public String insertBoard() {
		return "board/addBoard";
	}
	
	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
	public String insertBoard(BoardRequest boardRequest) {
		boardService.insertBoard(boardRequest);
		return "redirect:/getBoardList";
	}
		
	
		
}
