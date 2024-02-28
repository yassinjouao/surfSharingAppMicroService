package com.example.coment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coments")
@RequiredArgsConstructor
/*public class ComentController {

    private final ComentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Coment coment
    ){
        service.saveComent(coment);
//        Comment savedComment = commentService.addComment(comment);
//        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Coment>> fingAllComents(){
        return ResponseEntity.ok(service.findAllComents());

    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Coment>> fingAllComents(
            @PathVariable("school-id") Integer schoolId
    ){
        return ResponseEntity.ok(service.findAllComentsBySchool(schoolId));

    }
}

////
@RestController
@RequestMapping("/comment")*/
public class ComentController {

    //@Autowired
    private final ComentServiceI service;

    @PostMapping("/add")
    public ResponseEntity<Coment> addComent(@RequestBody Coment coment) {
        Coment savedComent = service.addComent(coment);
        return new ResponseEntity<>(savedComent, HttpStatus.CREATED);
    }

    @GetMapping("/{comentId}")
    public ResponseEntity<Coment> getComentById(@PathVariable Integer comentId) {
        Coment coment = service.getComentById(comentId);
        if (coment != null) {
            return new ResponseEntity<>(coment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{comentId}")
    public ResponseEntity<Coment> updateComent(@PathVariable Integer comentId, @RequestBody Coment updatedComent) {
        Coment coment = service.updateComent(comentId, updatedComent);
        if (coment != null) {
            return new ResponseEntity<>(coment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{comentId}")
    public ResponseEntity<Void> deleteComent(@PathVariable Integer comentId) {
        boolean deleted = service.deleteComent(comentId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/content/{content-id}")
    public ResponseEntity<List<Coment>> fingAllComentsByContentId(
            @PathVariable("content-id") Integer contentId
    ){
        List<Coment> comments = service.getComentsByContentId(contentId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
       // return ResponseEntity.ok(service.findAllComentsByContent(contentId));

    }

    @GetMapping("/all")
    public ResponseEntity<List<Coment>> getAllComents() {
        List<Coment> coments = service.getAllComents();
        System.out.println(" *******getAllComents***");

        return new ResponseEntity<>(coments, HttpStatus.OK);
    }
/*
    @GetMapping("/dateRange")
    public ResponseEntity<List<Coment>> getComentsByDateRange(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        List<Coment> coments = service.getComentsByDateRange(startDate, endDate);
        return new ResponseEntity<>(coments, HttpStatus.OK);
    }
*/
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Coment>> getComentsByUserId(@PathVariable Integer userId) {
        List<Coment> comments = service.getComentsByUserId(userId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/content/{contentId}")
    public ResponseEntity<List<Coment>> getComentsByUserAndContent(
            @PathVariable Integer userId,
            @PathVariable Integer contentId) {
        List<Coment> coments = service.getComentsByUserAndContent(userId, contentId);
        return new ResponseEntity<>(coments, HttpStatus.OK);
    }

}