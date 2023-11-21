package projectmofit.mofit.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.user.dto.Bookmark;
import projectmofit.mofit.domain.user.service.BookmarkService;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmark")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public ResponseEntity<Void> bookmark(@RequestParam int userId, @RequestParam String videoId, @RequestParam String thumbnails) {
        Bookmark bm = new Bookmark(userId, videoId, thumbnails);

        if (bookmarkService.bookmark(bm) > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public List<Bookmark> getBookmark(int userId) {
        return bookmarkService.getBookmark(userId);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBookmark(@RequestBody Bookmark bookmark) {
        if (bookmarkService.deleteBookmark(bookmark) > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
