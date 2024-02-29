package films.project.services

import films.project.models.Character
import films.project.repository.CharacterRepository
import films.project.repository.SceneRepository
import org.springframework.stereotype.Service

@Service
class CharacterService (
    val characterRepository: CharacterRepository,
    val sceneRepository: SceneRepository
){
    fun findAll() = characterRepository.findAll()

    fun save(character: Character): Character{
        val scene = sceneRepository.findById(character.scene?.id)
        val allCharacters = characterRepository.findAllBySceneId(scene?.id)
        var totalBudget = character.budget!!.toDouble()
        allCharacters.forEach {
            totalBudget += it.budget!!
        }
        if(totalBudget > scene?.budget!!){
            throw Exception("scene budget exceeded")
        }

        return  characterRepository.save(character)
    }

    fun patch(character: Character): Character{
        val characterToPatch = characterRepository.findById(character.id)?:
        throw Exception("character not found")

        characterToPatch.apply {
            name = character.name
            budget = character.budget
        }

        return save(characterToPatch)
    }

    fun deleteById(id: Long) = characterRepository.deleteById(id)
}