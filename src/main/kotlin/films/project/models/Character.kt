package films.project.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "character")
class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "scene_id")
    var scene: Scene? = null

    var budget: Double? = null
}