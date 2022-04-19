package cmcglobal.ebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique=true)
    private String code;
    private String name;

    private Boolean status = true;

    public Provider(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Provider() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = !this.status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
