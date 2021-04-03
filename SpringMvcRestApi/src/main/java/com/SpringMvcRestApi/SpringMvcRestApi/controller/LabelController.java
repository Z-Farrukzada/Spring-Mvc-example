package com.SpringMvcRestApi.SpringMvcRestApi.controller;

import com.SpringMvcRestApi.SpringMvcRestApi.model.LabelEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.service.LabelService;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.LabelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/labels")
@RequiredArgsConstructor
public class LabelController {

    private final LabelService labelService;


    @GetMapping
    public List<LabelDTO> getAllLabels(){
        return labelService.getAllLabels();
    }

    @GetMapping("/{labelId}")
    public Optional<LabelDTO> getLabelById(@PathVariable("labelId") Long labelId){
        return labelService.getLabelById(labelId);
    }

    @PostMapping("/create")
    public LabelDTO save(@RequestBody LabelDTO labelDTO){
        return labelService.save(labelDTO);
    }

    @PutMapping("/update/{labelId}")
    public Optional<LabelDTO> update(@PathVariable("labelId") Long labelId,@RequestBody LabelDTO labelDto){
        return labelService.update(labelId,labelDto);
    }

    @DeleteMapping("/{labelId}")
    public void deleteById(@PathVariable  Long labelId){
         labelService.deleteById(labelId);
    }


}
