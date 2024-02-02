package films.project.controllers

import films.project.models.Character
import films.project.services.CharacterService
import org.springframework.web.bind.annotation.GetMapping
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
}