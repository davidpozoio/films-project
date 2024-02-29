package films.project.repository

import films.project.models.Character
import films.project.models.Scene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CharacterRepository: JpaRepository<Character, Long> {
    fun findById(id: Long?): Character?

    @Query("SELECT * FROM character WHERE scene_id = :sceneId", nativeQuery = true)
    fun findAllBySceneId(@Param("sceneId") sceneId: Long?): List<Character>
}