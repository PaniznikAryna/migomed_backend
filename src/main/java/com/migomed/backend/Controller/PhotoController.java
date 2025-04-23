package com.migomed.backend.Controller;



import com.migomed.backend.Entity.News;
import com.migomed.backend.Entity.Photo;
import com.migomed.backend.Service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping
    public ResponseEntity<List<Photo>> getAllPhoto() {
        List<Photo> photoList = photoService.getAllPhoto();
        return ResponseEntity.ok(photoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photo> getPhotoById(@PathVariable Long id) {
        Photo photo = photoService.getPhotoById(id);
        if (photo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(photo);
    }

    @PostMapping
    public ResponseEntity<Photo> createPhoto(@RequestBody Photo photo) {
        Photo savedPhoto = photoService.savePhoto(photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPhoto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable Long id, @RequestBody Photo updatedPhotoData) {
        Photo existingPhoto = photoService.getPhotoById(id);
        if (existingPhoto == null) {
            return ResponseEntity.notFound().build();
        }
        existingPhoto.setPhotoPath(updatedPhotoData.getPhotoPath());
        existingPhoto.setSection(updatedPhotoData.getSection());
        Photo updatedPhoto = photoService.savePhoto(existingPhoto);
        return ResponseEntity.ok(updatedPhoto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Long id) {
        photoService.deletePhoto(id);
        return ResponseEntity.noContent().build();
    }

}
