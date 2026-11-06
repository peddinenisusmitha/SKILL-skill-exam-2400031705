package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.LibraryMember;

@Repository
public interface LibraryMemberRepository extends JpaRepository<LibraryMember, Long>
{
    
    List<LibraryMember> findByName(String name);

    
    List<LibraryMember> findByType(String type);
}