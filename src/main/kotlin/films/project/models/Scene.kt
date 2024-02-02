package films.project.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "scene")
class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null
    @Column(name="duration_seconds")
    var durationSeconds: Float? = null

    @ManyToOne
    @JoinColumn(name = "film_id")
    var film: Film? = null

}