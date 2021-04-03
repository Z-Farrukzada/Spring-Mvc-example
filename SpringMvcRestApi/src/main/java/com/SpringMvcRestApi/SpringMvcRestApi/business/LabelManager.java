package com.SpringMvcRestApi.SpringMvcRestApi.business;

import com.SpringMvcRestApi.SpringMvcRestApi.model.LabelEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.repository.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LabelManager {

    private final LabelRepository labelRepository;

    public List<LabelEntity> getAllLabels(){
        for (LabelEntity label : labelRepository.findAll()) {

        }
        return labelRepository.findAll();
    }

    public Optional<LabelEntity> getLabelById(Long id){
        return labelRepository.findById(id);
    }

    public LabelEntity save(LabelEntity labelEntity){
        return labelRepository.save(labelEntity);
    }

    public Optional<LabelEntity> update(Long id, LabelEntity labelEntity){
        return labelRepository.findById(id).map(pro-> labelRepository.save(labelEntity));
    }


    public void deleteById(Long labelId){
       LabelEntity labelEntity= labelRepository.findById(labelId)
               .orElseThrow(() -> new NoSuchElementException("LabelEntity not found with id " +  labelId));
       labelRepository.delete(labelEntity);
    }


}
