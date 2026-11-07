package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.LibraryMember;
import com.klef.soa.repository.LibraryMemberRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LibraryMemberRepositoryTest
{
    @Autowired
    private LibraryMemberRepository repository;

    // Test 1 - Find All
    @Test
    void testFindAll()
    {
        List<LibraryMember> members = repository.findAll();

        assertNotNull(members);
        System.out.println("Total Members: " + members.size());
    }

    // Test 2 - Find By ID
    @Test
    void testFindById()
    {
        List<LibraryMember> members = repository.findAll();

        assertFalse(members.isEmpty());

        Long id = members.get(0).getId();

        Optional<LibraryMember> member = repository.findById(id);

        assertTrue(member.isPresent());
        assertEquals(id, member.get().getId());

        System.out.println("Member ID: " + member.get().getId());
    }

    // Test 3 - Find By Name
    @Test
    void testFindByName()
    {
        List<LibraryMember> members = repository.findAll();

        assertFalse(members.isEmpty());

        String name = members.get(0).getName();

        List<LibraryMember> result = repository.findByName(name);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(name, result.get(0).getName());

        System.out.println("Member Name: " + name);
    }

    // Test 4 - Count
    @Test
    void testCount()
    {
        long count = repository.count();

        assertTrue(count >= 0);

        System.out.println("Total Members: " + count);
    }

    // Test 5 - Find By Type
    @Test
    void testFindByType()
    {
        List<LibraryMember> members = repository.findAll();

        assertFalse(members.isEmpty());

        String type = members.get(0).getType();

        List<LibraryMember> result = repository.findByType(type);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        assertEquals(type, result.get(0).getType());

        System.out.println("Member Type: " + type);
    }
}
