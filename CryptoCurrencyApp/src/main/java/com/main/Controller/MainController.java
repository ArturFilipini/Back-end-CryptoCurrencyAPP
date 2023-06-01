package com.main.Controller;

import com.main.Entity.ImageEntity;
import com.main.Pojos.PojoTest;
import com.main.Repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/main")
@AllArgsConstructor
public class MainController {
    private ImageRepository repository;
    @GetMapping("hello")
    @RolesAllowed("user")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("test")
    @RolesAllowed("user")
    @CrossOrigin
    public List<PojoTest> test(){
        List<PojoTest> testando = new ArrayList<>();
        testando.add(new PojoTest("Artur", "Sexo"));
        testando.add(new PojoTest("kek", "num sei"));
        return testando;
    }
    @PostMapping("upload")
    @CrossOrigin
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
        try {
            ImageEntity image = new ImageEntity();
            image.setDescription(file.getName());
            image.setImage(file.getBytes());

            repository.save(image);
            return ResponseEntity.ok("Image uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error uploading image.");
        }
    }

    @GetMapping("image")
    @CrossOrigin
    @RolesAllowed("admin")
    public ResponseEntity<List<ImageEntity>> getImages(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("admin")
    @RolesAllowed("admin")
    public ResponseEntity<String> admin(){
        return ResponseEntity.ok("Hello Admin");
    }
}
