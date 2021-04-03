package com.SpringMvcRestApi.SpringMvcRestApi.service;

import com.SpringMvcRestApi.SpringMvcRestApi.business.LabelManager;
import com.SpringMvcRestApi.SpringMvcRestApi.model.LabelEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.LabelDTO;
import com.remondis.remap.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabelService {

    private final LabelManager labelManager;
    private final Mapper<LabelEntity, LabelDTO> labelEntityDtoMapper;
    private final Mapper<LabelDTO, LabelEntity> labelDTOEntityMapper;

    public List<LabelDTO> getAllLabels() {
        return labelEntityDtoMapper.map(labelManager.getAllLabels());
    }

    public Optional<LabelDTO> getLabelById(Long labelId) {
        return labelManager.getLabelById(labelId).map(labelEntityDtoMapper::map);
    }

    public LabelDTO save(LabelDTO labelDTO) {
        return labelEntityDtoMapper.map(labelManager.save(labelDTOEntityMapper.map(labelDTO)));

    }

    public Optional<LabelDTO> update(Long labelId, LabelDTO labelDTO) {
        return labelManager.update(labelId, labelDTOEntityMapper.map(labelDTO)).map(labelEntityDtoMapper::map);
    }

    public void deleteById(Long labelId) {
        labelManager.deleteById(labelId);
    }

}
