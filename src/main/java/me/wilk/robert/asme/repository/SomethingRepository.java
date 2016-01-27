package me.wilk.robert.asme.repository;

import me.wilk.robert.asme.entity.Something;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Robert Wilk
 *         Created on 1/20/2016.
 */
@Repository
public interface SomethingRepository extends JpaRepository<Something, Long> { }
