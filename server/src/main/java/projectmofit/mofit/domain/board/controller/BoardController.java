package projectmofit.mofit.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.board.dto.Board;
import projectmofit.mofit.domain.board.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    //인터셉터가 접근을 막기 때문에 groupId만 받는다
    @GetMapping
    public ResponseEntity<?> list(@RequestParam int groupId){
        List<Board> list = boardService.getBoard(groupId);
        if(list.size() == 0){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
    }
    //deltail form에서 index를 날려줌
    @GetMapping("/{index}")
    public ResponseEntity<?> detail(@PathVariable int index){
        Board board = boardService.getBoardByGroupId(index);
        if(board == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    //글 등록시 프론트에서 전부 채워서 들어옴
    @PostMapping
    public ResponseEntity<?> write(@RequestBody Board board){
        int result = boardService.addBoard(board);
        if(result == 0){
            return new ResponseEntity<Void>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //detailform -> editform -> 새로운 board가 들어옴
    @PutMapping
    public ResponseEntity<Void> edit(@RequestBody Board board){
        boardService.editBoard(board);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int index){
        boardService.removeComment(index);
        int result = boardService.removeBoard(index);
        if(result == 0){
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
