package com.example.PetStore.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Tag {
    @Id
    @SequenceGenerator(

            name="tag_sequence",
            sequenceName="tag_sequence",
            allocationSize=1

    )
    @GeneratedValue(

            strategy=GenerationType.SEQUENCE,
            generator="tag_sequence"
    )
    private int id;
    private String name;
}
