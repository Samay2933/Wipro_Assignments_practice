package com.task.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.task.entity.Label;
import com.task.service.LabelService;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @PostMapping
    public ResponseEntity<?> addLabel(@RequestBody Label label) {
        return labelService.addLabel(label);
    }

    @GetMapping
    public ResponseEntity<List<Label>> getAllLabels() {
        return ResponseEntity.ok(labelService.getAllLabels());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLabel(@PathVariable Integer id) {
        return labelService.deleteLabel(id);
    }
}
