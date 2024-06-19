package ru.fisenko.urlRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fisenko.urlRestApp.models.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, String> {
    Url findFirstByUrlIsNotNull();
}
