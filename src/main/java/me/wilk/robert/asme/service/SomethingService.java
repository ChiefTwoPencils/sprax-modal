package me.wilk.robert.asme.service;

import me.wilk.robert.asme.entity.Something;
import me.wilk.robert.asme.repository.SomethingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author Robert Wilk
 *         Created on 1/20/2016.
 */
@Service
public class SomethingService {

    @Autowired
    SomethingRepository somethingRepository;

    public Something findOne(Long id) {
        return somethingRepository.findOne(id);
    }

    public List<Something> findAll() {
        return somethingRepository.findAll();
    }

    public Something save(Something something) {
        return somethingRepository.save(something);
    }

    public List<Something> save(Iterable<Something> somethings) {
        return somethingRepository.save(somethings);
    }

    public void delete(Long id) {
        somethingRepository.delete(id);
    }

    public void delete(Something something) {
        somethingRepository.delete(something);
    }
}
