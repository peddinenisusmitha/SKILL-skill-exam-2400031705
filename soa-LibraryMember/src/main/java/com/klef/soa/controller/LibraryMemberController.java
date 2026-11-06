package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.LibraryMember;
import com.klef.soa.service.LibraryMemberService;

@RestController
@RequestMapping("/librarymember")
public class LibraryMemberController
{
    @Autowired
    private LibraryMemberService service;

    // Insert Library Member
    @PostMapping("/add")
    public ResponseEntity<LibraryMember> addLibraryMember(@RequestBody LibraryMember lm)
    {
        return ResponseEntity.ok(service.addLibraryMember(lm));
    }

    // Update Library Member
    @PutMapping("/update")
    public ResponseEntity<LibraryMember> updateLibraryMember(@RequestBody LibraryMember lm)
    {
        LibraryMember member = service.updateLibraryMember(lm);

        if(member != null)
        {
            return ResponseEntity.ok(member);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    // Display All Library Members
    @GetMapping("/displayall")
    public ResponseEntity<List<LibraryMember>> displayAllLibraryMembers()
    {
        return ResponseEntity.ok(service.displayAllLibraryMembers());
    }

 // Display Library Member By ID
    @GetMapping("/display")
    public ResponseEntity<?> displayLibraryMemberById(@RequestParam Long libraryMemberId)
    {
        LibraryMember member = service.displayLibraryMemberById(libraryMemberId);

        if(member != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(member);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Library Member ID Not Found");
        }
    }

    // Delete Library Member By ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLibraryMemberById(@PathVariable Long id)
    {
        String message = service.deleteLibraryMemberById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Find Library Members By Name
    @GetMapping("/findbyname/{name}")
    public ResponseEntity<List<LibraryMember>> findByName(@PathVariable String name)
    {
        return ResponseEntity.ok(service.findByName(name));
    }

    // Find Library Members By Type
    @GetMapping("/findbytype/{type}")
    public ResponseEntity<List<LibraryMember>> findByType(@PathVariable String type)
    {
        return ResponseEntity.ok(service.findByType(type));
    }
}