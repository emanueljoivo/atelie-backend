package br.edu.ufcg.ccc.daca.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "solicitations")
public class Solicitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "solicitation_id", nullable = false)
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "solicitation_sender", nullable = false)
    private Sender sender;

    @NotNull
    @Basic(optional = false)
    @Column(name = "solicitation_content", nullable = false)
    private String content;

    public Solicitation(){}

    public Solicitation(Long id, Sender sender, String content){
        this.id = id;
        this.sender = sender;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solicitation that = (Solicitation) o;

        if (!id.equals(that.id)) return false;
        return sender.equals(that.sender);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + sender.hashCode();
        return result;
    }

    public Long getId() {
        return id;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}