package com.epam.aicode.springpr.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime expiredAfter;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, expiredAfter);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name)
                && Objects.equals(expiredAfter, other.expiredAfter);
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", expiredAfter=" + expiredAfter + "]";
    }
}
