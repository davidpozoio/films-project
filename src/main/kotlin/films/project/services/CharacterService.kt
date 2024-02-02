package films.project.services

import films.project.models.Character
import films.project.repository.CharacterRepository
import org.springframework.stereotype.Service

@Service
class CharacterService (
    val characterRepository: CharacterRepository
){
    fun findAll() = characterRepository.findAll()

    fun save(character: Character) = characterRepository.save(character)

    fun patch(character: Character): Character{
        val characterToPatch = characterRepository.findById(character.id)?:
        throw Exception("character not found")
        return  characterRepository.save(character)
    }
}