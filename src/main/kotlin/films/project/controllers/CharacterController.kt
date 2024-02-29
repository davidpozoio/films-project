package films.project.controllers

import films.project.models.Character
import films.project.services.CharacterService
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/characters")
class CharacterController(
    val characterService: CharacterService
) {
    @GetMapping
    fun findAll() = characterService.findAll()

    @PostMapping
    fun save(@RequestBody character: Character) = characterService.save(character)

    @PatchMapping
    fun patch(@RequestBody character: Character) = characterService.patch(character)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = characterService.deleteById(id)
}