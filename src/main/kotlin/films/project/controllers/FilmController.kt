package films.project.controllers

import films.project.models.Film
import films.project.services.FilmService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @PatchMapping
    fun patch(@RequestBody film: Film) = filmService.patch(film)

    @DeleteMapping("/{id}")











    fun delete(@PathVariable("id") id: Long?) = filmService.delete(id)
}