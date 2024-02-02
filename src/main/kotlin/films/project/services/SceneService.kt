package films.project.services

import films.project.models.Scene
import films.project.repository.SceneRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class SceneService (
    val sceneRepository: SceneRepository
){
    fun findAll() = sceneRepository.findAll()

    fun save(scene: Scene): Scene{
        val remainingTime = scene.film!!.durationSeconds!! - scene.durationSeconds!!
        if( remainingTime < 0){

        }
        return sceneRepository.save(scene)
    }

    fun patch(scene: Scene): Scene{
        val sceneToPatch = sceneRepository.findById(scene.id)?:
        throw Exception("scene not found")

        return sceneRepository.save(scene)
    }
}