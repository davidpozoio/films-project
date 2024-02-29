package films.project.repository

import films.project.models.Scene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface SceneRepository: JpaRepository<Scene, Long> {
    fun findById(id: Long?): Scene?

    @Query("SELECT * FROM scene WHERE film_id = :filmId", nativeQuery = true)
    fun findAllByFilmId(@Param("filmId") filmId: Long?): List<Scene>
}