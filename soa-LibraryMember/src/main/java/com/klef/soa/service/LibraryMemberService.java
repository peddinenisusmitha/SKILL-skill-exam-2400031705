package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.LibraryMember;

public interface LibraryMemberService
{
	LibraryMember addLibraryMember(LibraryMember lm);
	LibraryMember updateLibraryMember(LibraryMember lm);
	List<LibraryMember> displayAllLibraryMembers();
	 LibraryMember displayLibraryMemberById(Long id);
	 String deleteLibraryMemberById(Long id);
	 List<LibraryMember> findByName(String name);
	 List<LibraryMember> findByType(String type);

}
