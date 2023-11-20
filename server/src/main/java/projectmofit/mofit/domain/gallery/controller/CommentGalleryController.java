package projectmofit.mofit.domain.gallery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.gallery.dto.CommentGallery;
import projectmofit.mofit.domain.gallery.service.CommentGalleryService;

import java.util.List;

@RestController
@RequestMapping("/gallery/comment")
@RequiredArgsConstructor
public class CommentGalleryController {

    private final CommentGalleryService commentGalleryService;

    @GetMapping
    public ResponseEntity<List<CommentGallery>> list(@RequestParam int galleryIdx){
        System.out.println(galleryIdx);
        List<CommentGallery> list = commentGalleryService.getComment(galleryIdx);
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> write(@RequestBody CommentGallery commentGallery){
        int result = commentGalleryService.addComment(commentGallery);
        if(result==0){
            return new ResponseEntity<Void>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //임시로 index 와 date로 엮어 놓음
    @PutMapping
    public ResponseEntity<Void> edit(@RequestBody CommentGallery commentGallery){
        System.out.println(commentGallery);
        commentGalleryService.editComment(commentGallery);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int commentIdx){
        System.out.println(commentIdx);
        int result = commentGalleryService.removeComment(commentIdx);
        if(result == 0){
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
