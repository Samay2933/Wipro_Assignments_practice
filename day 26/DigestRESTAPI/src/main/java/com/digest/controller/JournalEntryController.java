package com.digest.controller;

import com.digest.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long,JournalEntry> journalEntries = new HashMap<>();

    @GetMapping //localhost:8080/journal  GET
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry (@RequestBody JournalEntry myEntry){ //localhost:8080/journal  POST
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);
    }




}
