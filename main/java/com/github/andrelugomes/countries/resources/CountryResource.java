package com.github.andrelugomes.countries.resources;

import com.github.andrelugomes.countries.entities.Country;
import com.github.andrelugomes.countries.repositories.CountryRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.debugger.Page;

@RestController
@RequestMapping("/countries")
public class CountryResource {

  
  private final CountryRepository repository;

  public CountryResource(final CountryRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/countries")
  public Page<Country> countries(Pageable page) {
    return repository.findAll(page);
  }
  @GetMapping("/{id}")
  public Country getOne(@PathVariable Long id) {
    Optional<Country> optional = repository.findById(id)

    if (optional.isPresent()) {
      return ResponseEntity.ok().body(optional.get());
    } else {
        return ResponseEntity.notFound().build();
    }


  }


}
