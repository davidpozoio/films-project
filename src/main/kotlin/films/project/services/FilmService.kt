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

    fun patch(film: Film): Film{
        val filmToPatch = filmRepository.findById(film.id)?:
        throw Exception("film not found")
        filmToPatch.apply {
            name = film.name
            minutes = film.minutes
            director = film.director
        }
        return  filmRepository.save(filmToPatch)
    }

    fun delete(id: Long?): Boolean{
        val film = filmRepository.findById(id)?:throw Exception("film not found");
        filmRepository.deleteById(id!!)
        return true
    }
}