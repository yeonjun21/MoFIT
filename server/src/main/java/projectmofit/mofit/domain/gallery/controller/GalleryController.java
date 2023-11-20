package projectmofit.mofit.domain.gallery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.board.dto.Board;
import projectmofit.mofit.domain.gallery.dto.Gallery;
import projectmofit.mofit.domain.gallery.service.GalleryService;

import java.io.BufferedInputStream;
import java.sql.Blob;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/gallery")
@RequiredArgsConstructor
public class GalleryController {

    private final GalleryService galleryService;

    @GetMapping
    public ResponseEntity<?> list(@RequestParam int groupId){
        List<Gallery> list = galleryService.getGallery(groupId);
        if(list.size() == 0){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        for(Gallery gallery : list){
            byte[] arr = gallery.getByteImg();
            if(arr != null && arr.length > 0){
                String base64Encode = byteToBase64(arr);
                base64Encode = "data:image/jpeg;base64," + base64Encode;
                gallery.setImg(base64Encode);
            }
        }
        return new ResponseEntity<List<Gallery>>(list, HttpStatus.OK);
    }

    @GetMapping("/{index}")
    public ResponseEntity<?> detail(@PathVariable int index){
        Gallery gallery = galleryService.getImgByIndex(index);

        byte[] arr = gallery.getByteImg();

        if(arr != null && arr.length > 0){
            String base64Encode = byteToBase64(arr);
            base64Encode = "data:image/jpeg;base64," + base64Encode;
            gallery.setImg(base64Encode);

            return new ResponseEntity<>(gallery, HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    

    @PostMapping
    public ResponseEntity<Void> write(@RequestBody Gallery gallery){
        byte[] imgArr = null;
        final String BASE_64_PREFIX = "data:image/jpeg;base64,";
        try {
            String base64url = gallery.getImg();
            if(base64url.startsWith(BASE_64_PREFIX)){
                imgArr = Base64.getDecoder().decode(base64url.substring(BASE_64_PREFIX.length()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gallery.setByteImg(imgArr);
        int result = galleryService.addImg(gallery);

        if(result==0){
            return new ResponseEntity<Void>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> edit(@RequestBody Gallery gallery){
        byte[] imgArr = null;
        final String BASE_64_PREFIX = "data:image/jpeg;base64,";
        try {
            String base64url = gallery.getImg();
            if(base64url.startsWith(BASE_64_PREFIX)){
                imgArr = Base64.getDecoder().decode(base64url.substring(BASE_64_PREFIX.length()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gallery.setByteImg(imgArr);
        galleryService.editGallery(gallery);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int index){
        galleryService.removeComment(index);
        int result = galleryService.removeGallery(index);
        if(result == 0){
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private static String byteToBase64(byte[] arr){
        String result = "";
        try {
            result = Base64.getEncoder().encodeToString(arr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
