package films.project.repository

import films.project.models.Character
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CharacterRepository: JpaRepository<Character, Long> {
    fun findById(id: Long?): Character?
}