package com.task.service;

import com.task.entity.Label;
import com.task.repository.LabelRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    public ResponseEntity<?> addLabel(Label label) {
        if (labelRepository.existsByName(label.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Label name must be unique.");
        }
        labelRepository.save(label);
        return ResponseEntity.status(HttpStatus.CREATED).body(label);
    }

    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    public ResponseEntity<?> deleteLabel(Integer id) {
        if (labelRepository.existsById(id)) {
            labelRepository.deleteById(id);
            return ResponseEntity.ok("Label deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Label does not exist.");
        }
    }
}
