package com.example;

import org.springframework.web.bind.annotation.*;

/**
 * Created by trainer2 on 4/12/17.
 */

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Lesson specificLesson(@PathVariable String id) {
        Long lessonId = Long.parseLong(id);
        return this.repository.findOne(lessonId);
    }

    @PatchMapping("/{id}")
    public Lesson update1(@PathVariable String id, @RequestBody Lesson lesson) {
        Long lessonId = Long.parseLong(id);
        Lesson update = repository.findOne(lessonId);
        update.setId(lesson.getId());
        update.setTitle(lesson.getTitle());
        return  this.repository.save(update);
    }


    @DeleteMapping("/{id}")
    public Iterable<Lesson> delete(@PathVariable String id) {
        Long lessonId = Long.parseLong(id);
        repository.delete(lessonId);
        return this.repository.findAll();

    }

    @RequestMapping(consumes = "application/json")
    @PostMapping("")
    public Lesson  createLesson(@RequestBody Lesson lesson) {

        Lesson newLesson = new Lesson();
        newLesson.setId(lesson.getId());
        newLesson.setTitle(lesson.getTitle());
        this.repository.save(newLesson);

        return newLesson;
    }

}