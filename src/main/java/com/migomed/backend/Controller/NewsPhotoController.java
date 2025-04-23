package com.migomed.backend.Controller;

import com.migomed.backend.Entity.News;
import com.migomed.backend.Entity.NewsPhoto;
import com.migomed.backend.Entity.Photo;
import com.migomed.backend.Service.NewsPhotoService;
import com.migomed.backend.Service.NewsService;
import com.migomed.backend.Service.PhotoService;
import com.migomed.backend.dto.NewsPhotoIdsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/newsPhoto")
@RequiredArgsConstructor
public class NewsPhotoController {
    private final PhotoService photoService;
    private final NewsService newsService;
    private final NewsPhotoService newsPhotoService;

    @GetMapping
    public ResponseEntity<NewsPhotoIdsDTO> getNewsPhotoIds() {
        // Логика получения списка всех записей NewsPhoto.
        // Например, можно пройтись по найденным записям, собрать id фото и новости в два списка.
        List<NewsPhoto> newsPhotoList = newsPhotoService.getAllNewsPhoto();
        List<Long> photoIds = newsPhotoList.stream()
                .map(np -> np.getPhoto().getId())
                .distinct()  // если нужны уникальные значения
                .collect(Collectors.toList());
        List<Long> newsIds = newsPhotoList.stream()
                .map(np -> np.getNews().getId())
                .distinct()
                .collect(Collectors.toList());

        NewsPhotoIdsDTO response = new NewsPhotoIdsDTO();
        response.setPhotoIds(photoIds);
        response.setNewsIds(newsIds);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<NewsPhoto> getNewsPhotoById(@PathVariable Long id) {
        NewsPhoto newsPhoto = newsPhotoService.getNewsPhotoById(id);
        if (newsPhoto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newsPhoto);
    }

    @PostMapping
    public ResponseEntity<NewsPhotoIdsDTO> createNewsPhotoRecordsRoot(@RequestBody NewsPhotoIdsDTO dto) {
        // Аналогичная логика создания записей, как в методе /batch
        if (dto.getPhotoIds() != null && dto.getNewsIds() != null) {
            for (Long photoId : dto.getPhotoIds()) {
                for (Long newsId : dto.getNewsIds()) {
                    Photo photo = photoService.getPhotoById(photoId);
                    News news = newsService.getNewsById(newsId);
                    if (photo != null && news != null) {
                        NewsPhoto newsPhoto = new NewsPhoto();
                        newsPhoto.setPhoto(photo);
                        newsPhoto.setNews(news);
                        newsPhotoService.saveNewsPhoto(newsPhoto);
                    }
                }
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }



    @PutMapping("/{id}")
    public ResponseEntity<NewsPhoto> updateNews(@PathVariable Long id, @RequestBody NewsPhoto updatedNewsPhotoData) {
        NewsPhoto existingNewsPhoto = newsPhotoService.getNewsPhotoById(id);
        if (existingNewsPhoto == null) {
            return ResponseEntity.notFound().build();
        }
        existingNewsPhoto.setPhoto(updatedNewsPhotoData.getPhoto());
        existingNewsPhoto.setNews(updatedNewsPhotoData.getNews());
        NewsPhoto updatedNewsPhoto = newsPhotoService.saveNewsPhoto(existingNewsPhoto);
        return ResponseEntity.ok(updatedNewsPhoto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNewsPhoto(@PathVariable Long id) {
        newsPhotoService.deleteNewsPhoto(id);
        return ResponseEntity.noContent().build();
    }
}
