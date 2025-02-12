package com.gupta.journal_App.controller;

import com.gupta.journal_App.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getById(@PathVariable long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntry(@RequestParam long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateEntry(@RequestParam long id, @RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);
    }
}
