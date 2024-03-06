package org.neoris.crud.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.neoris.crud.entity.Libros;

@ApplicationScoped
public class LibrosRepository implements PanacheRepository<Libros> {

}
