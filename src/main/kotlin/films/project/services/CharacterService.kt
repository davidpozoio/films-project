package films.project.services

import films.project.models.Character
import films.project.repository.CharacterRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class CharacterService (
    val characterRepository: CharacterRepository
){
    fun findAll() = characterRepository.findAll()

    fun save(@RequestBody character: Character) = characterRepository.save(character)
}