package films.project.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "film")
class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null
    var director: String? = null
    @Column(name="duration_seconds")
    var durationSeconds: Float? = null

    @JsonIgnore
    @OneToMany(mappedBy = "film", cascade = [CascadeType.ALL], orphanRemoval = true)
    var scenes: List<Scene>? = null

    @JsonIgnore
    @OneToMany(mappedBy = "film", cascade = [CascadeType.ALL], orphanRemoval = true)
    var characters: List<Character>? = null
}