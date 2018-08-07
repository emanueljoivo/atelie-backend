package br.edu.ufcg.ccc.daca.backend.solicitation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "SENDERS")
public class Sender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @NotNull
    @Basic(optional = false)
    private String name;

    @NotNull
    @Basic(optional = false)
    private String email;

    public Sender(){}

    public Sender(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sender sender = (Sender) o;
        return Objects.equals(id, sender.id) &&
                Objects.equals(name, sender.name) &&
                Objects.equals(email, sender.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
