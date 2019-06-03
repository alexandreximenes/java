package br.com.perceptron.marketplace.domains;

import br.com.perceptron.marketplace.response.ResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class AbstractEntity implements Serializable, IDomain {

    private static final long serialVersionUID = 1L;
    private static ResponseDTO<AbstractEntity> responseDTO = new ResponseDTO<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Version
    private int version;


    @PreUpdate
    @PrePersist
    private void updateDate() {
        if (this.createdAt != null) {
            this.createdAt = LocalDateTime.now();
        } else {
            this.updatedAt = LocalDateTime.now();
        }
    }

    public static boolean codeIDisValid(Long id) {
        if (id == null || id == 0) return false;
        return id > 0;
    }

}
