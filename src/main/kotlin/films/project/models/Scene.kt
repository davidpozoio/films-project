package films.project.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "scene")
class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null
    var minutes: Long? = null
    var budget: Double? = null

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "film_id")
    var film: Film? = null

    @JsonManagedReference
    @OneToMany(mappedBy = "scene", cascade = [CascadeType.ALL], orphanRemoval = true)
    var characters: List<Character>? = null
}