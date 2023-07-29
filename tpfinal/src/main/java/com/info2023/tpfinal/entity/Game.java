package com.info2023.tpfinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID uuid;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String title;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String description;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Developer> developers = new ArrayList<>();

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private List<GameTask> tasks = new ArrayList<>();
}


/**
 * TOCA REVISAR PORQUE NO ME FUNCIONA EL METODO getDevelopersOfGame DEL GAMECONTROLLER, ME SIGGUE TIRANDO ERROR 500
 * TAMBIEN, TENGO QUE REVISAR LOS CONTROLLER DE DEVELOPER Y GAMETASK, PARA VER QUE SE ESTE DANDO BIEN LAS COSAS Y
 * DETERMINAR SI SIGO UTILIZANDO DTOs O NO... AUNQUE ES MUY PROBABLE QUE SI... QUEDARIA ENTONCES REVISAR LO QUE ANOTE
 * ANTERIORMENTE, SUMADO A COMPROBAR LA FUNCIONALIDAD DE LA APPI FUNCIONAN COMO TIENEN QUE.
 * TAMBIEN EMPEZAR A VER COMO HACER LA RELACIONES ENTRE ATRIBUTOS PARA EL TEMA DE LA BASE DE DATOS (HABLAR CON JOSE)
 * QUEDA POR SEGUIR REVISANDO LA LOGICA Y PROBAR QUE LOS REQUEST ESTEN FUNCIONANDO BIEN.
 * TENGO QUE HACER TEST UNITARIOS (JUNIT Y MOCKITO) PARA VER SI SACO UN POQUITO DE PUNTOS EXTRA.
 * TENGO QUE REVISAR SOBRE VALIDATION Y TAMBIEN HACERLO.... SUMAR MAS PUNTITOS EXTRA.
 *
 *
 *
 * 25/7/2023 -- SEGUIR BUSCANDO SOBRE RELACIONES PARA SOLUCIONAR EL CONTROLLER TANTO DEL GAME COMO DEL DEVS Y DEL GAMETASK
 *
 * BUSCAR Y PROBAR ALOJANDO LA INFORMACION NECESARIO DEL REQUEST EN UNA 'BANDERA' DONDE GUARDE LA INFORMACION NECESARIA
 * Y GUARDARLO EN ESE LUGAR PARA LUEGO PEDIR EN EL REQUEST DESDE AHI!
 */