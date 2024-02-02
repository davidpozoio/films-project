package films.project.controllers

import films.project.models.Scene
import films.project.services.SceneService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/scenes")
class SceneController (
    val sceneService: SceneService
){
    @GetMapping
    fun findAll() = sceneService.findAll()

    @PostMapping
    fun save(@RequestBody scene: Scene) = sceneService.save(scene)

    @PatchMapping
    fun patch(@RequestBody scene: Scene) = sceneService.save(scene)
}