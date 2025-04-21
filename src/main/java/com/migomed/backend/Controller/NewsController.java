package com.migomed.backend.Controller;

import com.migomed.backend.Entity.News;
import com.migomed.backend.Service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        List<News> newsList = newsService.getAllNews();
        return ResponseEntity.ok(newsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        News news = newsService.getNewsById(id);
        if (news == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(news);
    }

    @PostMapping
    public ResponseEntity<News> createNews(@RequestBody News news) {
        // publicationDate устанавливается по умолчанию в сущности
        News savedNews = newsService.saveNews(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News updatedNewsData) {
        News existingNews = newsService.getNewsById(id);
        if (existingNews == null) {
            return ResponseEntity.notFound().build();
        }
        // Обновляем только изменяемые поля (publicationDate не изменяется, так как updatable=false)
        existingNews.setHeadline(updatedNewsData.getHeadline());
        existingNews.setContent(updatedNewsData.getContent());
        News updatedNews = newsService.saveNews(existingNews);
        return ResponseEntity.ok(updatedNews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }
}
