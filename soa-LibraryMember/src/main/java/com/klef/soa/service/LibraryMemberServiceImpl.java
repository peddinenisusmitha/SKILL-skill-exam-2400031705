package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.LibraryMember;
import com.klef.soa.repository.LibraryMemberRepository;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService
{
    @Autowired
    private LibraryMemberRepository repo;

    @Override
    public LibraryMember addLibraryMember(LibraryMember lm)
    {
        return repo.save(lm);
    }

    @Override
    public LibraryMember updateLibraryMember(LibraryMember lm)
    {
        Optional<LibraryMember> optional = repo.findById(lm.getLibraryMemberId());

        if(optional.isPresent())
        {
            LibraryMember member = optional.get();

            member.setName(lm.getName());
            member.setType(lm.getType());
            member.setStatus(lm.getStatus());
            member.setLocation(lm.getLocation());

            return repo.save(member);
        }
        else
        {
            return null;
        }
    }

    @Override
    public List<LibraryMember> displayAllLibraryMembers()
    {
        return repo.findAll();
    }

    @Override
    public LibraryMember displayLibraryMemberById(Long id)
    {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String deleteLibraryMemberById(Long id)
    {
        boolean flag = repo.existsById(id);

        if(flag)
        {
            repo.deleteById(id);
            return "Library Member Deleted Successfully";
        }
        else
        {
            return "Library Member ID Not Found";
        }
    }

    @Override
    public List<LibraryMember> findByName(String name)
    {
        return repo.findByName(name);
    }

    @Override
    public List<LibraryMember> findByType(String type)
    {
        return repo.findByType(type);
    }
}