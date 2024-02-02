package films.project.controllers

import films.project.models.Film
import films.project.services.FilmService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/films")
class FilmController (
    val filmService: FilmService
){
    @GetMapping
    fun findAll() = filmService.findAll()

    @PostMapping
    fun save(@RequestBody film: Film) = filmService.save(film)
}