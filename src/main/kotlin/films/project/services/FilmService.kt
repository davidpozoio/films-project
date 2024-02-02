package films.project.services

import films.project.models.Film
import films.project.repository.FilmRepository
import org.springframework.stereotype.Service

@Service
class FilmService(
    val filmRepository: FilmRepository
) {
    fun findAll() = filmRepository.findAll()
    fun save(film: Film) = filmRepository.save(film)
}