package films.project.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "film")
class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null
    var director: String? = null
    var minutes: Long? = null

    @JsonManagedReference
    @OneToMany(mappedBy = "film", cascade = [CascadeType.ALL], orphanRemoval = true)
    var scenes: List<Scene>? = null
}