package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.ClassificationBriefDto;
import com.rined.psr.portal.dto.fully.ClassificationDto;
import com.rined.psr.portal.services.ClassificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClassificationController {
    private final ClassificationService classificationService;

    @PostMapping("/classification")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClassification(@Valid @RequestBody ClassificationBriefDto classificationBriefDto) {
        classificationService.addClassification(classificationBriefDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/classification")
    public List<ClassificationDto> getAllClassifications() {
        return classificationService.getAllClassifications();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/classification/{id}")
    public void updateClassification(@PathVariable("id") long id,
                                     @Valid @RequestBody ClassificationDto classificationDto) {
        classificationService.updateClassification(id, classificationDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/classification/{id}")
    public ClassificationDto getClassificationById(@PathVariable("id") long id) {
        return classificationService.getClassificationById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/classification/{id}")
    public void deleteClassificationById(@PathVariable("id") long id){
        classificationService.deleteClassificationById(id);
    }
}
