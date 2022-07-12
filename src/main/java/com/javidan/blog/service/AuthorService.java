package com.javidan.blog.service;

import com.javidan.blog.dto.AuthorDTO;
import com.javidan.blog.dto.DTOMapper;
import com.javidan.blog.entity.Author;
import com.javidan.blog.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO createAuthor(AuthorDTO dto){
        Author author = DTOMapper.mapToEntity(dto);
        return DTOMapper.mapToDTO(authorRepository.save(author));
    }

    public Page<Author> getAllAuthors(Pageable pageable){
        return authorRepository.findAll(pageable);
    }
}
