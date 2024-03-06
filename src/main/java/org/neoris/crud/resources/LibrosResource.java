package org.neoris.crud.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.neoris.crud.entity.Libros;
import org.neoris.crud.repository.LibrosRepository;
import org.neoris.crud.exeptions.LibroNotFoundException;

import java.util.List;

@Path("/libros")
@Transactional
public class LibrosResource {

    @Inject
    private LibrosRepository librosDAO;

    @GET
    public List<Libros> getAllLibros() {
        return librosDAO.listAll();
    }

    @GET
    @Path("{id}")
    public Libros getLibroById(@PathParam("id") Long id) {
        var book=librosDAO.findById(id);
        return book;
    }



    @POST
    public Libros create(Libros createdLibro) {
        librosDAO.persist(createdLibro);
        return createdLibro;
    }


    @DELETE
    @Path("{id}")
    public void deleteLibro(@PathParam("id") Long id) {
        librosDAO.deleteById(id);
    }

    @PUT
    @Path("{id}")
    public void updateLibro(@PathParam("id") Long id, Libros updatedLibro) {
        var existingLibro = librosDAO.findById(id);
        if (existingLibro != null) {
            existingLibro.setIsbn(updatedLibro.getIsbn());
            existingLibro.setTitulo(updatedLibro.getTitulo());
            existingLibro.setAutor(updatedLibro.getAutor());
            existingLibro.setFechaPublicacion(updatedLibro.getFechaPublicacion());
            existingLibro.setCalificacion(updatedLibro.getCalificacion());
            librosDAO.persist(existingLibro);
        }else
        {

            throw new LibroNotFoundException("El libro con ID " + id + " no existe.");

        }

    }




}

