package films.project.services

import films.project.models.Scene
import films.project.repository.FilmRepository
import films.project.repository.SceneRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class SceneService (
    val sceneRepository: SceneRepository,
    val filmRepository: FilmRepository
){
    fun findAll() = sceneRepository.findAll()

    fun save(scene: Scene): Scene{
        val film = filmRepository.findById(scene.film?.id)
        val allScenes = sceneRepository.findAllByFilmId(film?.id)
        var totalDuration = scene.minutes!!.toFloat()
        allScenes.forEach {
            totalDuration += it.minutes!!
        }
        if(totalDuration > film?.minutes!!){
            throw Exception("film duration exceeded")
        }
        return sceneRepository.save(scene)
    }

    fun patch(scene: Scene): Scene{
        val sceneToPatch = sceneRepository.findById(scene.id)?:
        throw Exception("scene not found")
        sceneToPatch.apply {
            name = scene.name
            minutes = scene.minutes
            budget = scene.budget
        }

        return save(sceneToPatch)
    }

    fun delete(id: Long?): Boolean{
        sceneRepository.deleteById(id!!)
        return  true
    }
}