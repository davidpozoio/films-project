package films.project.repository

import films.project.models.Film
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FilmRepository: JpaRepository<Film, Long> {
    fun findById(id: Long?): Film?
}